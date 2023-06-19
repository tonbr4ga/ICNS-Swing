package br.com.icnp.cli.DAO;

import br.com.icnp.cli.service.Produto;

public class ProdutoDAO {
	private Produto[] listaDeProduto = new Produto[50];

	public Produto[] getListaDeProduto() {
		return listaDeProduto;
	}

	public boolean produtoExiste(int codDeBarra) {
		for (int i = 0; i < this.listaDeProduto.length; i++) {
			if (listaDeProduto[i] != null) {
				if (listaDeProduto[i].getCodDeBarra() == codDeBarra) {
					return true;
				}
			}
		}

		return false;
	}

	public void setProdutoDAO(Produto produtoNovo) {
		for (int i = 0; i < this.listaDeProduto.length; i++) {
			Produto produto = this.listaDeProduto[i];
			if (produto == null) {
				this.listaDeProduto[i] = produtoNovo;
				System.out.println("Produto cadastrado com sucesso");
				break;
			}
		}
	}

	public void buscarProdutos(int codProduto) {
		if (produtoExiste(codProduto)) {
			for (int i = 0; i < this.listaDeProduto.length; i++) {
				Produto produtoLista = this.listaDeProduto[i];
				if (produtoLista != null) {
					if (codProduto == produtoLista.getCodDeBarra()) {
						int codBarra = produtoLista.getCodDeBarra();
						String nomeDoProduto = produtoLista.getNomeDoProduto();
						Double valorUnit = produtoLista.getValorUnitario();
						String tipoProd = produtoLista.getTipoProduto();
						String data = produtoLista.getDataDeValidade().toString();
						String nota = """
								Coódigo de Barras: %s
								Nome do Produto: %s
								Valor unitário: %s
								Tipo do Produto: %s
								Data de validade: %s
								""".formatted(codBarra, nomeDoProduto, valorUnit, tipoProd, data);
						System.out.println(nota);
					}
				}
			}
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void buscarTodosProdutos() {

		for (int i = 0; i < this.listaDeProduto.length; i++) {
			Produto produtoLista = this.listaDeProduto[i];
			if (listaDeProduto[i] != null) {

				int codBarra = produtoLista.getCodDeBarra();
				String nomeDoProduto = produtoLista.getNomeDoProduto();
				Double valorUnit = produtoLista.getValorUnitario();
				String tipoProd = produtoLista.getTipoProduto();
				String data = produtoLista.getDataDeValidade().toString();
				String nota = """
						Código de Barras: %s
						Nome do Produto: %s
						Valor unitário: %s
						Tipo do Produto: %s
						Data de validade: %s
						""".formatted(codBarra, nomeDoProduto, valorUnit, tipoProd, data);
				System.out.println(nota);
			}
		}
	}

	public void alterarProduto(Produto alteracaoProduto) {
		if (produtoExiste(alteracaoProduto.getCodDeBarra())) {
			for (int i = 0; i < this.listaDeProduto.length; i++) {
				Produto produto = this.listaDeProduto[i];
				if (listaDeProduto[i] != null) {
					if (produto.getCodDeBarra() == (alteracaoProduto.getCodDeBarra())) {
						listaDeProduto[i] = alteracaoProduto;
						System.out.println("Produto alterado!");
					}
				}
			}
		} else {
			System.out.print("Produto não cadastrado!");
		}
	}


	
	public void deletarProduto(int codProduto, int quantidade) {
		if (produtoExiste(codProduto)) {
			for (int i = 0; i < this.listaDeProduto.length; i++) {
				Produto produto = this.listaDeProduto[i];
				if (produto != null) {
					if (produto.getCodDeBarra() == codProduto && quantidade > 0) {
						listaDeProduto[i] = null;
						quantidade--;
					}
				}
			}
			
		} else {
			System.out.print("Produto não cadastrado!");
		}
	}

}
