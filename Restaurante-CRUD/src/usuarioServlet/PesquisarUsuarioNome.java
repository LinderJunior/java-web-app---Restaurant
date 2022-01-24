package usuarioServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UsuarioService;

@WebServlet("/pesquisarUsuarioNome")
public class PesquisarUsuarioNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public PesquisarUsuarioNome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("usuario"));
		String usuario = (request.getParameter("usuario"));
		
		UsuarioService usuarioService = new UsuarioService();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuarioListar.jsp");
    	request.setAttribute("listaDeUsuario", usuarioService.pesquisarNome(usuario));
    	
    	requestDispatcher.forward(request, response);
    	
    	doGet(request, response);
	}

}
