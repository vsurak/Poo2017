package crowly.connectors;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequestor 
{

	public static String post(String pUrl, String pPayload)
	{
		String result = "";
		
		try 
		{
			URL obj = new URL(pUrl);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "MOZILLA/5.0");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(pPayload);
			wr.flush();
			wr.close();
	
			int responseCode = con.getResponseCode();
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//print result
		return result;
	}
	
	public static void main(String args[])
	{
		String postMessage = "HTTP/1.1 "+
			"Content-Type: application/json\n"+
			"Host: westus.api.cognitive.microsoft.com\n"+
			"Ocp-Apim-Subscription-Key: 799dca11f3ca4e67b75c9aa34848823b\n"+
			"{ \"url\":\"http://www.example.com/sample.mp4\" } ";
		String url = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
		System.out.println(HttpRequestor.post(url, postMessage));
	}
}
