pipeline {
  agent any

  environment {
    BUILD_NUMBER='1'
    RELEASE='9.9'
    DEMO='Pluralsight'
  }
  
  stages {
    stage('Alpha') {
      steps {
        echo "This is build number ${BUILD_NUMBER} for release ${RELEASE} for ${DEMO} demo"
        sh '''
          echo "Multiple line shell step!"
          chmod +x temp.sh
          ./temp.sh
        '''
      }
    }      
  }
}
