package fanaticos.application;

import java.sql.SQLException;

import fanaticos.application.controller.CadastroCliente;
import fanaticos.application.model.Cliente;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		//ConexaoMySQL.conectar();
		CadastroCliente dao = new CadastroCliente();
		
		CadastroCliente.salveCliente();
		CadastroCliente.getCliente();		
		
		//adiciona
		Cliente c =  new Cliente();
		c.setName("Lucas");
		c.setLast_name("Amaral teste");
		c.setPhone_number("00922228888");
		c.setIs_whatsapp(false);
		c.setCustomer_id(1);
		
		//CadastroCliente.update(c);
		
		//DELETE
		dao.deleteById(3);
		
		
		for (Cliente c1 : dao.getCliente()) {
			System.out.println(c1);
			System.out.println();
		}
	}
}
