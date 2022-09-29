import com.seh.util.checkoutSCM;
import com.seh.util.buildCompileApp;
import com.seh.util.uploadArtifacts;
import com.seh.util.staticCodeAnalysis;
import com.seh.util.deployAll;
//scripted pipeline

def call(Map pipelineParams)
{
  env.REPO_NAME=pipelineParams.REPO_NAME
  env.GIT_GROUP=pipelineParams.GIT_GROUP
  pipeline
  {
    try {
      node(pipelineParams.BUILD_NODE)
      {
        stage("Checkout SCM")
        {
          new checkoutSCM().call(pipelineParams)
        }
        stage("Build Provisioning")
        {
          new buildCompileApp().call(pipelineParams)
        }
        stage("Static Code Analysis") {
          new staticCodeAnalysis().call(pipelineParams)
        }
        stage("Upload to Artifact Nexus Repo") {
          new uploadArtifacts().call(pipelineParams)
        }
        stage("create dockerimage and push to ECR")
        {
          //new imageCreationAndPushToECR().call(pipelineParams)
        }
        stage("deploy application using ECS")
        {
          new deployAll().call(pipelineParams)
        }
      }
    }
    catch(Exception e) {
      throw e
    }
    finally{
      cleanWs()
    }
  }
}

