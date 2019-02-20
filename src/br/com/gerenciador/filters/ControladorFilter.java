package br.com.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.action.Action;

public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String action = req.getParameter("action");

		String redirecionamento = null;
		try {
			Class<?> forName = Class.forName("br.com.gerenciador.action." + action);
			Action acaoImpl = (Action) forName.newInstance();
			redirecionamento = acaoImpl.executa(req, resp);
		} catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException e) {
			throw new ServletException(e);
		}

		if (redirecionamento != null && !redirecionamento.isEmpty()) {
			String[] tipoRedirecionamento = redirecionamento.split(":");
			executaRedirecionamento(tipoRedirecionamento, req, resp);
		}
	}

	private void executaRedirecionamento(String[] tipoRedirecionamento, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		if (tipoRedirecionamento[0].equals("forward")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/" + tipoRedirecionamento[1]);
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("entrada?action=" + tipoRedirecionamento[1]);
		}
	}

}
