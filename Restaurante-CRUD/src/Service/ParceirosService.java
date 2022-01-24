package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ComumDAO;
import DTO.Parceiros;


public class ParceirosService {
	


	
	
	
	//--------------Método para gravar dados de parceiro no BD-------------------------------------------
	public void adicionarParceiro(Parceiros parceiros){
		Connection  connection = ComumDAO.getConnection();
	 String sql = "INSERT INTO parceiros (email, telefone, gps_latitude, gps_longitude, youtube_videouid) values (?, ?, ?, ?, ?)";
	 
	 try {
		 PreparedStatement pstmt = connection.prepareStatement(sql);
		 pstmt.setString(1, parceiros.getEmail());
		 pstmt.setString(2, parceiros.getTelefone());
		 pstmt.setString(3, parceiros.getGps_latitude());
		 pstmt.setString(4, parceiros.getGps_longitude());
		 pstmt.setString(5, parceiros.getYoutube_videouid());
		 
		 pstmt.executeUpdate();
		 
		 pstmt.close();
		 connection.close();
		 
		 System.out.println("Parceiro inserido com sucesso!");
		
	} catch (Exception e) {
		System.out.println("Erro ao gravar dados de parceiros!"+e);
	}
			
	}
	
	
	
	//--------------Método para actualizar dados de parceiro no BD-------------------------------------------
		public void editarParceiro(Parceiros parceiros){
			Connection  connection = ComumDAO.getConnection();
		 String sql = "UPDATE parceiros SET email = ?, telefone = ?, gps_latitude = ?, gps_longitude = ?, youtube_videouid = ? WHERE id="+ parceiros.getId();
		 
		 try {
			 PreparedStatement pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1, parceiros.getEmail());
			 pstmt.setString(2, parceiros.getTelefone());
			 pstmt.setString(3, parceiros.getGps_latitude());
			 pstmt.setString(4, parceiros.getGps_longitude());
			 pstmt.setString(5, parceiros.getYoutube_videouid());
			 
			 pstmt.executeUpdate();
			 
			 pstmt.close();
			 connection.close();	
			 System.out.println("Parceiro actualidado com sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro ao actualizar dados de parceiros!"+e);
		}
					
		}
	
		
		
		//--------------------Método para excluir dados de parceiros na base dados por meio de ID---------------------------------
		public void excluirParceiros (int id){
			Connection  connection = ComumDAO.getConnection();
			String sql = "DELETE FROM parceiros WHERE id="+ id;
			
			try {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				connection.close();
				
				System.out.println("Parceiro excluido com sucesso!");
			} catch (Exception e) {
				System.out.println("Erro ao excluir parceiro!"+e);
			}
			
		}

		
		
		//-----------------------Método para listar todos parceiros na BD----------------------------------
		public List<Parceiros> listarParceiros(){
			Connection  connection = ComumDAO.getConnection();
			List<Parceiros> lista= new ArrayList<>();
						
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM parceiros");
				
				ResultSet resultset=statement.getResultSet();
				while (resultset.next()){
					Parceiros parceiros = new Parceiros();
					parceiros.setId(resultset.getInt("id"));
					parceiros.setEmail(resultset.getString("email"));
					parceiros.setGps_latitude(resultset.getString("gps_latitude"));
					parceiros.setGps_longitude(resultset.getString("gps_longitude"));
					parceiros.setTelefone(resultset.getString("telefone"));
					parceiros.setYoutube_videouid(resultset.getString("youtube_videouid"));
					
					lista.add(parceiros);
							
				}
				resultset.close();
				statement.close();
				connection.close();	
				
				return lista;
			} catch (Exception e) {
				System.out.println("Erro ao listar dados de parceiros! "+e);
			}
					
			return null;
		}
		
		
		
		//-----------------------Método para consultar dados de parceiros na BD para edicao ----------------------------------
		public Parceiros buscarParceiros(int id){		
			Connection  connection = ComumDAO.getConnection();
			Parceiros parceiros = new Parceiros();
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM parceiros where id="+id);
				
				ResultSet resultset=statement.getResultSet();
				
				if (resultset.next()){
					
					parceiros.setId(resultset.getInt("id"));
					parceiros.setEmail(resultset.getString("email"));
					parceiros.setGps_latitude(resultset.getString("gps_latitude"));
					parceiros.setGps_longitude(resultset.getString("gps_longitude"));
					parceiros.setTelefone(resultset.getString("telefone"));
					parceiros.setYoutube_videouid(resultset.getString("youtube_videouid"));
				}
				
				resultset.close();
				statement.close();
				connection.close();
				
				return parceiros;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro na conexão: "+e.getMessage());
			}
			return null;
		}
}
