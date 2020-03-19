pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building'
                withGradle {
                    sh './gradlew -v'
                }
            }
        }
        stage('Test') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
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
