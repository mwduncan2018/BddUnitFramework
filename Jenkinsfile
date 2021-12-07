pipeline {
  agent any

  environment {
    RELEASE='9.8'
    BUILD_NUMBER='1'
    DEMO='Pluralsight'
  }
  
  stages {
    stage('Build') {
      environment {
        LOG_LEVEL='INFO'
      }
      steps {
        echo "This is build number ${BUILD_NUMBER} for release ${RELEASE} for ${DEMO} demo and log level is ${LOG_LEVEL}"
        sh '''
          chmod +x temp.sh
          ./temp.sh
        '''
      }
    }      
    stage('Test') {
      environment {
        LOG_LEVEL='WARNING'
      }
      steps {
        echo 'TEST STAGE!'
        echo "Release is ${RELEASE} and demo is ${DEMO} and log level is ${LOG_LEVEL}"
      }
    }
    stage('Deploy') {
      input {
        message 'Hey, do you want to deploy?'
        ok 'DO IT NOW!'
        paramters {
          string(name: 'TARGET_ENVIRONMENT', defaultValue: 'PROD', description: 'Target deployment environment')
        }
      }
    }
  }
  post {
    always {
      echo 'This always prints!'
    }
  }
}
