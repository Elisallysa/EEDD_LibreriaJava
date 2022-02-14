package models;

import java.util.ArrayList;

public class Pedido {

	//ESTA CLASE NO LA HE USADO AL FINAL!
	
	private int id;
	private ArrayList<Producto> carrito;
	private double importeTotal;
	private boolean compraEfectuada;
	
	public Pedido(int id, ArrayList<Producto> carrito, double importeTotal, boolean compraEfectuada) {
		super();
		this.id = id;
		this.carrito = carrito;
		this.importeTotal = 0;
		this.setCompraEfectuada(false);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Producto> carrito) {
		this.carrito = carrito;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public boolean isCompraEfectuada() {
		return compraEfectuada;
	}

	public void setCompraEfectuada(boolean compraEfectuada) {
		this.compraEfectuada = compraEfectuada;
	}
	
	
	
}
