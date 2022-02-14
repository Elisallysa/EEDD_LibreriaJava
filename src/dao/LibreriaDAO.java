package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Producto;

public class LibreriaDAO extends AbstractDAO {
	
	public ArrayList<Producto> getAll() {
		
		final String QUERY = "SELECT * FROM productos";
		var productos = new ArrayList<Producto>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var ISBN = rs.getInt("ISBN");
				var titulo = rs.getString("titulo");
				var autor = rs.getString("autor");
				var fecha_publicacion = rs.getString("fecha_publicacion");
				var ano_edicion = rs.getString("ano_edicion");
				var precio = rs.getDouble("precio");
				Producto p = new Producto(ISBN, titulo, autor, fecha_publicacion, ano_edicion, precio);
				productos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
}
