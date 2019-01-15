package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();

	static {
		Empresa empresa = new Empresa();
		empresa.setId(0);
		empresa.setNome("Caixa");
		Empresa empresa2 = new Empresa();
		empresa2.setId(1);
		empresa2.setNome("Caelum");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
	
}
