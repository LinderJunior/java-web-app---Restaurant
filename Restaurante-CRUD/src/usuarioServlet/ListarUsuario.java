package usuarioServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UsuarioService;

@WebServlet("/usuarioListar")
public class ListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuarioListar.jsp");
    	request.setAttribute("listaDeUsuarios", usuarioService.listarUsuario());
    	requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
