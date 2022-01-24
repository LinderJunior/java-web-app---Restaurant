package Servlet;

import java.awt.print.PrinterException;
import java.io.IOException;

import javax.print.PrintException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Parceiros;
import Service.ParceirosService;

/**
 * Servlet implementation class ParceirosServlet
 */
@WebServlet("/parceiros")
public class ParceirosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParceirosServlet() {
        super();
        
    }
    
    Parceiros parceiros = new Parceiros();
    ParceirosService parceirosService = new ParceirosService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String accao = request.getParameter("accao");
			int id = Integer.valueOf(request.getParameter("id"));
			
			if(accao.equalsIgnoreCase("excluir")){
				parceirosService.excluirParceiros(id);
				
			}else if (accao.equalsIgnoreCase("listar")){
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaParceiros.jsp");
				request.setAttribute("listaDosParceiros", parceirosService.listarParceiros());
				requestDispatcher.forward(request, response);
			}
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String accao = request.getParameter("accao");
			int id = Integer.valueOf(request.getParameter("id"));
			
			if (accao.equalsIgnoreCase("excluir")){
				parceirosService.excluirParceiros(id);
				
			}else if (accao.equalsIgnoreCase("adicionar")){
				parceiros.setEmail(request.getParameter("email"));
				parceiros.setTelefone(request.getParameter("telefone"));
				parceiros.setGps_latitude(request.getParameter("latitude"));
				parceiros.setGps_longitude(request.getParameter("longitude"));
				parceiros.setYoutube_videouid(request.getParameter("youtbe"));
				
				parceirosService.adicionarParceiro(parceiros);
				
			}else if (accao.equalsIgnoreCase("editar")){
				
				parceiros.setEmail(request.getParameter("email"));
				parceiros.setTelefone(request.getParameter("telefone"));
				parceiros.setGps_latitude(request.getParameter("latitude"));
				parceiros.setGps_longitude(request.getParameter("longitude"));
				parceiros.setYoutube_videouid(request.getParameter("youtbe"));
				
				parceirosService.editarParceiro(parceiros);
				
			}
			
				
			
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		doGet(request, response);
	}

}
