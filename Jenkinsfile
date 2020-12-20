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
                    //def NAMETOOLS = params.herramientas
                    env.SUMMARY = "${NAMETOOLS}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"

                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
            println "Este es el mensaje " + env.SUMMARY

                    

                    // Default values
            
            
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
            //slackSend message: '[LUIS GARRIDO][' ${env.JOB_NAME}  '][Ejecucion Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            println "Este es el mensaje " + env.SUMMARY
            //println NAMETOOLS
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: env.SUMMARY)
            //slackSend message: '[LUIS GARRIDO][env.JOB_NAME] [NAMETOOLS] [Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
