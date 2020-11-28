package DAO;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	public void SalvarUsuario(Usuario usuario);

	public Usuario getUsuario(String usuarioLogin, char[] usuarioSenha);

	public List<Usuario> getAllUsuarios();
}