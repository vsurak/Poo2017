package crowly.library;


public interface IConstants {
	public final String POST_BODY = "HTTP/1.1 "+
			"Content-Type: application/json\n"+
			"Host: westus.api.cognitive.microsoft.com\n"+
			"Ocp-Apim-Subscription-Key: 799dca11f3ca4e67b75c9aa34848823b\n"+
			"{ \"url\":\"@@URL@@\" } ";
	
	public final String RESPONSE_BODY = "HTTP/1.1 "+
			"Content-Type: application/json\n"+
			"Host: westus.api.cognitive.microsoft.com\n"+
			"Ocp-Apim-Subscription-Key: 799dca11f3ca4e67b75c9aa34848823b\n"+
			"apim-request-id: @@KEY@@";
	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1";
	
	public final String[] LISTA_VIDEOS = {
			"http://gdurl.com/9KHx/download",
			"http://gdurl.com/9KHx/download",
			"http://gdurl.com/9KHx/download"
	};
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 25000;
}
