package view;

import controller.UsuarioController;
import model.Usuario;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario model = new Usuario();
        
        new JFTelaLogin().run();

        //UsuarioController controller = new UsuarioController(model, view);

	}

}
