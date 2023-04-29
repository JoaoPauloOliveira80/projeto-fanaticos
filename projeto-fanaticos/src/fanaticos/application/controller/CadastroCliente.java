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

	public static void update(Cliente cli) throws SQLException {
		String sql = "update customers set name= ?, last_name= ?, phone_number= ?, is_whatsapp= ? where  customer_id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com banco
			conn = ConexaoMySQL.conectar();

			// cria classe para execuça
			pstm = conn.prepareStatement(sql);

			// adicionar valores pra atualizar
			pstm.setString(1, cli.getName());
			pstm.setString(2, cli.getLast_name());
			pstm.setString(3, cli.getPhone_number());
			pstm.setBoolean(4, cli.isIs_whatsapp());
			pstm.setInt(5, cli.getCustomer_id());

			pstm.execute();

			System.out.println("Cliente atualizado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void deleteById(int id) {
		String sql = "DELETE FROM customers WHERE customer_id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConexaoMySQL.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Deletado com sucesso...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
