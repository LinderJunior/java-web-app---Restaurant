package usuarioServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Usuario;
import Service.UsuarioService;

@WebServlet("/adicionarUsuario")
public class AdicionarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    UsuarioService userService = new UsuarioService();   
    public AdicionarUsuario() {
        super();    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		
		user.setUsuario(request.getParameter("usuario"));
		user.setSenha(request.getParameter("senha"));
		user.setNivel_acesso(request.getParameter("nivel_acesso"));
		user.setContacto(request.getParameter("contacto"));
		user.setEmail(request.getParameter("email"));

		userService.adicionarUsuario(user);
		response.sendRedirect("usuarioListar");
		
		doGet(request, response);
	}
}
