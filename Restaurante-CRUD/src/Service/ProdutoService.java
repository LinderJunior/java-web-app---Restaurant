package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import DAO.ComumDAO;
import DTO.Produto;

public class ProdutoService {	

//Listar
	public List<Produto> buscarTodos(){
		
		 Connection connection = ComumDAO.getConnection();
		 List<Produto> listProduto = new ArrayList<>();
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM produto ORDER BY nome ASC");
				ResultSet resultSet=statement.getResultSet();
				
				while(resultSet.next()){
					Produto produto = new Produto();
					produto.setId(resultSet.getInt("id"));
					produto.setNome(resultSet.getString("nome"));
					produto.setTipo(resultSet.getString("tipo"));
					produto.setPreco(resultSet.getDouble("preco"));
					produto.setValidade(resultSet.getDate("validade"));

					listProduto.add(produto);
				}
				
				statement.close();
				connection.close();
				
				return listProduto;
				
			} catch (Exception e) {
				
				System.out.println("Erro na conexão: "+e.getMessage());
				return null;
						
			}
	}
	
//Método para Pesquisar produtos por  NOME e TIPO
			public List<Produto> buscarTodosPorNomeTipo(String nome, String tipo){
				
				 Connection connection = ComumDAO.getConnection();
				 List<Produto> listProduto = new ArrayList<>();
					try {
						Statement statement = connection.createStatement();
						statement.execute("SELECT * FROM produto WHERE nome LIKE '%"+nome+"%' AND tipo LIKE'%"+tipo+"%' ORDER BY nome ASC");
						ResultSet resultSet=statement.getResultSet();
						
						while(resultSet.next()){
							Produto produto = new Produto();
							produto.setId(resultSet.getInt("id"));
							produto.setNome(resultSet.getString("nome"));
							produto.setPreco(resultSet.getDouble("preco"));
							produto.setTipo(resultSet.getString("tipo"));
							produto.setValidade(resultSet.getDate("validade"));
							
							listProduto.add(produto);
							
							System.out.println("Nome do produto: "+ produto.getNome());
						}
						
						resultSet.close();
						statement.close();
						connection.close();;
						
						return listProduto;
						
						
					} catch (Exception e) {
						
						System.out.println("Erro na conexão: "+e.getMessage());
						return null;
								
					}
					
			}
            // Listar os produtos por valorInicial e valor Final
			public List<Produto> buscarTodosPorPreco( String precoInicial, String precoFinal){
				
				 Connection connection = ComumDAO.getConnection();
				 List<Produto> listProduto = new ArrayList<>();
					try {
						Statement statement = connection.createStatement();
						statement.execute("SELECT * FROM produto WHERE preco BETWEEN '"+precoInicial+"' AND '"+precoFinal+"' ORDER BY nome ASC");
						ResultSet resultSet=statement.getResultSet();
						
						while(resultSet.next()){
							Produto produto = new Produto();
							produto.setId(resultSet.getInt("id"));
							produto.setNome(resultSet.getString("nome"));
							produto.setPreco(resultSet.getDouble("preco"));
							produto.setValidade(resultSet.getDate("validade"));
							produto.setTipo(resultSet.getString("tipo"));
						
							listProduto.add(produto);
							
							System.out.println("Nome do produto: "+ produto.getNome());
						}
						
						resultSet.close();
						statement.close();
						connection.close();
						
						return listProduto;
						
						
					} catch (Exception e) {
						
						System.out.println("Erro na conexão: "+e.getMessage());
						return null;
								
					}
					
			}
					
	//Método para inserir produtos na Base Dados 
	public void AdicionarProduto(Produto produto){
		
		String sql = "INSERT INTO produto (nome, preco, tipo, validade) VALUES (?, ?, ?, ?)";
		
		Connection connection = ComumDAO.getConnection();
		
		try {
		
			PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
			
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getPreco());
			pstmt.setString(3, produto.getTipo());
			pstmt.setDate(4, new java.sql.Date(produto.getValidade().getTime()));
						
			pstmt.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para actualizar produtos na Base Dados 
		public void ActualiarProduto(Produto produto){
			
			String sql = "UPDATE produto SET nome=?, preco=?, tipo=?, validade=? WHERE id="+produto.getId();
			
			Connection connection = ComumDAO.getConnection();
			
			try {
			
				PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
				
				pstmt.setString(1, produto.getNome());
				pstmt.setDouble(2, produto.getPreco());
				pstmt.setString(3, produto.getTipo());
			
				pstmt.setDate(4, new java.sql.Date(produto.getValidade().getTime()));
				
							
				pstmt.executeUpdate();
				
				pstmt.close();
				connection.close();
				
				System.out.println("Produto actualizado com sucesso: "+ produto.getNome());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	//Método para Excuir busca baseada no ID do produto
	public void excluirProduto(String id){
		 Connection connection = ComumDAO.getConnection();
		
		 try {
				Statement statement = connection.createStatement();
				statement.execute("DELETE FROM produto WHERE id="+Integer.valueOf(id));
				
				statement.close();
				connection.close();
				
			System.out.println("Produto excluido com sucesso!");
			} catch (Exception e) {
				
				System.out.println("Erro na conexão: "+e.getMessage());
				
			}
	}
	
	//Método para Actualizar o Produto na Base de Dados
	public void EditarProduto(Produto produto){
		Connection connection = ComumDAO.getConnection();
		try {
			String sql = "UPDATE produto SET nome=?, tipo=?, preco=?, validade=? WHERE id="+produto.getId();
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			
			statement.setString(1, produto.getNome());
			
			statement.setString(2, produto.getTipo());
			statement.setDouble(3, produto.getPreco());
			statement.setDate(4, new java.sql.Date(produto.getValidade().getTime()));
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	//Método para pegar um produto para ser editado
	public Produto consultarProduto(String id){
		
		 Connection connection = ComumDAO.getConnection();
		 Produto produto = new Produto();
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM produto WHERE id="+String.valueOf(id));
				ResultSet resultSet=statement.getResultSet();
				
				if (resultSet.next()){
					produto.setId(resultSet.getInt("id"));
					produto.setNome(resultSet.getString("nome"));
					produto.setPreco(resultSet.getDouble("preco"));
					
					produto.setValidade(resultSet.getDate("validade"));
					produto.setTipo(resultSet.getString("tipo"));
					
				}
				resultSet.close();
				statement.close();
				connection.close();
				
				return produto;	
				
			} catch (Exception e) {
				
				System.out.println("Erro na conexão: "+e.getMessage());
				return null;
						
			}		
	}
}
