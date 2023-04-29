package fanaticos.application;

import java.sql.SQLException;

import fanaticos.application.controller.CadastroCliente;

public class Main {
	public static void main(String[] args) throws SQLException {
		//ConexaoMySQL.conectar();
		
		CadastroCliente.salveCliente();
		CadastroCliente.getCliente();
	}
}
