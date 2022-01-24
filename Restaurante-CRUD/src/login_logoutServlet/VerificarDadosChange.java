package login_logoutServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Usuario;
import Service.UsuarioService;

/**
 * Servlet implementation class VerificarDadosChange
 */
@WebServlet("/verificarChange")
public class VerificarDadosChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificarDadosChange() {
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
		 UsuarioService usuarioService = new UsuarioService();
		    
			String email = request.getParameter("email");
			String contacto = request.getParameter("contacto");
			
			Usuario user = usuarioService.usuarioReset(email, contacto);

			
			if (user.getContacto()!=null) {
				
				
				Cookie loginCookie = new Cookie("usuarioLogado",contacto);
				Cookie loginCookie2 = new Cookie("usuarioLogadoAcesso",user.getNivel_acesso());
				
			    //ESPECIFICANDO QUE O COOKIE EXPIRA EM 30 MINUTOS
				loginCookie.setMaxAge(30*60); 
				response.addCookie(loginCookie);
				
				loginCookie2.setMaxAge(30*60); 
				response.addCookie(loginCookie2);
				
				
				response.sendRedirect("trocarPass.jsp");
				
			} else {
				response.sendRedirect("trocarPassErro.html");
			}
			
		doGet(request, response);
	}

}
