package Servlet;


import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ComumDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;



/**
 * Servlet implementation class RelatorioServlet
 */
@WebServlet("/relatorioProduto")
public class ProdutoRelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoRelatorioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = ComumDAO.getConnection();
		
		String erro = "";
		String tipo = request.getParameter("tipo");
		String jasper = "report/reportProduto.jasper";

		HashMap <String, Object> parametro = new HashMap <String, Object>();
		parametro.put("tipo", tipo);
		
		byte[] bytes = null;
		
		ServletContext contexto = getServletContext();

		try {
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(contexto.getRealPath(jasper));
			bytes = JasperRunManager.runReportToPdf(relatorio, parametro, connection);
		} catch (JRException e) {
			erro = e.getMessage();
		} finally {
			if (bytes != null) {

				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream sos = response.getOutputStream();
				sos.write(bytes);
				sos.flush();
				sos.close();
			} else {
				System.out.println("aqui");
				request.setAttribute("erro", erro);
				System.out.println(erro);
			}
		}		
	}

	
}
