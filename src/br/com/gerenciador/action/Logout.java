package br.com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		HttpSession session = req.getSession();
		// existe essa forma de logout
		session.invalidate();
		// e essa também
		// session.removeAttribute("usuario");

		return "redirect:FormLogin";
	}

}
