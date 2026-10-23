pipeline {
    agent any

    environment {
        APP_IMAGE = 'aiapplication'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '=== Checking out repository from GitHub ==='
                checkout scm
            }
        }

        stage('Compile & Test (CI)') {
            steps {
                echo '=== Running Maven Tests ==='
                sh './mvnw clean test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build Package (CI)') {
            steps {
                echo '=== Packaging Application JAR ==='
                sh './mvnw package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Build Docker Image (CD)') {
            steps {
                echo '=== Building Docker Image ==='
                sh 'docker build -t ${APP_IMAGE}:${BUILD_NUMBER} -t ${APP_IMAGE}:latest .'
            }
        }

        stage('Deploy (CD)') {
            steps {
                echo '=== Deploying Application Container ==='
                sh '''
                    # Stop existing container if running
                    docker stop aiapplication || true
                    docker rm aiapplication || true

                    # Run new container on port 8081 (to avoid conflict with Jenkins on 8080)
                    docker run -d \
                      --name aiapplication \
                      --network host \
                      -e SERVER_PORT=8081 \
                      ${APP_IMAGE}:latest
                '''
            }
        }
    }

    post {
        success {
            echo "CI/CD Pipeline succeeded! Build #${BUILD_NUMBER} is deployed."
        }
        failure {
            echo "Pipeline failed! Check the console logs."
        }
    }
}
