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
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY, MCS_IDKEY);
		if (videoResp!=null)
		{
			VideosPendientes.add(videoResp);
		}
	}
	
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		VideoResponse videoConJson = HttpRequestor.post(videoResponse.getVideoResponseURL(), "", MCS_IDKEY, videoResponse.getVideoKey());
		videoResponse.setContent(videoConJson.getContent());
		cargarCuerpos(videoResponse);
	}
	
	
	
	private void cargarCuerpos(VideoResponse videoResponse)
	{
		// aqui proceso el Json creando los objetos Cuerpo que vienen
		// en el Json y los meto uno a uno en la lista de Cuerpos
	}
}
