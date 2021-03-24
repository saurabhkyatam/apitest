def code

node {
  stage('Checkout') {
   checkout scm
  }

  stage('Load') {
    code = load 'apicallgetalljob.groovy'
     println code
  }
    stage('excute')
    {
        def token =code.getToken()
        code.getJob(token)
    }
  
}
