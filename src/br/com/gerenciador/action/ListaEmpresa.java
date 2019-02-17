package br.com.gerenciador.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class ListaEmpresa implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
	
		req.setAttribute("listaEmpresas", empresas);
		
		return "forward:listaEmpresas.jsp";
	}

}
