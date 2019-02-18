package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.action.Action;

@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -233398019875504162L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		HttpSession session = req.getSession();

		/* Autenticação não deveria ficar aqui */
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuario") == null);
		boolean ehUmaAcaoProtegida = !(action.equals("Login") || action.equals("FormLogin"));

		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			resp.sendRedirect("entrada?action=FormLogin");
			return;
		}
		
		/*
		 * Devemos colocar isso aqui em um filtro, geralmente iremos consumir front
		 * controllers prontos e não iremos modificar esse controller
		 */

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
