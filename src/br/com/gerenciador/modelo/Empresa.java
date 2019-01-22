package br.com.gerenciador.modelo;

import java.util.Date;

public class Empresa {

	private String nome;
	private Integer id;
	private Date dataCriacao;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
