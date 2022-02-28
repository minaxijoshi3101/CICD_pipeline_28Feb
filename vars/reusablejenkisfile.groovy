def call(Map pipelineParams)
{
  pipeline
  {
    node()
    {
      stage("checkout SCM")
      {
        
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
