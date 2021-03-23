def code

node {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'apicallgetalljob.groovy'
  }

  stage('Execute') {
    def token =code.getToken()
    code.getJob(token)
  }
}
