package br.com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Usuario;

public class Login implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Banco banco = new Banco();
		Usuario user = banco.confereCredenciais(login, senha);

		if (user != null) {
			return "redirect:ListaEmpresa";
		} else {
			return "redirect:FormLogin";
		}
	}

}
