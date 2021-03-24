

import groovy.json.*
import org.apache.http.client.methods.*

import org.apache.http.impl.client.*
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

    def getToken() {
      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("grant_type", "client_credentials"));
            nameValuePairs.add(new BasicNameValuePair("client_id", "b337f964-6322-4675-b545-b30bce7137cf@6d14682b-68a6-4a25-af3d-06615e146b1e"));
            nameValuePairs.add(new BasicNameValuePair("client_secret", "p+DLdqlYRWdECdoqT9xaULTknfA/zQ2tSSbh4q5kqnE="));
            nameValuePairs.add(new BasicNameValuePair("resource","00000003-0000-0ff1-ce00-000000000000/drlglobal.sharepoint.com@6d14682b-68a6-4a25-af3d-06615e146b1e "));
            

// build HTTP POST

def url = 'https://accounts.accesscontrol.windows.net/6d14682b-68a6-4a25-af3d-06615e146b1e/tokens/OAuth/2'
def post = new HttpPost(url)

post.addHeader("content-type","application/x-www-form-urlencoded")
post.addHeader("Cookie", "esctx=AQABAAAAAAD--DLA3VO7QrddgJg7WevrORfQqCFXaNckOmdJfBsRPpJI2flg8CF2-A5BUxzdtolVLpzLNNnpoAvXCEcnVJiSwhhsn6xzZK731i0GskzuwCdspCHajEoZoaanpIXqKBbesg9w9pVqB33fTNWaeqz6zojTiin4_JMNScE9z3CBLSwr1YhI5jXzzXS0UVXlzoAgAA; x-ms-gateway-slice=estsfd; stsservicecookie=estsfd; fpc=AtTRNt9-gKdLoVSw6wpL13ABGv5BAQAAANkh6tcOAAAA")
post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

// execute 

def client = HttpClientBuilder.create().build()
def response = client.execute(post)

def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))


def slurper = new JsonSlurper()
def resultMap = slurper.parseText(bufferedReader.getText())
def token_type =resultMap.token_type
def access_token=resultMap.access_token
return token_type +' '+ access_token

   } 
 def getJob(String token)
{

def select
def top 


// build HTTP POST
def url = "https://drlglobal.sharepoint.com/sites/HybridArch/DevSecOps/_api/web/lists/getbytitle('Configuration')/items?$select=*&$top=100"

def post = new HttpGet(url)
post.addHeader("Accept", "application/json;odata=nometadata")
post.addHeader("Authorization", token)
// execute 
def client = HttpClientBuilder.create().build()
def response = client.execute(post)

def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
def jsonResponse = bufferedReader.getText()
 def output = JsonOutput.prettyPrint(jsonResponse)
println(output); 


}
	
return this