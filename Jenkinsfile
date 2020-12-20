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
                    buildStatus =  buildStatus ?: 'SUCCESSFUL'

                    // Default values
                    def colorName = 'RED'
                    def colorCode = '#FF0000'
                    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
                    def summary = "${subject} (${env.BUILD_URL})"

                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
            println "Este es el mensaje " + env.TAREA +  ' ' + env.JOB_NAME
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: summary)
            // slackSend message: '[LUIS GARRIDO][env.JOB_NAME][NAMETOOLS: NAMETOOLS][Ejecucion Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            println NAMETOOLS
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME] [NAMETOOLS] [Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
