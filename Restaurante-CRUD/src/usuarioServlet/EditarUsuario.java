package usuarioServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Usuario;
import Service.UsuarioService;

@WebServlet("/updateUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService userService = new UsuarioService();
	

    public EditarUsuario() {
        super();
    }  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = Integer.valueOf(request.getParameter("id_usuario"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarUsuario.jsp");
		request.setAttribute("usuario", userService.buscarUsuario(id_usuario));
		requestDispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user =new Usuario();
		
		user.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
		user.setUsuario(request.getParameter("usuario"));
		user.setSenha(request.getParameter("senha"));
		user.setNivel_acesso(request.getParameter("nivel_acesso"));
		user.setContacto(request.getParameter("contacto"));
		user.setEmail(request.getParameter("email"));
		

		userService.actualizarUsuario(user);
		response.sendRedirect("usuarioListar");
			
	}
}
