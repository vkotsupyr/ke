pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SER_CRED = credentials('global')
    }
    tools {
     gradle 'Gradle'   
    }
    parameters {
        string(name: 'VERSION', defaultValue: '', description: '')
        choice(name: 'Ver', choices:['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage('Build') {
            steps {
                echo "Building version ${NEW_VERSION}"
                withGradle {
                    sh './gradlew -v'
                }
                sh "gradle build"
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
                echo "deplouing version ${params.Ver}"
            }
        }
        stage('E2E') {
            steps {
                when {
                    expression {
                        params.executeTests
                    }
                }
                echo 'E2E'
                echo "E2E with cred ${SER_CRED}"
               // withCredentials([
                //    usernamePassword(credentials: 'global', usernameVar: USER, passwordVar: PWD)
                //]) {
                 //   sh "some script ${USER} and pass ${PWD}"
                //}
            }
        }
    }
}
