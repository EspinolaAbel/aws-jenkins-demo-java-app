pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                failure {
                    echo 'Los test fallaron'
                }
            }
        }
        stage('Deploy to AWS') {
            steps([$class: 'BapSshPromotionPublisherPlugin']) {
                echo 'Subiendo build a AWS'
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: "aws-jenkins-demo",
                            verbose: true,
                            transfers: [
                                sshTransfer(sourceFiles: "target/*.jar", removePrefix: "target/", remoteDirectory: "deploy"),
                                sshTransfer(sourceFiles: "docker/*", removePrefix: "docker/", remoteDirectory: "deploy"),
                                sshTransfer(execCommand: "cd deploy && /bin/sh docker-script.sh")
                            ]
                        )
                    ]
                )
            }
            post {
                success {
                    echo 'Se finalizó el deploy a servidor de AWS'
                }
            }
        }
    }
    post {
        success {
            echo "El pipeline se ejecutó exitosamente"
        }
        failure {
            echo "Error inesperado"
        }
    }
}