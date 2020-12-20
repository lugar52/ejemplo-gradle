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
                    def attachments = [
                        [
                            text: 'I find your lack of faith disturbing!',
                            fallback: 'Hey, Vader seems to be mad at you.',
                            color: '#ff0000'
                        ]
                    ]


                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
            println "Este es el mensaje " + env.TAREA
            slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', attachments: attachments)
            // slackSend message: '[LUIS GARRIDO][env.JOB_NAME][NAMETOOLS: NAMETOOLS][Ejecucion Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            println NAMETOOLS
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME] [NAMETOOLS] [Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
