package DAO;

import DTO.Parceiros;
import DTO.Produto;
import DTO.Usuario;
import Service.ParceirosService;
import Service.ProdutoService;
import Service.UsuarioService;

public class TestaListagem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioService usuarioService = new UsuarioService();
		ProdutoService produtoService= new ProdutoService();
		ParceirosService ps = new ParceirosService();
	
	int id =1;	
		
		
		for (Parceiros parceiros: ps.listarParceiros()){
		System.out.println( parceiros.getEmail());
		}
		
		

	}

}
