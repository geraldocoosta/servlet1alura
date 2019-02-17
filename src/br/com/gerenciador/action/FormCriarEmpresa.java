package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCriarEmpresa implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		return "forward:formNovaEmpresa.jsp";
	}

}
