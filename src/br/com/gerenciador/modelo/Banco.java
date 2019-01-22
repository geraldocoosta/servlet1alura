package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static Integer ids = 2;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(0);
		empresa.setNome("Caixa");
		empresa.setDataCriacao(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setId(1);
		empresa2.setNome("Caelum");
		empresa2.setDataCriacao(new Date());
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(ids++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
	
	public void removeEmpresaPorId(Integer id) {
		Iterator<Empresa> iterator = listaEmpresas.iterator();
		while(iterator.hasNext()) {
			Empresa empresa = iterator.next();
			if (empresa.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}
	
	public Empresa getEmpresaPorId(Integer id) {
		for(Empresa empresa : listaEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
}
