package com.seh.util

def call(Map pipelineparams)
{
    sh """
    echo "build the java code using maven"
    cd $REPO_NAME/springmvc
    mvn deploy
    echo "artifacts $REPO_NAME uploaded successfully..."
    """
}