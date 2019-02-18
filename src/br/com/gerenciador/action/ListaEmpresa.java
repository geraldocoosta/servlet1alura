package br.com.gerenciador.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class ListaEmpresa implements Action {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		if (session.getAttribute("usuario") == null) {
			return "redirect:FormLogin";
		}

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		req.setAttribute("listaEmpresas", empresas);

		return "forward:listaEmpresas.jsp";
	}

}
