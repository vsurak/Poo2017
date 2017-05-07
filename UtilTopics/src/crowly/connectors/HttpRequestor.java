package crowly.connectors;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import crowly.library.IConstants;
import crowly.library.VideoResponse;

public class HttpRequestor implements IConstants
{

	public static VideoResponse post(String pUrl, String pPayload, String pMSKey, String pResponseKey)
	{
		VideoResponse result = null;
		
		HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder(pUrl);

            /*
            builder.setParameter("sensitivityLevel", "{string}");
            builder.setParameter("frameSamplingValue", "{number}");
            builder.setParameter("detectionZones", "{string}");
            builder.setParameter("detectLightChange", "{boolean}");
            builder.setParameter("mergeTimeThreshold", "{number}");
            */
            
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);
            request.setHeader("apim-request-id", pResponseKey);

            // Request body
            StringEntity reqEntity = new StringEntity(pPayload);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
                                                
            if (entity != null) 
            {
                String location = response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?response.getHeaders(LOCATION_RESULT_URL_KEY)[0].getValue() : "";
                String key = response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?response.getHeaders(LOCATION_RESULT_ACCESS_KEY)[0].getValue() : "";            	
                System.out.println(EntityUtils.toString(entity));
                result = new VideoResponse(location, key, EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		return result;
	}
}
