package br.marcio.javafx.model.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.marcio.javafx.model.Cliente;

public class ClienteRepository extends Conexao {
	
	//o objecto de trabalho da classe clienteRepository
	private Cliente cliente;
	
	public ClienteRepository() { }
	
	public ClienteRepository (Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Boolean verificandoEntidade() {
		if (cliente != null)
			return true;
		return false;
	}
	
	public boolean cadastrarCliente() {
		try {
			super.abreConexao();
			statement = conexao.createStatement();
			String sql = "INSERT INTO tabela_cliente (id, nome, telefone, endereco, email) values "
					+ "('"+cliente.getId()+"','"+cliente.getNome()+"','"+cliente.getTelefone()+"','"+
					cliente.getEndereco()+"','"+cliente.getEmail()+"')";
			System.out.println(sql);
			statement.execute(sql);
			super.fecharConexao();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Cliente buscarClientePeloId(long id) throws SQLException {
		try {
			super.abreConexao();
			statement = conexao.createStatement();
			String sql = "SELECT * FROM tabela_cliente where id = "+id;
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				Cliente clienteEncontrado = new Cliente();
				clienteEncontrado.setId(rs.getLong("id"));
				clienteEncontrado.setNome(rs.getString("nome"));
				clienteEncontrado.setTelefone(rs.getString("telefone"));
				clienteEncontrado.setEndereco(rs.getString("endereco"));
				clienteEncontrado.setEmail(rs.getString("email"));				
				return clienteEncontrado;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rs.close();
			super.fecharConexao();
		}
	}
	
	public Cliente buscarClientePeloNome(String nome) throws SQLException {
		try {
			super.abreConexao();
			statement = conexao.createStatement();
			String sql = "SELECT * FROM tabela_cliente where nome = '"+nome+"'";
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				Cliente clienteEncontrado = new Cliente();
				clienteEncontrado.setId(rs.getLong("id"));
				clienteEncontrado.setNome(rs.getString("nome"));
				clienteEncontrado.setTelefone(rs.getString("telefone"));
				clienteEncontrado.setEndereco(rs.getString("endereco"));
				clienteEncontrado.setEmail(rs.getString("email"));				
				return clienteEncontrado;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rs.close();
			super.fecharConexao();
		}
	}
	
	
	public List<Cliente> buscarClientes(){
		try {
			super.abreConexao();
			statement = conexao.createStatement();
			String sql = "SELECT * FROM tabela_cliente";
			System.out.println(sql);
			
			rs = statement.executeQuery(sql);
			
			Cliente clienteEncontrado = null;
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) { // mais de um cliente
				clienteEncontrado = new Cliente();
				clienteEncontrado.setId(rs.getLong("id"));
				clienteEncontrado.setNome(rs.getString("nome"));
				clienteEncontrado.setTelefone(rs.getString("telefone"));
				clienteEncontrado.setEndereco(rs.getString("endereco"));
				clienteEncontrado.setEmail(rs.getString("email"));
				clientes.add(clienteEncontrado);
			}
			rs.close();
			super.fecharConexao();
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
