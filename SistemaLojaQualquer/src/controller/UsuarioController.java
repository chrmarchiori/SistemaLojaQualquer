package controller;

import java.util.List;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	private static UsuarioController instance;

	private Usuario model;
	private UsuarioDAO usuarioDAO;

	private UsuarioController() {
	}

	public static UsuarioController getInstance() {
		if (instance == null) {
			instance = new UsuarioController();
		}
		return instance;
	}

	public void iniciaDadosUsuario(Usuario model, UsuarioDAO usuarioDAO) {
		this.model = model;
		this.usuarioDAO = usuarioDAO;
	}

	public int getIdUsuario(String nome) {
		return model.getIdUsuario();
	}

	public void setIdUsuario(int idUsuario) {
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
		model.setUsuarioSenha(usuarioSenha);
	}

	public boolean isUsuarioAdministrador() {
		return model.isUsuarioAdministrador();
	}

	public void setUsuarioAdministrador(boolean usuarioAdministrador) {
		model.setUsuarioAdministrador(usuarioAdministrador);
	}

	public void RealizaLogin(String usuarioLogin, char[] senha) {
		String strPass = new String(senha).trim();
		this.model = usuarioDAO.getUsuario(usuarioLogin, strPass);
	}

	public Usuario getUsuarioLogado() {
		return this.model;
	}

	public List<Usuario> getAllUsuarios() {
		return usuarioDAO.getAllUsuarios();
	}

	public Usuario getUsuarioByLoginPassword(String usuarioLogin, String senha) {
		return usuarioDAO.getUsuario(usuarioLogin, senha);
	}

	public void saveOrUpdate(Usuario usuario) {
		Integer idUsuario = usuario.getIdUsuario();
		if (idUsuario == -1) {
			usuarioDAO.SalvarUsuario(usuario);
		} else
			usuarioDAO.EditarUsuario(usuario);
	}

}