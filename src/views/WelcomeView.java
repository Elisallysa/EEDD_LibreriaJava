package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeView {

	private JFrame frame;
	private final JLabel lblWelcome = new JLabel("Bienvenido a Librer\u00EDa Java");
	private JButton btnTienda;
	private JButton btnLogout;
	private JButton btnCarrito;
	

	/**
	 * Create the application.
	 */
	public WelcomeView() {
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
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 34, 436, 36);
		frame.getContentPane().add(lblWelcome);
		
		btnTienda = new JButton("Ir a la tienda");
		btnTienda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTienda.setBounds(21, 107, 182, 36);
		frame.getContentPane().add(btnTienda);
		
		btnLogout = new JButton("Cerrar sesi\u00F3n");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(129, 154, 182, 36);
		frame.getContentPane().add(btnLogout);
		
		btnCarrito = new JButton("Ir al carrito");
		btnCarrito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarrito.setBounds(229, 107, 182, 36);
		frame.getContentPane().add(btnCarrito);
	}
	
	public void configureUIListeners() {
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ProductosView();
			frame.dispose();
			}
		});
		
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CarritoView();
			frame.dispose();
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new LoginView();
			frame.dispose();
			}
		});
	}

}
