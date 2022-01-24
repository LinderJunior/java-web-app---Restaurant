package DTO;

public class Parceiros {
	
	private int id;
	private String email;
	private String telefone;
	private String gps_latitude;
	private String gps_longitude;
	private String youtube_videouid;
	
	
	public Parceiros(int id, String email, String telefone, String gps_latitude, String gps_longitude,
			String youtube_videouid) {
		super();
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.gps_latitude = gps_latitude;
		this.gps_longitude = gps_longitude;
		this.youtube_videouid = youtube_videouid;
	}


	public Parceiros() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getGps_latitude() {
		return gps_latitude;
	}


	public void setGps_latitude(String gps_latitude) {
		this.gps_latitude = gps_latitude;
	}


	public String getGps_longitude() {
		return gps_longitude;
	}


	public void setGps_longitude(String gps_longitude) {
		this.gps_longitude = gps_longitude;
	}


	public String getYoutube_videouid() {
		return youtube_videouid;
	}


	public void setYoutube_videouid(String youtube_videouid) {
		this.youtube_videouid = youtube_videouid;
	}
	
	

}
