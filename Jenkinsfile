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
            println env.TAREA
            slackSend message: '[LUIS GARRIDO][JOB_NAME][NAMETOOLS][Ejecución Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            println NAMETOOLS
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME] [NAMETOOLS] [Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
