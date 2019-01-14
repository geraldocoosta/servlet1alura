package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	private static final long serialVersionUID = -4084840221372790953L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer;
		writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("OLA MUNDO");
		writer.write("</body>");
		writer.write("</html>");
		writer.flush();
		
		System.out.println("Primeiro servlet chamado");
	}

}
