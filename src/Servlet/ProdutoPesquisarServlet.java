package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProdutoService;

/**
 * Servlet implementation class ProdutoPesquisarServlet
 */
@WebServlet("/produtoPesquisar")
public class ProdutoPesquisarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoPesquisarServlet() {
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
		String utilizador = "Remígio Chicuava";	
		
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("tipo"));
			
		String nome=request.getParameter("nome");
		String tipo=request.getParameter("tipo");
		String mt = "Mts";
	
		ProdutoService produtoService= new ProdutoService();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaProdutos.jsp");
		request.setAttribute("utilizador", utilizador + " | Lista disponivel em: " + new Date());
		request.setAttribute("listaDeProdutos", produtoService.buscarTodosPorNomeTipo(nome, tipo));
		request.setAttribute("Mts", mt);
		requestDispatcher.forward(request, response);
				
		doGet(request, response);
	}

}
