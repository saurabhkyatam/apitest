def code

node('java-agent') {
  stage('Checkout') {
    checkout scm
  }

  stage('Load') {
    code = load 'apicallgetalljob.groovy'
  }

  stage('Execute') {
    code.example1()
  }
}
