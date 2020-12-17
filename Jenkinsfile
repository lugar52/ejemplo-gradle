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
                    
                    if (params.tool == 'gradle') 
                    {
                        def ejecucion = load 'gradle.groovy'
                    } else 
                    {
                        def ejecucion = load 'maven.groovy'
                    }
                    ejecución.call()"                 
                }
            }
        }
    }
}
