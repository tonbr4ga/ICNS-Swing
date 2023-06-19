package br.com.icnp.cli.service;

import java.time.LocalDate;

public class Produto {
	private int codDeBarra;
	private Double valorUnitario;
	private String tipoProduto;
	private Nota notaFisca;
	private LocalDate dataDeValidade;
	private String nomeDoProduto;
	
	
	public Produto(int codDeBarra, double valorUnitario, String tipoProduto, Nota notaFical, LocalDate dataDeValidade, String nomeDoProduto) {
		this.setNomeDoProduto(nomeDoProduto);
		this.codDeBarra = codDeBarra;
		this.valorUnitario = valorUnitario;
		this.tipoProduto = tipoProduto;
		this.notaFisca = notaFical;
		this.dataDeValidade = dataDeValidade;
		
	}
	
	public Produto(int codDeBarra)	{
		this.codDeBarra = codDeBarra;
	}
	
	public int getCodDeBarra() {
		return codDeBarra;
	}
	public void setCodDeBarra(int codDeBarra) {
		this.codDeBarra = codDeBarra;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Nota getNotaFisca() {
		return notaFisca;
	}
	public void setNotaFisca(Nota notaFisca) {
		this.notaFisca = notaFisca;
	}
	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}
	}
