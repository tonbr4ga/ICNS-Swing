package br.com.icnp.cli.service;

import java.util.Date;

public class Funcionario {
    private String cpf;
    private String nome;
    private String password;
    private String email;

    private Date dataCadastro;

    public Funcionario(String cpf, String nome, String password, Date date, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.password = password;
        this.dataCadastro = date;
        this.email = email;
    }
    
    public Funcionario(String cpf, String senha) {
    	this.cpf = cpf;
    	this.password = senha;	
    }
    
    public Funcionario(String cpf) {
    	this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public String getEmail() {
    	return this.email;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
}
