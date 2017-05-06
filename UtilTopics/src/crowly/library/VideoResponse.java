package crowly.library;

public class VideoResponse {
	private String VideoResponseURL;
	private String VideoKey;
	private boolean Procesado;
	
	public VideoResponse(String pURL, String pKey)
	{
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Procesado = false;
	}

	public String getVideoResponseURL() {
		return VideoResponseURL;
	}

	public void setVideoResponseURL(String videoResponseURL) {
		VideoResponseURL = videoResponseURL;
	}

	public String getVideoKey() {
		return VideoKey;
	}

	public void setVideoKey(String videoKey) {
		VideoKey = videoKey;
	}

	public boolean isProcesado() {
		return Procesado;
	}

	public void setProcesado(boolean procesado) {
		Procesado = procesado;
	}
	
	
}
