package views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import models.Producto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarritoView {

	private JFrame frame;
	public ArrayList<Producto> carrito;
	private Producto producto;
	private JTextField tfcantidad1;
	private JTextField tfcantidad2;
	private JTextField tfcantidad3;
	private JTextField tfcantidad4;
	private JTextField tfcantidad5;
	private JTextField tfproductos1;
	private JTextField tfproductos2;
	private JTextField tfproductos3;
	private JTextField tfproductos4;
	private JTextField tfproductos5;
	private JTextField tfprecio1;
	private JTextField tfprecio2;
	private JTextField tfprecio3;
	private JTextField tfprecio4;
	private JTextField tfprecio5;
	private JTextField tftotal;
	private JButton btnComprar;
	private JButton btnCancelar;
	private JLabel lblEuros;
	private JLabel lblTotal;
	private JLabel lblCantidad;
	private JLabel lblProductos;
	private JLabel lblPrecio;
	private ProductosView pv;
	
	
	//Este Getter y setter los creé para poder traer el carrito de la vista ProductosView().
	public ArrayList<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Producto> carrito2) {
		this.carrito = carrito2;
	}

	/**
	 * Create the application.
	 */
	public CarritoView() {
		initialize();
		this.carrito = new ArrayList<Producto>();
		// IMPORTANTE, AQUÍ NO IMPRIMO LOS LIBROS QUE HE SELECCIONADO PORQUE NO SABÍA CÓMO TRAER EL ARRAYLIST DE PRODUCTOSVIEW
		// SE IMPRIMEN EN EL MÉTODO ProductosView.goToBasket()
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
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(37, 29, 45, 13);
		frame.getContentPane().add(lblCantidad);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setBounds(195, 29, 45, 13);
		frame.getContentPane().add(lblProductos);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(356, 29, 45, 13);
		frame.getContentPane().add(lblPrecio);
		
		tfcantidad1 = new JTextField();
		tfcantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		tfcantidad1.setText("1");
		tfcantidad1.setBounds(10, 55, 96, 19);
		frame.getContentPane().add(tfcantidad1);
		tfcantidad1.setColumns(10);
		
		tfcantidad2 = new JTextField();
		tfcantidad2.setHorizontalAlignment(SwingConstants.CENTER);
		tfcantidad2.setText("1");
		tfcantidad2.setBounds(10, 84, 96, 19);
		frame.getContentPane().add(tfcantidad2);
		tfcantidad2.setColumns(10);
		
		tfcantidad3 = new JTextField();
		tfcantidad3.setHorizontalAlignment(SwingConstants.CENTER);
		tfcantidad3.setText("1");
		tfcantidad3.setBounds(10, 113, 96, 19);
		frame.getContentPane().add(tfcantidad3);
		tfcantidad3.setColumns(10);
		
		tfcantidad4 = new JTextField();
		tfcantidad4.setHorizontalAlignment(SwingConstants.CENTER);
		tfcantidad4.setText("1");
		tfcantidad4.setBounds(10, 142, 96, 19);
		frame.getContentPane().add(tfcantidad4);
		tfcantidad4.setColumns(10);
		
		tfcantidad5 = new JTextField();
		tfcantidad5.setHorizontalAlignment(SwingConstants.CENTER);
		tfcantidad5.setText("1");
		tfcantidad5.setBounds(10, 170, 96, 19);
		frame.getContentPane().add(tfcantidad5);
		tfcantidad5.setColumns(10);
		
		tfproductos1 = new JTextField();
		tfproductos1.setBounds(116, 55, 203, 19);
		frame.getContentPane().add(tfproductos1);
		tfproductos1.setColumns(10);
		
		tfproductos2 = new JTextField();
		tfproductos2.setColumns(10);
		tfproductos2.setBounds(116, 84, 203, 19);
		frame.getContentPane().add(tfproductos2);
		
		tfproductos3 = new JTextField();
		tfproductos3.setColumns(10);
		tfproductos3.setBounds(116, 113, 203, 19);
		frame.getContentPane().add(tfproductos3);
		
		tfproductos4 = new JTextField();
		tfproductos4.setColumns(10);
		tfproductos4.setBounds(116, 142, 203, 19);
		frame.getContentPane().add(tfproductos4);
		
		tfproductos5 = new JTextField();
		tfproductos5.setColumns(10);
		tfproductos5.setBounds(116, 170, 203, 19);
		frame.getContentPane().add(tfproductos5);
		
		tfprecio1 = new JTextField();
		tfprecio1.setHorizontalAlignment(SwingConstants.CENTER);
		tfprecio1.setText("0");
		tfprecio1.setColumns(10);
		tfprecio1.setBounds(330, 55, 96, 19);
		frame.getContentPane().add(tfprecio1);
		
		tfprecio2 = new JTextField();
		tfprecio2.setHorizontalAlignment(SwingConstants.CENTER);
		tfprecio2.setText("0");
		tfprecio2.setColumns(10);
		tfprecio2.setBounds(329, 84, 96, 19);
		frame.getContentPane().add(tfprecio2);
		
		tfprecio3 = new JTextField();
		tfprecio3.setHorizontalAlignment(SwingConstants.CENTER);
		tfprecio3.setText("0");
		tfprecio3.setColumns(10);
		tfprecio3.setBounds(329, 113, 96, 19);
		frame.getContentPane().add(tfprecio3);
		
		tfprecio4 = new JTextField();
		tfprecio4.setHorizontalAlignment(SwingConstants.CENTER);
		tfprecio4.setText("0");
		tfprecio4.setColumns(10);
		tfprecio4.setBounds(330, 142, 96, 19);
		frame.getContentPane().add(tfprecio4);
		
		tfprecio5 = new JTextField();
		tfprecio5.setText("0");
		tfprecio5.setHorizontalAlignment(SwingConstants.CENTER);
		tfprecio5.setColumns(10);
		tfprecio5.setBounds(329, 170, 96, 19);
		frame.getContentPane().add(tfprecio5);
		
		tftotal = new JTextField();
		tftotal.setHorizontalAlignment(SwingConstants.RIGHT);
		tftotal.setColumns(10);
		tftotal.setBounds(305, 199, 96, 19);
		frame.getContentPane().add(tftotal);
		
		lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(250, 202, 45, 13);
		frame.getContentPane().add(lblTotal);
		
		lblEuros = new JLabel("\u20AC");
		lblEuros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEuros.setBounds(381, 202, 45, 13);
		frame.getContentPane().add(lblEuros);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(10, 221, 96, 32);
		frame.getContentPane().add(btnComprar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(116, 221, 96, 32);
		frame.getContentPane().add(btnCancelar);
	}
	
	public void configureUIListeners() {
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(btnComprar, "Gracias por su compra.");
			carrito.clear();
			frame.dispose();
			new ProductosView();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnCancelar,
						"¿Estás seguro/a de que quieres cancelar el pedido?", "Confirmar volver a la tienda.",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirmar == JOptionPane.YES_OPTION) {
					carrito.clear();
					frame.dispose();
					new ProductosView();
				} else {
					JOptionPane.showMessageDialog(btnCancelar, "¡A gastar los dinero!");
				}
			}
		});
	}
	
	
	public void printCarrito() {
		for (int i=0; i<carrito.size();i++) {
				
				switch (i) {
				case 0:
					tfproductos1.setText(carrito.get(i).getTitulo());
					tfprecio1.setText(String.valueOf(carrito.get(i).getPrecio()));
					break;
				case 1:
					tfproductos2.setText(carrito.get(i).getTitulo());
					tfprecio2.setText(String.valueOf(carrito.get(i).getPrecio()));
					break;
				case 2:
					tfproductos3.setText(carrito.get(i).getTitulo());
					tfprecio3.setText(String.valueOf(carrito.get(i).getPrecio()));
					break;
				case 3:
					tfproductos4.setText(carrito.get(i).getTitulo());
					tfprecio4.setText(String.valueOf(carrito.get(i).getPrecio()));
					break;
				case 4:
					tfproductos5.setText(carrito.get(i).getTitulo());
					tfprecio5.setText(String.valueOf(carrito.get(i).getPrecio()));
					break;
				}
			
				}
				carrito.clear();
				
				double total = Double.parseDouble(tfprecio1.getText())+Double.parseDouble(tfprecio2.getText())+Double.parseDouble(tfprecio3.getText())+Double.parseDouble(tfprecio4.getText())+Double.parseDouble(tfprecio5.getText());
		
				tftotal.setText(String.valueOf(total));
	}
}
