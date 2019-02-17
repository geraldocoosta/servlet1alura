package br.com.gerenciador.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Action{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		System.out.println("Alterando nova empresa");

		String nomeEmpresa = req.getParameter("nome");
		String dataCriacao = req.getParameter("data");
		String idEmpresa = req.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateParse = null;
		try {
			dateParse = sdf.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException("Data não conseguiu ser parseada", e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataCriacao(dateParse);
		
		req.setAttribute("empresa", empresa);
		return "redirect:ListaEmpresa";
	}

}
