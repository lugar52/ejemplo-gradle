pipeline 
{
    agent any

    parameters { choice(name: 'herramientas', choices: ['gradle', 'maven'], description: '') }
    
    env.NAMETOOLS = params.herramientas
    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {
                    println 'Herramientas de ejecucion seleccionadas: ' + params.herramientas
                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
            println env.TAREA
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME][env.NAMETOOLS][Ejecución Exitosa]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'
        }

        failure {
            println env.TAREA
            println env.NAMETOOLS
            slackSend message: '[LUIS GARRIDO][env.JOB_NAME][env.NAMETOOLS][Ejecución fallida en][env.TAREA]', teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens'

        }
    }
}
