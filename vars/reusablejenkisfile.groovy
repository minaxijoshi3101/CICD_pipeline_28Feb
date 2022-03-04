import com.seh.util.checkoutSCM;
def call(Map pipelineParams)
{
  
  pipeline
  {
    node()
    {
      stage("checkout SCM")
      {
        new checkoutSCM().call(pipelineParams)
      }
      stage("build")
      {
      }
      stage("create dockerimage and push to ECR")
      {
      }
    }
  }
}
