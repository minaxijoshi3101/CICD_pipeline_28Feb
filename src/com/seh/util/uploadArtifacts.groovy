package com.seh.util

def call(Map pipelineparams)
{
    mvn clean deploy
    echo "artifacts $REPO_NAME uploaded successfully..."
}