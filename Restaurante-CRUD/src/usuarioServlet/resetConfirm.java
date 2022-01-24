package usuarioServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Usuario;
import Service.UsuarioService;

@WebServlet("/reset")
public class resetConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService userService = new UsuarioService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetConfirm() {
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
	
		Usuario user =new Usuario();
		user.setSenha(request.getParameter("senha"));
		user.setContacto(request.getParameter("contacto"));

		userService.resetPassword(user);
	
		

		if(user.getContacto()!=null) {
			System.out.print("Senha Atualizada com sucesso");
			response.sendRedirect("loginReset.html");
		}
		doGet(request, response);
		
	}
}
