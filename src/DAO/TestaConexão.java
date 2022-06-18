package DAO;

import java.sql.Connection;
import java.sql.Statement;

import DTO.Produto;
import Service.ProdutoService;

public class TestaConexão {
	
	public static void main(String[] args) {
		

	
	System.out.println("LISTAR PRODUTOS");
	ProdutoService produtoService= new ProdutoService();
	String tipo = "bebida";
	String nome="";
	//
	for (Produto produto : produtoService.buscarTodosPorNomeTipo(nome, tipo)){
		System.out.println(produto.getId()+" - "+produto.getNome()+" - "+produto.getPreco());
	}
	
	
	

}

}
