package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresaServletService extends HttpServlet {

	private static final long serialVersionUID = -3019955433392576079L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String header = request.getHeader("Accept");
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		if (header.contains("xml")) {
			response.setContentType("application/xml");
			String xml = new XStream().toXML(empresas);
			
			PrintWriter out = response.getWriter();
			out.println(xml);
			out.flush();
		}else if (header.endsWith("json")) {
			response.setContentType("application/json");
			String json = new Gson().toJson(empresas);
		
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		}else {
			PrintWriter out = response.getWriter();
			out.println("{ \"error\": \" Accept não enviado \"}");
			out.flush();
		}
	}
}
