package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	private JFrame frame;
	private JTextField tfNombreUsuario;
	private JPasswordField pwfPassword;
	private JLabel lblNombreUsuario;
	private JLabel lblPassword;
	private JLabel lblTitulo;
	private JButton btnAcceder;

	
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		configureUIComponents();
		configureUIListeners();
		
	}
	
	public void configureUIComponents() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(35, 88, 174, 27);
		frame.getContentPane().add(lblNombreUsuario);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(35, 137, 174, 27);
		frame.getContentPane().add(lblPassword);
		
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(188, 88, 208, 27);
		frame.getContentPane().add(tfNombreUsuario);
		tfNombreUsuario.setColumns(10);
		
		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(188, 139, 208, 27);
		frame.getContentPane().add(pwfPassword);
		
		lblTitulo = new JLabel("Acceso clientes");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(35, 25, 361, 35);
		frame.getContentPane().add(lblTitulo);
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(176, 201, 85, 21);
		frame.getContentPane().add(btnAcceder);
	}
	
	public void configureUIListeners() {
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login(tfNombreUsuario.getText(), String.valueOf(pwfPassword.getPassword()))) {
					frame.dispose();
					new WelcomeView();
			} else {
				JOptionPane.showMessageDialog(btnAcceder, "Revisa el usuario y la contraseña");
			}
			}
		});
	}
	
	public boolean login(String usuario, String password) {
		if (usuario.equals("user")&&password.equals("pass")) {
			return true;
		}else {
			return false;
		}
	}
}
