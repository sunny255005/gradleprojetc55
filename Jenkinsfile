


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
//            def map = [IMAGE:""]
//             def listCatalog = sh script: "docker history 6998c176eb3fb4e95ff2c1f0981428124a61bdbf/23 ", returnStdout: true
//             def arrayExample=[]
            
//             listCatalog.split().each {
//               arrayExample << it
//                 echo "${it}"
//             }
//             echo "${arrayExample}"
            
def  FILES_LIST = sh (script: "docker history 6998c176eb3fb4e95ff2c1f0981428124a61bdbf/23  --format '{{.ID}}' ", returnStdout: true)
 def readContent = readFile 'build.txt'
writeFile file: 'build.txt', text: readContent+"${FILES_LIST}"
           
            
            def file = readFile("${workspace}/build.txt")
          //  sh 'echo dd ${list}'
        def lines = file.readLines()

lines.each { String line ->
  println line
}
            
            
            //  def listOfFolder = sh script: "ls $WORKSPACE/a", returnStdout: true

    def myArray=[]
    FILES_LIST.split().each { 
        myArray << it
    }
    
    print myArray
    print myArray.size()
            
            for (i in myArray) {
                sh 'docker image rm i'
  println "now got ${i}"
}
            
            
            
            //sh'cut -d, -f1 build.txt'
//echo "${FILES_LIST}>>nice.txt"
            //sh "echo ${FILES_LIST} >> build.txt"
//sh 'awk -F , '{print $1}' build.txt'


        }
    }
}
       
        
       
    }

}
