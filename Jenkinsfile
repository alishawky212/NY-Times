pipeline {
  agent {
  	label 'android'
  }
    stage ('Lint') {
      steps {
        sh './gradlew clean lintDebug'
        androidLint(pattern: 'app/build/reports/**/lint-results.xml')
      }
    }

    stage('Unit tests') {
      steps {
        sh './gradlew  jacocoTestReport'
          jacoco(execPattern: 'app/build/jacoco/*.exec', exclusionPattern: '**/R.class,**/R$*.class,**/BuildConfig.*,**/Manifest*.*,**/*Test*.*,android/**/*.*')
      }
    }
  }
}
