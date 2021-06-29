pipeline{
    agent any
    stages{
        stage('clone repo'){
            steps{
                bat "rmdir /Q /S my-app" 
                bat "mvn clean -f my-app"
            }
        }
        stage('Test'){
            steps{
                bat "mvn test -f my-app"
            }
        }
        stage('Deploy'){
            steps{
                bat "mvn package -f my-app"
            }
        }
    }
}