pipeline {
    agent any

    parameters { choice(name: 'herramientas', choices: ['gradle', 'maven'], description: '') }

    stages {
        stage('Pipeline'){
            steps {
                script {
                    println 'Herramientas de ejecucion seleccionadas: ' + params.herramientas
                    //env.SUMMARY = "'[Luis Garrido] ${env.JOB_NAME} [${params.herramientas}] [Ejecucion exitosa]'"

                    def pipe = load "${params.herramientas}.groovy"
                    pipe.call()

                }
            }
        }
    }
}
