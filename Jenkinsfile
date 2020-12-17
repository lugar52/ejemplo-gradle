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

                    def ejecucion = (params.herramientas == 'gradle') ? load 'gradle.groovy' : load 'maven.groovy'

                }
            }
        }
    }
}
