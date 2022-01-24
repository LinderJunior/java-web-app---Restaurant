package usuarioServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UsuarioService;

@WebServlet("/removerUsuario")
public class RemoverUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoverUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService userService = new UsuarioService();
		int id_usuario = Integer.valueOf(request.getParameter("id_usuario"));
		userService.apagarUsuario(id_usuario);
	
		response.sendRedirect("usuarioListar");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
