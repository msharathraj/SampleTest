

pipeline {
         agent any
         stages {
                 stage('One') {
                 steps {
                     echo 'Hi'
                 }
                 }
                 stage('Two') {
                 steps {
                    input('Do you want to proceed?')
                 }
                 }
                 stage('Three') {
                 
                 steps {
                       echo "Hello"
                 }
                 }
                 stage('Four') {
                 parallel { 
                            stage('Unit Test') {
                           steps {
                                echo "Running the unit test..."
                           }
                           }
                            stage('Integration test') {
                              
                              steps {
                                echo "Running the integration test..."
                              }
                           }
                           }
                           }
              }
}
