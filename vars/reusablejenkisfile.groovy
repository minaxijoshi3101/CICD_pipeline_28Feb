import com.seh.util.checkoutSCM;
import com.seh.util.buildCode;
def call(Map pipelineParams)
{
  env.REPO=pipelinesParams.REPO
  env.GIT_GROUP=pipelinesParams.GIT_GROUP
  pipeline
  {
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
        new imageCreationAndPushToECR().call(pipelineParams)
      }
    }
  }
}
