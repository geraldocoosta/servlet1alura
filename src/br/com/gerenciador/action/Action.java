package br.com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException;
}
