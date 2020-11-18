package controller;

import model.Usuario;
import view.JFTelaLogin;

public class UsuarioController {
	
	private Usuario model;
	private JFTelaLogin view;
	  
	public UsuarioController(Usuario model, JFTelaLogin view){
		this.model = model;
		this.view = view;
	} 
  
	public int getIdUsuario(String nome){
		return model.getIdUsuario();
	}
	  
	public void setIdUsuario(int idUsuario){
		model.setIdUsuario(idUsuario);
	}
	
	public String getUsuarioLogin() {
		return model.getUsuarioLogin();
	}
	  
	public void setUsuarioLogin(String usuarioLogin) {
		model.setUsuarioLogin(usuarioLogin);
	}
	
	public String getUsuarioSenha() {
		return model.getUsuarioSenha();
	}
	
	public void setUsuarioSenha(String usuarioSenha) {
		model.setUsuarioSenha(usuarioSenha);;
	}
	
	public boolean isUsuarioAdministrador() {
		return model.isUsuarioAdministrador();
	}
	
	public void setUsuarioAdministrador(boolean usuarioAdministrador) {
		model.setUsuarioAdministrador(usuarioAdministrador);
	}
  
}