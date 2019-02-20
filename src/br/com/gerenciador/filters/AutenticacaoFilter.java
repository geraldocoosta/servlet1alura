package br.com.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutenticacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String action = req.getParameter("action");
		HttpSession session = request.getSession();

		/* Autenticação não deveria ficar aqui */
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuario") == null);
		boolean ehUmaAcaoProtegida = !(action.equals("Login") || action.equals("FormLogin"));

		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?action=FormLogin");
			return;
		}
		
		
		chain.doFilter(req, resp);
	}

}
