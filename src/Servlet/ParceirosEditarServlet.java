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

@WebServlet("/parceirosEditar")
public class ParceirosEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParceirosEditarServlet() {
        super();
        
    }

    Parceiros parceiros = new Parceiros();
    ParceirosService parceirosService = new ParceirosService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarParceiro.jsp");
		request.setAttribute("parceiros", parceirosService.buscarParceiros(id));
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		parceiros.setId(Integer.parseInt(request.getParameter("id")));
		parceiros.setEmail(request.getParameter("email"));
		parceiros.setTelefone(request.getParameter("telefone"));
		parceiros.setGps_latitude(request.getParameter("gps_latitude"));
		parceiros.setGps_longitude(request.getParameter("gps_longitude"));
		parceiros.setYoutube_videouid(request.getParameter("youtube_videouid"));
		
		parceirosService.editarParceiro(parceiros);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaParceiros.jsp");
		request.setAttribute("listaDosParceiros", parceirosService.listarParceiros());
		requestDispatcher.forward(request, response); 
	}

}
