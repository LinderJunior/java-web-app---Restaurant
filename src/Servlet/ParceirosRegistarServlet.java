package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Parceiros;
import Service.ParceirosService;

/**
 * Servlet implementation class ParceirosRegistarServlet
 */
@WebServlet("/parceirosRegistar")
public class ParceirosRegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ParceirosRegistarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    Parceiros parceiros = new Parceiros();
    ParceirosService parceirosService = new ParceirosService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		parceiros.setEmail(request.getParameter("email"));
		parceiros.setTelefone(request.getParameter("telefone"));
		parceiros.setGps_latitude(request.getParameter("latitude"));
		parceiros.setGps_longitude(request.getParameter("longitude"));
		parceiros.setYoutube_videouid(request.getParameter("youtube"));
		
		parceirosService.adicionarParceiro(parceiros);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaParceiros.jsp");
		request.setAttribute("listaDosParceiros", parceirosService.listarParceiros());
		requestDispatcher.forward(request, response);
		
	}

}
