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
                        bat "start gradlew bootRun &"
                        Sleep 20
                    }
                    stage('Rest') {
                        //
                        bat "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
                    }
                    stage('Nexus') {
                        //
                         steps {
                                // logica para subir un artefacto a nexus
                             nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-maven\\ejemplo-maven\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'spring-boot-starter-parent', groupId: 'org.springframework.boot', packaging: 'jar', version: '0.0.1']]]
                         }
                    }
                    
                }
            }
        }
    }
}
