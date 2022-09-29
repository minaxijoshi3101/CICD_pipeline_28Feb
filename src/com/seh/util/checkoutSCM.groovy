package com.seh.util

def call(Map pipelineParams)
{
   env.SCM_URL="git@github.com:"+pipelineParams.GIT_GROUP+"/"+pipelineParams.REPO_NAME+".git"
   echo "Code checkout from SCM Repo"
    sh '''
    rm -rf $REPO_NAME
    git clone $SCM_URL
    '''
}
