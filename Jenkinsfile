


pipeline{
    environment {
        PROD_BRANCH = 'master'
        STAGING_BRANCH = 'staging'
        user_env_input = 'Development'
         registryCredential = 'docker_hub_creds'
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
        stage('Docker Build') {
            steps {
               
                echo 'Docker building...'
                 sh 'chmod +x gradlew'
                //https://index.docker.io/v1/
              
                script {
                    docker.withRegistry( ' https://index.docker.io', registryCredential ) {
                        dockerImg =  docker.build("${GIT_COMMIT}/${BUILD_NUMBER}", "./") 
                    }
                }
                
            }
        }
        
        stage('Printing docker images') {
    steps {
        script {
            def listCatalog = sh script: "ls ", returnStdout: true
            def arrayExample=[]
            listCatalog.split().each {
              arrayExample << it
            }
            echo "${arrayExample}"
        }
    }
}
       
        
       
    }

}
