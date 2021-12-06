pipeline {
  agent any

  environment {
    RELEASE='25.04'
  }
  
  stages {
    stage('Build') {
      environment {
        LOG_LEVEL='INFO'
      }
      
      steps {
        echo "Building release ${RELEASE} with log level ${LOG_LEVEL}..."
        sh 'chmod +x temp.sh'
        sh '''
          ./temp.sh
        '''
      }
    }
    
    stage('Test') {
      steps {
        echo "Testing release ${RELEASE}"
        script {
          if (Math.random() > 0.5) {
            throw new Exception()
          }
        }
        writeFile file: 'test-results.txt', text: 'passed'
      }
    }
  }
  
  post {
    success {
      archiveArtifacts 'test-results.txt'
    }
    failure {
      echo 'BUILD FAILED!'
    }
    always {
      echo "Always print this message"
    }
  }
}
