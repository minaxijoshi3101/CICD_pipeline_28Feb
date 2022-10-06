package com.seh.util

def call(Map pipelineparams)
{
    echo "perform static code analysis using sonar"
    withSonarQubeEnv('SonarQubeScanner') {
        sh '''
             echo "mvn -version"
             mvn sonar:sonar
         '''
   }
}
