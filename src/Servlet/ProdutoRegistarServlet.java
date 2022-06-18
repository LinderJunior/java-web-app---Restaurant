package Servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Produto;
import Service.ProdutoService;

/**
 * Servlet implementation class NovoProdutoServlet
 */
@WebServlet("/novoProduto")
public class ProdutoRegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoService produtoService= new ProdutoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoRegistarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
				
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

		produtoService.AdicionarProduto(produto);
		response.sendRedirect("listarProduto");
	}
	

}
