pipeline {
  agent any

  environment {
    RELEASE='24.04'
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
        writeFile file: 'test-results.txt', text: 'passed'
      }
    }
  }
  
  post {
    always {
      echo "Always print this message"
    }
    success {
      archiveArtifacts 'test-results.txt'
    }
  }
}
