package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String parameter = req.getParameter("id");
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(Integer.valueOf(parameter));
	
		
		req.setAttribute("empresa", empresa);
		RequestDispatcher rq = req.getRequestDispatcher("/editaEmpresa.jsp");
		rq.forward(req, resp);
	}
}
