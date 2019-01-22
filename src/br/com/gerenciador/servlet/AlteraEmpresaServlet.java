package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Alterando nova empresa");

		String nomeEmpresa = req.getParameter("nome");
		String dataCriacao = req.getParameter("data");
		String idEmpresa = req.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateParse = null;
		try {
			dateParse = sdf.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException("Data não conseguiu ser parseada", e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataCriacao(dateParse);
		
		req.setAttribute("empresa", empresa);
		resp.sendRedirect("listaEmpresas");

	}

}
