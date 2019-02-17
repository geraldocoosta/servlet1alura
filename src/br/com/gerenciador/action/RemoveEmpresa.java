package br.com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		
		String id = req.getParameter("id");
	
		Banco banco = new Banco();
		banco.removeEmpresaPorId(Integer.parseInt(id));
		
		return "redirect:ListaEmpresa";
	}

}
