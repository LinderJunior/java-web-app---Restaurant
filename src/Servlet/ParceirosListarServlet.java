package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ParceirosService;


@WebServlet("/parceirosListar")
public class ParceirosListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParceirosListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    ParceirosService parceirosService = new ParceirosService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaParceiros.jsp");// caminho do jsp
		request.setAttribute("listaDosParceiros", parceirosService.listarParceiros());
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
