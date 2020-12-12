package model;

public class Usuario {

	private int idUsuario;
	private String usuarioLogin;
	private String usuarioSenha;
	private boolean usuarioAdministrador;

	public Usuario() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String getUsuarioSenha() {
		return usuarioSenha;
	}

	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}

	public boolean isUsuarioAdministrador() {
		return usuarioAdministrador;
	}

	public void setUsuarioAdministrador(boolean usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}

}