

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
        
        stage('Unit Tests') {
            steps {
                sh './gradlew test'
                echo 'Building..'
            }
        }
         stage 'Test report'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
 
 stage('Code Coverage with jaccoco'){
            steps{   
        jacoco()
            }
        }
        
        
      
        
    }

}
