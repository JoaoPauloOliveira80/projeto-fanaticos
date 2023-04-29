package fanaticos.application.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fanaticos.application.connection.ConexaoMySQL;
import fanaticos.application.dao.ClienteDao;
import fanaticos.application.model.Cliente;

public class CadastroCliente {

	public static void salveCliente() {

		ClienteDao c = new ClienteDao();

		Cliente cli = new Cliente();
		cli.setName("Ivonete");
		cli.setLast_name("Ribeiro");
		cli.setPhone_number("16995651245");
		cli.setIs_whatsapp(true);

		// c.save(cli);

	}

	public static List<Cliente> getCliente() throws SQLException {
		String sql = "Select * from customers";

		List<Cliente> listaCliente = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// RECUPERA DADOS DO BANCO
		ResultSet rs = null;
		Cliente cli = new Cliente();
		try {

			conn = ConexaoMySQL.conectar();
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {

				// RECUPERAR ID
				cli.setCustomer_id(rs.getInt("customer_id"));
				cli.setName(rs.getString("name"));
				cli.setLast_name(rs.getString("last_name"));
				cli.setPhone_number(rs.getString("phone_number"));
				cli.setIs_whatsapp(rs.getBoolean("is_whatsapp"));

				listaCliente.add(cli);
			}
			
			for(Cliente c : listaCliente) {
				System.out.println(c);
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listaCliente;

	}
}
