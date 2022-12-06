


pipeline{
    environment {
        PROD_BRANCH = 'master'
        STAGING_BRANCH = 'staging'
        user_env_input = 'Development'
    }
    
    

    agent any
    tools { 
       gradle'gradle7' 
       
    } 
   
    stages {
        stage('Which environment to build?') {
            steps {
            sh 'echo which environment to build'       
            }
        }
        stage('Confirm') {
            steps {
                script {
             
                        input("Do you want to proceed building in ${user_env_input} environment?")
                    }
                }
            
        }
        stage('Clean Build') {
            steps {
                sh 'gradle clean build'
                echo 'Building..'
            }
        }
        
        stage('Sonar qube') {
            steps {
                withSonarQubeEnv(installationName: 'sonarqube-server', credentialsId: 'sonarqube-secret-token') {
                    

                     sh './gradlew sonarqube \
  -Dsonar.projectKey=test-key-1 \
  -Dsonar.host.url=http://localhost:9000 \
-Dsonar.login=admin \
 -Dsonar.password=password '

                    
                }
            }
        }

        stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }



       

        }   
    }
}


