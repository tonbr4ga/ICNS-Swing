package br.com.icnp.cli.service;

import java.util.Date;

public class Nota {
	private String chaveNota;
	private double valorTotal;
	private int quantidadeProdutos;
	private Date dataRequecebimento;
	private Funcionario cadastradoPor;
	
	
	public Nota(String chaveNota, double valorTotal, int quantidadeProduto, Funcionario funcionario) {
		this.chaveNota = chaveNota;
		this.valorTotal = valorTotal;
		this.quantidadeProdutos = quantidadeProduto;
		this.dataRequecebimento = new Date();
		this.cadastradoPor = funcionario;
		
	}
	
	public String getChaveNota() {
		return chaveNota;
	}
	public void setChaveNota(String chaveNota) {
		this.chaveNota = chaveNota;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	public void setQuantidadeProdutos(int quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}
	public Date getDataRequecebimento() {
		return dataRequecebimento;
	}
	public void setDataRequecebimento(Date dataRequecebimento) {
		this.dataRequecebimento = dataRequecebimento;
	}
	public Funcionario getCadastradoPor() {
		return cadastradoPor;
	}
	public void setCadastradoPor(Funcionario cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}

	
}
