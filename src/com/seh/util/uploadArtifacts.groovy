package com.seh.util

def call(Map pipelineparams)
{
    echo "started"
    mvn deploy
    echo "artifacts $REPO_NAME uploaded successfully..."
}