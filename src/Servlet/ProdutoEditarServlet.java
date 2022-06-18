package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Produto;
import Service.ProdutoService;

/**
 * Servlet implementation class ProdutoEditarServlet
 */
@WebServlet("/produtoEditar")
public class ProdutoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProdutoEditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoService produtoService= new ProdutoService();
		
		String id =request.getParameter("id");
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarProduto.jsp");
		request.setAttribute("produto", produtoService.consultarProduto(id));
		requestDispatcher.forward(request, response);		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoService produtoService= new ProdutoService();
		Produto produto = new Produto();
		
		produto.setId(Integer.valueOf(request.getParameter("id")));
		produto.setNome(request.getParameter("nome"));
		produto.setTipo(request.getParameter("tipo"));
		produto.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		
	    String data = request.getParameter("validade");
	    System.out.println(data);
	    
	    Date validade;
	    
		try {
			validade = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("validade"));
			produto.setValidade(validade);
			
		}catch(ParseException e) {
			e.printStackTrace();
			
		}
		
					
		produtoService.EditarProduto(produto);
		response.sendRedirect("listarProduto");
		}

}
