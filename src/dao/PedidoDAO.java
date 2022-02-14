package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Pedido;


public class PedidoDAO extends AbstractDAO{
	
	// ESTA CLASE NO SE USA!
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public void insert(Pedido p) {
		final String INSERT = "INSERT INTO pedidos(`fecha`,`importe_total`)\r\n" 
				+ "VALUES('" +dtf.format(LocalDateTime.now())+"',"+0+");";
		try {
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double getImporteTotal(Pedido p) {
		final String QUERY = "SELECT fecha,importe_total\r\n" 
				+ "FROM pedidos WHERE fecha like '" +dtf.format(LocalDateTime.now())+"';";
		double total = 0;
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				total = rs.getDouble("importe_total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return total;
	}
	
	
}
