pipeline {
  agent any
  stages {
    stage('Stage1') {
      steps {
        echo 'Demo is $DEMO'
        sh 'echo "DEMO IS $DEMO"'
      }
    }

  }
  environment {
    DEMO = '1'
  }
}