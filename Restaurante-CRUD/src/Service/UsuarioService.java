package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ComumDAO;
import DTO.Usuario;

public class UsuarioService {
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para adicionar Usuario
	 */
	public void adicionarUsuario (Usuario user){
		
	Connection connection = ComumDAO.getConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO usuario (usuario, contacto, email, senha, nivel_acesso) values (?, ?, ?, ?, ?)");
			
			pstmt.setString(1, user.getUsuario());
			pstmt.setString(2, user.getContacto());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getSenha());
			pstmt.setString(5, user.getNivel_acesso());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			System.out.println("Metodo adicionarUsuario executado com Sucesso");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no metodo adicionarUsuario" +e.getMessage());
		}

	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para Listar todos Usuarios na Base de Dados
	 */
	public List<Usuario> listarUsuario(){

		Connection connection = ComumDAO.getConnection();
		List<Usuario> listaDeUsuarios = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT usuario.id_usuario, usuario.usuario, usuario.contacto, usuario.email, usuario.nivel_acesso FROM usuario");
			ResultSet rs = statement.getResultSet();
				
			while (rs.next()){
				Usuario user = new Usuario();
				
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				//user.setSenha(rs.getString("senha"));
				user.setContacto(rs.getString("contacto"));
				user.setEmail(rs.getString("email"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));

				listaDeUsuarios.add(user);					
			}	
			rs.close();
			statement.close();
			connection.close();
			System.out.println("Metodo listarUsuario executado com sucesso");
			
			return listaDeUsuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo listarUsuario" +e.getMessage());
		}
		return null;
	}
	
	
	/*---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Teste Grafico
	 * 
	 * 
	 */
	public List<Usuario> findAll(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1,"linder","846978018","linderju01@gmail.com","admin", "admin"));
		usuarios.add(new Usuario(2,"junior","846978036","lind@gmail.com","admin", "admin"));
		usuarios.add(new Usuario(3,"neto","846568018","linderj6@gmail.com","admin", "admin"));
		
		return usuarios;
	}
	
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para Actualizar Usuario
	 */
	public void actualizarUsuario (Usuario user){
		
		Connection connection = ComumDAO.getConnection();
					
				try {
					PreparedStatement pstmt = connection
							.prepareStatement("UPDATE usuario SET usuario=?, contacto=?, email=?, senha=?, nivel_acesso=? WHERE id_usuario="+user.getId_usuario());
					
					pstmt.setString(1, user.getUsuario());
					pstmt.setString(2, user.getContacto());
					pstmt.setString(3, user.getEmail());
					pstmt.setString(4, user.getSenha());
					pstmt.setString(5, user.getNivel_acesso());
										
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					System.out.println("Metodo actualizarUsuario executado com sucesso!");
						
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Erro no metodo actualizarUsuario");
					
				}		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------

	/*-------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para Apagar Usuario na Base de dados
	 */
	public void apagarUsuario (int id_usuario){
		Connection connection = ComumDAO.getConnection();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM usuario WHERE id_usuario="+id_usuario);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			System.out.println("Metodo apagarUsuario executado com sucesso ");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no Metodo apagarUsuario");
			
		}
	}
	
	/*----------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para Buscar Usuario por id
	 */
	public Usuario buscarUsuario (int id_usuario){
		Connection  connection = ComumDAO.getConnection();
		Usuario user = new Usuario();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(" SELECT * FROM usuario WHERE id_usuario="+id_usuario);
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
							
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setContacto(rs.getString("contacto"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));
				user.setEmail(rs.getString("email"));
										
			}
			
			rs.close();
			statement.close();
			connection.close();
			System.out.println("metodo buscarUsuario executado com sucesso");
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo buscarUsuario  : "+e.getMessage());
			
		}
			
		return null;
		
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para validar Login
	 */
	public Usuario usuarioLogin (String usuario, String senha){
		Connection  connection = ComumDAO.getConnection();
		Usuario user = new Usuario();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM usuario WHERE usuario='"+usuario+"' AND senha='"+senha+"'");
							
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
									
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));
				user.setContacto(rs.getString("contacto"));
															
			}
			
			rs.close();
			statement.close();
			connection.close();
			System.out.println("Metodo usuarioLogin executado com sucesso ");
			
			return user;
						
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo usuarioLogin : "+e.getMessage());
			
		}
			
		return null;
		
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para validar dados para recuperar Senha
	 */
	public Usuario usuarioReset (String email, String contacto){
		Connection  connection = ComumDAO.getConnection();
		Usuario user = new Usuario();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM usuario WHERE email='"+email+"' AND contacto='"+contacto+"'");
							
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
									
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));
				user.setContacto(rs.getString("contacto"));
				user.setEmail(rs.getString("email"));
															
			}
			rs.close();
			statement.close();
			connection.close();
			System.out.println("Metodo usuarioReset executado com sucesso ");
			return user;
						
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo usuarioReset: "+e.getMessage());	
		}
		return null;
	}
	
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo para Atualizar Senha
	 */	
	public void resetPassword (Usuario user){
		
		Connection connection = ComumDAO.getConnection();
					
				try {
					PreparedStatement pstmt = connection
							.prepareStatement("UPDATE usuario SET senha=? WHERE contacto="+user.getContacto());
					pstmt.setString(1, user.getSenha());
					
										
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					System.out.println("Metodo resetPassword  executado com sucesso");
						
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Erro no metodo resetPassword  : "+e.getMessage());
					
					
				}
			
	}

	/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo Para Pesquisar Por Nome
	 */	
	public List<Usuario> pesquisarNome(String usuario){

		Connection connection = ComumDAO.getConnection();
		List<Usuario> listaDeUsuarios = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM usuario WHERE usuario LIKE '%" +usuario+ "%'");
			ResultSet rs = statement.getResultSet();
				
			while (rs.next()){
				Usuario user = new Usuario();
				
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));
				user.setContacto(rs.getString("contacto"));
				user.setEmail(rs.getString("email"));
				
				listaDeUsuarios.add(user);					
			}	
			rs.close();
			statement.close();
			connection.close();
			System.out.println("Metodo pesquisarNome executado com sucesso ");
			
			return listaDeUsuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo pesquisarNome: "+e.getMessage());
			
		}
		return null;
	}
	
	/*------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * Metodo Para Pesquisar Por Nome
	 */	
	public List<Usuario> pesquisarNivel(String nivel_acesso){

		Connection connection = ComumDAO.getConnection();
		List<Usuario> listaDeUsuarios = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM usuario WHERE nivel_acesso LIKE '%" +nivel_acesso+ "%'");
			ResultSet rs = statement.getResultSet();
				
			while (rs.next()){
				Usuario user = new Usuario();
				
				user.setId_usuario(rs.getInt("id_usuario"));
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				user.setNivel_acesso(rs.getString("nivel_acesso"));
				user.setContacto(rs.getString("contacto"));
				user.setEmail(rs.getString("email"));
				
				listaDeUsuarios.add(user);					
			}	
			rs.close();
			statement.close();
			connection.close();
			System.out.println("Metodo pesquisarNivel executado com sucesso ");
			
			return listaDeUsuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro no metodo pesquisarNivel: "+e.getMessage());	
		}
		return null;
	}
		
}
