package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAOImpl extends GenericDAO implements UsuarioDAO {

	private Connection connection = null;

	public UsuarioDAOImpl() throws SQLException, ClassNotFoundException {
		this.connection = getConnection("sistemalojaqualquer");
	}

	public void SalvarUsuario(Usuario usuario) {

		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO usuario " + "(usuarioLogin, usuarioSenha, usuarioAdministrador)"
					+ "VALUES(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getUsuarioLogin());
			pstmt.setString(2, usuario.getUsuarioSenha());
			pstmt.setBoolean(3, usuario.isUsuarioAdministrador());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public Usuario getUsuario(String usuarioLogin, char[] usuarioSenha) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String strPass = new String(usuarioSenha).trim();

		try {
			String sql = "SELECT * " + "FROM usuario " + "WHERE usuarioLogin = ? AND usuarioSenha = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuarioLogin);
			pstmt.setString(2, strPass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
				usuario.setUsuarioSenha(rs.getString("usuarioSenha"));
				return usuario;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}
	}

	public List<Usuario> getAllUsuarios() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			String sql = "SELECT * " + "FROM usuario";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
				usuario.setUsuarioSenha(rs.getString("usuarioSenha"));
				usuario.setUsuarioAdministrador(rs.getBoolean("usuarioSenha"));
				usuarios.add(usuario);
			}

			return usuarios;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}

	}

}