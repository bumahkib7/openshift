pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Docker Build'){
            steps{
                sh 'docker build -t openshift-app .'
            }
        }
        stage('Deploy to OpenShift'){
            steps{
                sh 'oc start-build openshift-app --from-dir=. --follow'
            }
        }
    }
}
