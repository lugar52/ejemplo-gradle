pipeline 
{
    agent any

    parameters { choice(name: 'herramientas', choices: ['gradle', 'maven'], description: '') }
    
    
    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {
                    println 'Herramientas de ejecucion seleccionadas: ' + params.herramientas
                    def NAMETOOLS = params.herramientas


                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
            println "Este es el mensaje " + env.TAREA +  ' ' + env.JOB_NAME

                    

                    // Default values
            def subject = "${NAMETOOLS}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
            
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: summary)
            //slackSend message: '[LUIS GARRIDO][' ${env.JOB_NAME}  '][Ejecucion Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            //println NAMETOOLS
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME] [NAMETOOLS] [Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
