/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
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
            "start gradlew bootRun &"
            
        }
        stage('Rest') {
            //
            "curl -X GET 'http://localhost:8898/rest/mscovid/test?msg=testing'"
        }
        stage('Nexus') {
                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Luis Garrido\\Desktop\\Devops\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
        }

}

return this;