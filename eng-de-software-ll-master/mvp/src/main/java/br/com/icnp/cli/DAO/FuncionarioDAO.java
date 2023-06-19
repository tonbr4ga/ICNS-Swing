package br.com.icnp.cli.DAO;

import br.com.icnp.cli.service.Funcionario;

public class FuncionarioDAO {
	private Funcionario[] listaFuncionarios = new Funcionario[5];

	public Funcionario[] getListaFuncionarios() {
		return listaFuncionarios;
	}

	public boolean funcionarioExiste(Funcionario funcionario) {
		for (int i = 0; i < this.listaFuncionarios.length; i++) {
			if (listaFuncionarios[i] != null) {
				if (funcionario.getCpf().equals(listaFuncionarios[i].getCpf())
						&& funcionario.getPassword().equals(listaFuncionarios[i].getPassword())) {
					return true;
				}
			}
		}

		return false;
	}
	
	public boolean funcionarioExiste(String cpf) {
		for (int i = 0; i < this.listaFuncionarios.length; i++) {
			if (listaFuncionarios[i] != null) {
				if (listaFuncionarios[i].getCpf().equals(cpf)) {
					return true;
				}
			}
		}

		return false;
	}

	public void setFuncionarioDAO(Funcionario novoFuncionario) {
		for (int i = 0; i < this.listaFuncionarios.length; i++) {
			Funcionario funcionario = this.listaFuncionarios[i];
			if (funcionario == null && !(funcionarioExiste(novoFuncionario))) {
				this.listaFuncionarios[i] = novoFuncionario;
			}
		}
	}

	public void alterarFuncionario(Funcionario alteracaoFuncionario) {
		if (funcionarioExiste(alteracaoFuncionario)) {
			for (int i = 0; i < this.listaFuncionarios.length; i++) {
				Funcionario funcionario = this.listaFuncionarios[i];
				if (funcionario != null) {
					if (funcionario.getCpf().equals(funcionario.getCpf())
							&& funcionario.getPassword().equals(alteracaoFuncionario.getPassword())) {
						listaFuncionarios[i] = alteracaoFuncionario;
						System.out.println("Usuario alterado!");
					} else {
						System.out.println("Usuario ou senha invalidos!");

					}
				}
			}
		} else {
			System.out.print("Usuario não cadastrado ou senha invalida!");
		}
	}

	public void deletarFuncionario(String cpf) {
		if (funcionarioExiste(cpf)) {
			for (int i = 0; i < this.listaFuncionarios.length; i++) {
				Funcionario funcionario = this.listaFuncionarios[i];
				if (listaFuncionarios[i] != null) {
					if (funcionario.getCpf().equals(cpf)){
						listaFuncionarios[i] = null;
						System.out.println("Usuario deletado!");
					}
				}
			}
		} else {
			System.out.print("Usuario não cadastrado");
		}
	}

	public void buscarUsuarios(String cpf) {
		if (funcionarioExiste(cpf)) {
			for (int i = 0; i < this.listaFuncionarios.length; i++) {
				Funcionario funcionarioLista = this.listaFuncionarios[i];
				if (funcionarioLista != null) {
					if (funcionarioLista.getCpf().equals(cpf)) {
						String nome = funcionarioLista.getNome();
						String email = funcionarioLista.getEmail();
						String CPF = funcionarioLista.getCpf();
						String data = funcionarioLista.getDataCadastro().toString();
						String texto = """
								Nome: %s
								CPF: %s
								Data Cadastro: %s
								Email: %s
								""".formatted(nome, CPF, data, email);
						System.out.println(texto);
					}
				}
			}
		} else {
			System.out.println("Não encontrado");
		}
	}

}
