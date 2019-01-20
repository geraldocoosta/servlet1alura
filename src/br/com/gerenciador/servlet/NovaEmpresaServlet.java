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


@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataCriacao = request.getParameter("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateParse = null;
		try {
			dateParse = sdf.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException("Data não conseguiu ser parseada", e);
		}
		
		
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataCriacao(dateParse);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		
		request.setAttribute("empresa", empresa);
		response.sendRedirect("listaEmpresas");
		
		// Chamar a jsp
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa);
//		dispatcher.forward(request, response);
	}

}
