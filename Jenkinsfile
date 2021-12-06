pipeline {
  agent any

  environment {
    RELEASE='22.04'
  }
  
  stages {
    stage('Build') {
      agent any
      environment {
        LOG_LEVEL='INFO'
      }
      parallel {
        stage('linux-arm64') {
          steps {
            echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL}..."
          }
        }
        stage('linux-amd64') {
          steps {
            echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL}..."
          }
        }
        stage('windows-amd64') {
          steps {
            echo "Building release ${RELEASE} for ${STAGE_NAME} with log level ${LOG_LEVEL}..."
          }
        }
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
  }
  post {
    always {
      echo "Always print this message"
    }
  }
}
