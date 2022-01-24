package DTO;

public class Usuario {
	private int id_usuario;
	private String usuario;
	private String senha;
	private String contacto;
	private String email;
	private String nivel_acesso;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id_usuario, String usuario, String senha, String contacto, String email, String nivel_acesso) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.senha = senha;
		this.contacto = contacto;
		this.email = email;
		this.nivel_acesso = nivel_acesso;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNivel_acesso() {
		return nivel_acesso;
	}

	public void setNivel_acesso(String nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}

	
	
}
