pipeline {
    agent any
    stages {
        stage('Pipeline'){
            steps {
                script {
                    stage('Build & test') {
                        //
                        bat "gradlew clean build"
                    }
                    stage('Sonar') {
                          stage('SonarQube analysis') {
                              // Coresponde a lo que se configuro en tool conffiguration
                            def scannerHome = tool 'Sonar-Scanner';
                              
                            withSonarQubeEnv('Sonar-Server') { 
                              bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
                            }
                          }
                    }
                    stage('Run') {
                        //
                    }
                    stage('Rest') {
                        //
                    }
                    stage('Nexus') {
                        //
                    }
                    
                }
            }
        }
    }
}



