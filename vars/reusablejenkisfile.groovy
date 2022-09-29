import com.seh.util.checkoutSCM;
import com.seh.util.buildCode;
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
      stage("checkout SCM")
      {
        new checkoutSCM().call(pipelineParams)
      }
      stage("build")
      {
        new buildCode().call(pipelineParams)
      }
      stage("create dockerimage and push to ECR")
      {
        //new imageCreationAndPushToECR().call(pipelineParams)
      }
      stage("deploy application using kubernetes")
      {
        new deployAll().call(pipelineParams)
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

