package br.marcio.javafx.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	
	//atributos para conexao com o banco de dados PostgreSQL
	private String url = "jdbc:postgresql://localhost:5432/db_delivery";
	private String username = "postgres";
	private String password = "admin";
	private String driver = "org.postgresql.Driver";


	//ações dentro do banco de dados
	Connection conexao;
	Statement statement;
	ResultSet rs;
	

	protected Connection abreConexao(){
		try {
			
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, username, password);
			return conexao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected Boolean fecharConexao() {
		try {
			conexao.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean verificandoConexao() {
		if (conexao != null ) {
			return true;
		} else {
			return false;
		}
	}
	
}
