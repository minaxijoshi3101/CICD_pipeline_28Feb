package com.seh.util

def call(Map pipelineParams)
{
   env.SCM_URL="git@github.com:"+pipelineParams.GIT_GROUP+"/"+pipelineParams.REPO_NAME+".git"
   echo "Code checkout from SCM Repo"
    sh '''
    rm -f $REPO
    git clone $SCM_URL
    '''
}
