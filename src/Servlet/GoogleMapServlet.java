package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ParceirosService;
import Service.ProdutoService;


@WebServlet("/mapa")
public class GoogleMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GoogleMapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    ParceirosService parceirosService = new ParceirosService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mapa.jsp");
		request.setAttribute("parceiros", parceirosService.buscarParceiros(id));
		requestDispatcher.forward(request, response);
	}

	
	

}
