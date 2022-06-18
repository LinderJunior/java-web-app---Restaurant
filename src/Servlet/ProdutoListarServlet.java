package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Produto;
import Service.ProdutoService;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/listarProduto")
public class ProdutoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String mt = "0";	
		ProdutoService produtoService= new ProdutoService();
				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaProdutos.jsp");
		request.setAttribute("listaDeProdutos", produtoService.buscarTodos());
		request.setAttribute("Mts", mt);
		requestDispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
