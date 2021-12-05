pipeline {
  agent any

  environment {
    DEMO = '1.3'
  }
  
  stages {
    stage('stage-1') {
      steps {
        sh 'echo "This is demo $DEMO"'
        sh '''
          echo "Using a multi-line shell script"
          chmod +x temp.sh
          ./temp.sh
        '''
      }
    }

  }
}
