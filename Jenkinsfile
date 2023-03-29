


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
//         stage('Docker Build') {
//             steps {
               
//                 echo 'Docker building...'
//                  sh 'chmod +x gradlew'
//                 //https://index.docker.io/v1/
              
//                 script {
//                     docker.withRegistry( ' https://index.docker.io', registryCredential ) {
//                         dockerImg =  docker.build("${GIT_COMMIT}/${BUILD_NUMBER}", "./") 
// //                          docker.image("${GIT_COMMIT}/${BUILD_NUMBER}").withRun() { container ->
// //                                 println container.id
// //                                 println container.name
// //                             }
                        
                     
//                     }
//                 }
                
//             }
//         }
        
        stage('Printing docker images') {
    steps {
        script {
           
            def listCatalog = sh script: "docker history 6998c176eb3fb4e95ff2c1f0981428124a61bdbf/23 ", returnStdout: true
            def arrayExample=[]
            listCatalog["IMAGE"].split().each {
              arrayExample << it
                echo "${it}"
            }
            echo "${arrayExample}"
        }
    }
}
       
        
       
    }

}
