pipeline {
  agent any

  environment {
    RELEASE='21.04'
  }
  
  stages {
    stage('Build') {
      agent any
      environment {
        LOG_LEVEL='INFO'
      }
      steps {
        echo "BUILD STAGE!"
        echo "Version is ${env.RELEASE}"
        echo "Building release with log level ${LOG_LEVEL}..."
      }
    }
    stage('Test') {
      steps {
        echo "TEST STAGE!"
        echo "Version is ${env.RELEASE}"
        echo "Testing for release"
      }
    }
    stage('Deploy') {
      input {
        message 'Deploy?'
        ok 'Do it!'
        parameters {
          string(name: 'TARGET_ENVIRONMENT', defaultValue: 'PROD', description: 'Target deployment environment')
        }
      }
      steps {
        echo "Deploying release ${RELEASE} to environment ${TARGET_ENVIRONMENT}"
      }
    }
    post {
      always {
        echo "Always print this message"
      }
    }
  }
}
