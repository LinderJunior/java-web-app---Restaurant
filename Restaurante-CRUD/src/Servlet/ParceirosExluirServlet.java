package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Parceiros;
import Service.ParceirosService;

/**
 * Servlet implementation class ParceirosExluirServlet
 */
@WebServlet("/parceirosExcluir")
public class ParceirosExluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ParceirosExluirServlet() {
        
    }

    
    ParceirosService parceirosService = new ParceirosService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		parceirosService.excluirParceiros(id);
		response.sendRedirect("parceirosListar");
	}

		

}
