package crowly.connectors;

import java.util.ArrayList;

import crowly.library.*;

public class MSClient implements IConstants
{
	private ArrayList<Cuerpo> Cuerpos;
	private ArrayList<VideoResponse> VideosPendientes;
	
	public ArrayList<Cuerpo> getCuerpos() {
		return Cuerpos;
	}

	public ArrayList<VideoResponse> getVideosPendientes() {
		return VideosPendientes;
	}
	
	public MSClient()
	{
		Cuerpos = new ArrayList<Cuerpo>();
		VideosPendientes = new ArrayList<VideoResponse>();
	}
	
	public void procesarVideo(String pURLVideo)
	{
		// puedo tener el URL hardcoded y aqui armo el PayLoad
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		String ResponseResult = HttpRequestor.post(MCS_URL, payload);
		
		int posStart = ResponseResult.indexOf(CAMBIO_LINEA);
		
		String location="", key="";
		
		while (posStart>0) {
			String line = ResponseResult.substring(0, posStart);
			if (line.contains(LOCATION_RESULT_URL_KEY)){
				location = line.substring(line.indexOf(":")+2, line.length());
			}
			
			if (line.contains(LOCATION_RESULT_ACCESS_KEY)){
				key = line.substring(line.indexOf(":")+2, line.length());
				break;
			}
			
			ResponseResult = ResponseResult.substring(line.length(),ResponseResult.length());
			posStart = ResponseResult.indexOf(CAMBIO_LINEA);
		}
		VideoResponse video = new VideoResponse(location, key);
		VideosPendientes.add(video);
	}
	
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		String payload = RESPONSE_BODY.replace("@@KEY@@", videoResponse.getVideoKey());
		String JsonResult = HttpRequestor.post(videoResponse.getVideoResponseURL(), payload);
		cargarCuerpos(JsonResult);
	}
	
	
	
	private void cargarCuerpos(String pJsonResultado)
	{
		// aqui proceso el Json creando los objetos Cuerpo que vienen
		// en el Json y los meto uno a uno en la lista de Cuerpos
	}
}
