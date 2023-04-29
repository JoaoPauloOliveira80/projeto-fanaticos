package fanaticos.application;

import fanaticos.application.controller.CadastroCliente;

public class Main {
	public static void main(String[] args) {
		//ConexaoMySQL.conectar();
		
		CadastroCliente.salveCliente();
	}
}
