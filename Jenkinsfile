pipeline {
  agent any

  environment {
    DEMO='1.3'
    RELEASE='DEEP'
  }
  
  stages {
    stage('Build') {
      agent any
      environment {
        LOG_LEVEL='INFO'
      }
      steps {
        echo "BUILD STAGE!"
        echo "DEMO is ${DEMO}"
        echo "Building release ${RELEASE} with log level ${LOG_LEVEL}..."
      }
    }
    stage('Test') {
      steps {
        echo "TEST STAGE!"
        echo "DEMO is ${DEMO}"
        echo "Testing for release ${RELEASE}"
      }
    }
  }
}
