package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Action{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String parameter = req.getParameter("id");
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(Integer.valueOf(parameter));
	
		
		req.setAttribute("empresa", empresa);
		
		return "forward:editaEmpresa.jsp";
	}

}
