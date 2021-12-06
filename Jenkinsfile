pipeline {
  agent any

  environment {
    RELEASE='20.04'
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
  }
}
