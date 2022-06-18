package login_logoutServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Usuario;
import Service.UsuarioService;

@MultipartConfig
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
       
    //VERIFICAR AQUI..NAO IMPORTOU USUARIO
	UsuarioService usuarioService = new UsuarioService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    UsuarioService usuarioService = new UsuarioService();
		    //PrintWriter out = response.getWriter();
  
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			Usuario user = usuarioService.usuarioLogin(usuario, senha);

			if (user.getUsuario()!=null) {
						
				Cookie loginCookie = new Cookie("usuarioLogado",usuario);
				//Cookie loginCookie2 = new Cookie("usuarioLogadoAcesso",user.getNivel_acesso());
				
			    //ESPECIFICANDO QUE O COOKIE EXPIRA EM 30 MINUTOS
				//loginCookie.setMaxAge(12000000*60); 
				response.addCookie(loginCookie);
				
				//loginCookie2.setMaxAge(1200000*60); 
				//response.addCookie(loginCookie2);
		    
				
			    response.sendRedirect("index.jsp");
				System.out.print("linderJr Sucess");
				
			} else {
				response.sendRedirect("loginErro.html");
				System.out.print("Fail Linder");
				
			}
	
			doGet(request, response);
		}

	}
