package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

import br.com.gerenciador.modelo.Empresa;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();

	public void adiciona(Empresa empresa) {
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
	
}
