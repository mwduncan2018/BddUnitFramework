pipeline {
  agent any
  stages {
    stage('Stage1') {
      steps {
        sh 'echo "DEMO IS $DEMO"'
      }
    }

  }
  environment {
    DEMO = '1'
  }
}