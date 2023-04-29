package fanaticos.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fanaticos.application.connection.ConexaoMySQL;
import fanaticos.application.model.Cliente;

public class ClienteDao {
	
	
	
	//CRUD
	
//	public void save(Cliente cli) {
//		
//		String sql = "INSERT INTO customers(name,last_name,phone_number, is_whatsapp) values (?,?,?,?)";
//		
//		Connection conn = null;		
//		PreparedStatement pstm = null;
//	
//		
//		try {
//			//CRIAR CONEXAO COM BANCO DE DADOS
//			conn = ConexaoMySQL.conectar();
//			
//			//Criamos preparestatement, para executar querer
//			pstm = conn.prepareStatement(sql);
//			
//			pstm.setString(1, cli.getName());
//			pstm.setString(2,cli.getLast_name());
//			pstm.setString(3,cli.getPhone_number());
//			pstm.setBoolean(4, cli.isIs_whatsapp());			
//			pstm.execute();
//			
//			System.out.println("Cliente salvo com sucesso!");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			//FECHA CNEXAO
//			
//			try {
//				
//				if(pstm != null) {
//					pstm.close();
//				}
//				
//				if(conn != null) {
//					conn.close();
//				}
//				
//			}catch(Exception e ) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//	}

}
