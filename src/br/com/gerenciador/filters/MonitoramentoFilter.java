package br.com.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long antes = System.currentTimeMillis();

		chain.doFilter(request, response);

		System.out.println("Tempo utilizado na action " + request.getParameter("action") + " -> "
				+ (System.currentTimeMillis() - antes) + " ms ");
	}

}
