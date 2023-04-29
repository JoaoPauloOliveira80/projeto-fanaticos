package fanaticos.application.controller;

import fanaticos.application.dao.ClienteDao;
import fanaticos.application.model.Cliente;

public class CadastroCliente {
	
	
	public static void salveCliente() {
		
		ClienteDao c = new ClienteDao();
		
		Cliente cli = new Cliente();
		cli.setName("Jean");
		cli.setLast_name("teste");
		cli.setPhone_number("16998451237");
		cli.setIs_whatsapp(true);	
		
		c.save(cli);
		
		
	}

}
