pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building'
                withgGradle() {
                    sh './gradlew -v'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
        stage('E2E') {
            steps {
                echo 'E2E'
            }
        }
    }
}
