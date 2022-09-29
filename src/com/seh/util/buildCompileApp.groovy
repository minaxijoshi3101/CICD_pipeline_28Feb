package com.seh.util;

def call(Map pipelineParams)
{
  if (pipelineParams.APPTYPE=="JAVA")
  {
  sh '''
  echo "build the java code using maven"
  cd $REPO_NAME/springmvc
  mvn clean package
  '''
  }
  else if (pipelineParams.APPTYPE=="NODE")
  {
    sh '''
    echo "build the node application using npm"
    cd $REPO_NAME
    npm start
    '''
  }
}
