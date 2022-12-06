


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
  -Dsonar.login=sqp_91aeb2f710a235e2030c7f6b31708e48bbbf43a5'

                    
                }
            }
        }

       

        }   
    }


