pipeline 
{
    agent any

    parameters { choice(name: 'tool', choices: ['gradle', 'maven'], description: '') }

    stages 
    {
        stage('Pipeline')
        {
            steps 
            {
                script 
                {

                    def ejecucion = (params.tool == 'gradle') ? load gradle.groovy : load maven.groovy

                }
            }
        }
    }
}
