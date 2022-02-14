package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.LibreriaDAO;
import dao.PedidoDAO;
import models.Pedido;
import models.Producto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class ProductosView {

	private JFrame frame;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfFecha;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblFechaPublicacion;
	private JButton btnAddToBasket;
	private JButton btnBackToMenu;
	private JButton btnBack;
	private JButton btnForward;
	private JLabel lblUnidades;
	private JTextField tfAnoEdicion;
	private JTextField tfPrecio;
	private JLabel lblAnoEdicion;
	private LibreriaDAO libreriaDAO;
	private JLabel lblPrecio;
	private JButton btnGoToBasket;
	private ArrayList<Producto> productos;
	private ArrayList<Producto> carrito;
	private Pedido pedido;
	private PedidoDAO pedidoDAO;
	private int indice;
	private int idPedido;
	private CarritoView cv;
	
	/**
	 * Create the application.
	 */
	public ProductosView() {
		initialize();
		this.libreriaDAO = new LibreriaDAO();
		this.productos = new ArrayList<Producto>();
		this.carrito = new ArrayList<Producto>();
		// Las clases de Pedido / PedidoDAO eran una prueba para solucionar el problema de pasar el arrayList a la vista CarritoView.
		//this.pedidoDAO = new PedidoDAO();
		//this.pedido = new Pedido(1,carrito, 0, false);
		indice = 0;
		
		productos = libreriaDAO.getAll();
		
		if (productos.size()!=0) {
			printProducto();
			
		} else {
			btnBack.setVisible(false);
			btnForward.setVisible(false);
		}
		
		
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
		
		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(29, 71, 127, 23);
		frame.getContentPane().add(lblTitulo);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(29, 100, 127, 23);
		frame.getContentPane().add(lblAutor);
		
		lblFechaPublicacion = new JLabel("Fecha public.");
		lblFechaPublicacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaPublicacion.setBounds(29, 129, 127, 23);
		frame.getContentPane().add(lblFechaPublicacion);
		
		btnAddToBasket = new JButton("A\u00F1adir al carrito");
		btnAddToBasket.setMargin(new Insets(1, 1, 1, 1));
		btnAddToBasket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddToBasket.setBounds(29, 196, 127, 46);
		frame.getContentPane().add(btnAddToBasket);
		
		btnBackToMenu = new JButton("Volver al men\u00FA");
		btnBackToMenu.setMargin(new Insets(1, 1, 1, 1));
		btnBackToMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBackToMenu.setBounds(278, 196, 127, 46);
		frame.getContentPane().add(btnBackToMenu);
		
		btnBack = new JButton("<");
		btnBack.setMargin(new Insets(1, 1, 1, 1));
		btnBack.setBounds(28, 22, 39, 39);
		frame.getContentPane().add(btnBack);
		
		btnForward = new JButton(">");
		btnForward.setMargin(new Insets(1, 1, 1, 1));
		btnForward.setBounds(366, 22, 39, 39);
		frame.getContentPane().add(btnForward);
		
		tfTitulo = new JTextField();
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfTitulo.setBounds(132, 71, 273, 23);
		frame.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAutor.setColumns(10);
		tfAutor.setBounds(132, 100, 273, 23);
		frame.getContentPane().add(tfAutor);
		
		tfFecha = new JTextField();
		tfFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfFecha.setColumns(10);
		tfFecha.setBounds(132, 129, 136, 23);
		frame.getContentPane().add(tfFecha);
		
		lblUnidades = new JLabel("Unidades en stock");
		lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidades.setBounds(90, 22, 254, 39);
		frame.getContentPane().add(lblUnidades);
		
		lblAnoEdicion = new JLabel("A\u00F1o edici\u00F3n");
		lblAnoEdicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoEdicion.setBounds(29, 157, 127, 23);
		frame.getContentPane().add(lblAnoEdicion);
		
		tfAnoEdicion = new JTextField();
		tfAnoEdicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAnoEdicion.setColumns(10);
		tfAnoEdicion.setBounds(132, 157, 136, 23);
		frame.getContentPane().add(tfAnoEdicion);
		
		tfPrecio = new JTextField();
		tfPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfPrecio.setBounds(302, 129, 60, 53);
		frame.getContentPane().add(tfPrecio);
		tfPrecio.setColumns(10);
		
		lblPrecio = new JLabel("\u20AC");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(366, 138, 39, 32);
		frame.getContentPane().add(lblPrecio);
		
		btnGoToBasket = new JButton("Ir al carrito");
		btnGoToBasket.setMargin(new Insets(1, 1, 1, 1));
		btnGoToBasket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoToBasket.setBounds(167, 196, 101, 46);
		frame.getContentPane().add(btnGoToBasket);
	}
	
	public void configureUIListeners() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			indice --;
			printProducto();
			}
		});
		
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			indice++;
			printProducto();
			}
		});
		
		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToBasket(productos.get(indice));
			}
		});
		
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnBackToMenu,
						"¿Estás seguro de que quieres volver al menú?", "Confirmar volver al menú.",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirmar == JOptionPane.YES_OPTION) {
					new WelcomeView();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnBackToMenu, "Nos quedamos, pues");
				}
				
			}
		});
		
		btnGoToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Aquí se crea la vista del CarritoView. He hecho una copia del ArrayList con los libros que íbamos añadiendo para comprar.
			//Probablemente no es necesario, pero he intentado muchas cosas para que funcionara y al final lo he dejado así.
				
			if (carrito.size()!=0) {
			cv = new CarritoView();
			ArrayList<Producto> copiaCarrito = new ArrayList<Producto>();
			copiaCarrito.addAll(carrito);
			// Le paso el ArrayList con los libros seleccionados:
			cv.setCarrito(copiaCarrito);
			// Desde aquí imprimo los libros en la vista CarritoView(), porque si no me salía siempre que el arraylist era null.
			cv.printCarrito();
			} else {
				JOptionPane.showMessageDialog(btnGoToBasket, "La cesta está vacía.");
			}
			}
		});
	}
	
	public void printProducto() {
		Producto p = productos.get(indice);
		tfTitulo.setText(p.getTitulo());
		tfAutor.setText(p.getAutor());
		tfFecha.setText(p.getFecha_publicacion());
		tfAnoEdicion.setText(p.getAno_edicion());
		tfPrecio.setText(String.valueOf(p.getPrecio()));
		
		if (indice == 0) {
			btnBack.setVisible(false);
		} else if (indice == productos.size()-1) {
			btnForward.setVisible(false);
		} else if (indice != 0 && indice != productos.size()-1) {
			btnBack.setVisible(true);
			btnForward.setVisible(true);
		}
		
		if (indice !=0 && productos.size() == 2) {
			btnBack.setVisible(true);
		} else if (indice == 0 && productos.size() == 2) {
			btnForward.setVisible(true);
		}
	}
	
	public void addToBasket(Producto producto) {
		if (carrito.size()<5) {
			carrito.add(producto);
			JOptionPane.showMessageDialog(btnAddToBasket, "Producto añadido.");
		} else {
			JOptionPane.showMessageDialog(btnAddToBasket, "No se pueden añadir más unidades a la cesta.");
		}
		
	}
	
//	public ArrayList<Producto> getPedido() {
//		return carrito;
//	}
}
