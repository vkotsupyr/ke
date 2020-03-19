pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SER_CRED = credentials('global')
    }
    stages {
        stage('Build') {
            steps {
                echo "Building version ${NEW_VERSION}"
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
                echo "E2E with cred ${SER_CRED}"
            }
        }
    }
}
