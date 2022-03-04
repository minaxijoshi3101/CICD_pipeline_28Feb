import com.seh.util.checkoutSCM;
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
        new buildAndCreateImage().call(pipelineParams)
      }
      stage("create dockerimage and push to ECR")
      {
      }
    }
  }
}
