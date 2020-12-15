package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class JFMenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMenuPrincipal frame = new JFMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFMenuPrincipal() {
		setTitle("Sistema Loja Qualquer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 780);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFListaUsuarios().run();
			}
		});
		btnUsuarios.setToolTipText("");
		btnUsuarios.setFont(new Font("Arial", Font.BOLD, 16));
		btnUsuarios.setBorderPainted(false);
		btnUsuarios.setBackground(Color.WHITE);
		btnUsuarios.setBounds(52, 26, 188, 62);
		contentPane.add(btnUsuarios);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JFListaClientes().run();
			}
		});
		btnClientes.setToolTipText("");
		btnClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClientes.setBorderPainted(false);
		btnClientes.setBackground(Color.WHITE);
		btnClientes.setBounds(52, 105, 188, 62);
		contentPane.add(btnClientes);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JFListaProdutos().run();
			}
		});
		btnProdutos.setToolTipText("");
		btnProdutos.setFont(new Font("Dialog", Font.BOLD, 16));
		btnProdutos.setBorderPainted(false);
		btnProdutos.setBackground(Color.WHITE);
		btnProdutos.setBounds(52, 182, 188, 62);
		contentPane.add(btnProdutos);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
