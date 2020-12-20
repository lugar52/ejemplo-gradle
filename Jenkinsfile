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
                    env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.herramientas}] [Ejecucion exitosa]'"

                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()
                }
            }
        }
    }
    post {
        success {
                println "Este es el mensaje " + env.SUMMARY

                def message = "${env.SUMMARY} 'Ejecucion exitosa'"
                slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: message)
        }

        failure {
                println env.TAREA
                println "Este es el mensaje " + env.SUMMARY
                def message = "${env.SUMMARY} 'Ejecución fallida en stage' [${env.TAREA}]"
                slackSend(teamDomain: 'luisgarrido', tokenCredentialId: 'Slack_tokens', message: message)
        }
    }
}
