

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;




public class testWithNet {

		 private static String url = "http://localhost:8080/HelloWorld/Helloworld";
//		 URL uri=new URL();
//		 uri.s

		  public static void main(String[] args) throws ParseException, URISyntaxException {
		    // Create an instance of HttpClient.
		    CloseableHttpClient client = HttpClients.createDefault();

		    List<NameValuePair> pairs= new ArrayList<>(); 	//used in post
		    pairs.add(new BasicNameValuePair("user", "nk"));
		    
		    // Create a method instance.
		    
		    URIBuilder uri=new URIBuilder(url).addParameter("user","nk");

//		    uri.se
		    
		    HttpGet method = new HttpGet(uri.build());
//		    method.setHeader("Content-Type","multipart/form-data");
//		    method.setHeader("name","nk");
//		    HttpEntity ent = pairs.
		    method.setEntity(new UrlEncodedFormEntity(pairs));
		    try {
				CloseableHttpResponse httpResponse = client.execute(method);
				System.out.println(httpResponse.getCode());
				
				
				HttpEntity entity = httpResponse.getEntity();
				String jsonStr = EntityUtils.toString(entity);
				System.out.println(jsonStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    // Provide custom retry handler is necessary
		   
		    }
		}