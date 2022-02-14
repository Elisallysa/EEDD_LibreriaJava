package models;

public class Producto {

	//Atributes
	private int ISBN;
	private String titulo;
	private String autor;
	private String fecha_publicacion;
	private String ano_edicion;
	private double precio;
	private int cantidad;
	
	//Constructor
	public Producto(int iSBN, String titulo, String autor, String fecha_publicacion, String ano_edicion,
			double precio) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.fecha_publicacion = fecha_publicacion;
		this.ano_edicion = ano_edicion;
		this.precio = precio;
	}
	
	// Este constructor no se usa. Lo creé para crear el producto con la cantidad del mismo (para el carrito). Pero no me ha salido.
	public Producto(int iSBN, String titulo, String autor, String fecha_publicacion, String ano_edicion,
			double precio, int cantidad) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.fecha_publicacion = fecha_publicacion;
		this.ano_edicion = ano_edicion;
		this.precio = precio;
		this.cantidad = 1;
	}
	
	
	//Getters and setters
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public String getAno_edicion() {
		return ano_edicion;
	}
	public void setAño_edicion(String ano_edicion) {
		this.ano_edicion = ano_edicion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "Producto [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", fecha_publicacion="
				+ fecha_publicacion + ", año_edicion=" + ano_edicion + ", precio=" + precio + "]";
	}

	
	
	
}
