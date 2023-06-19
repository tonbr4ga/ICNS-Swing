package br.com.icnp.cli.view;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import br.com.icnp.cli.DAO.FuncionarioDAO;
import br.com.icnp.cli.DAO.ProdutoDAO;
import br.com.icnp.cli.service.Funcionario;
import br.com.icnp.cli.service.Nota;
import br.com.icnp.cli.service.Produto;
import br.com.icnp.cli.view.Main;

public class AreaLogadoUsuario {

	public static void main(String[] args, Funcionario funcionarioLogado) {
		try {
			ProdutoDAO produtos = new ProdutoDAO();
			Scanner entrada = new Scanner(System.in);
			boolean statusMenu = true;

			do {
				if(funcionarioLogado != null) {
				String escolhaMenu;
				System.out.println(Menu.apresentacaoLogado());
				escolhaMenu = entrada.next();
				switch (escolhaMenu) {

				case "1":
					String chaveNota;
					double valorTotal;
					int quantidadeProdutos;
					System.out.println("<----Cadastrar Nota---->");
					System.out.println("Insira a chave da nota: ");
					chaveNota = entrada.next();
					System.out.println("Insira o valor total da nota: R$xx,xx");
					valorTotal = entrada.nextDouble();
					System.out.println("Insira a quantidade de produtos cadastrado: ");
					quantidadeProdutos = entrada.nextInt();

					Nota notaFiscal = new Nota(chaveNota, valorTotal, quantidadeProdutos, funcionarioLogado);

					int codDeBarra, quantidade;
					Double valorUnitario;
					String tipoProduto, dataDeValidade, nomeDoProduto;
					for (int i = 0; i < quantidadeProdutos; i++) {
						System.out.println("<---Cadastre o Produto--->");
						System.out.println("Nome do Produto: ");
						entrada.nextLine();
						nomeDoProduto = entrada.nextLine();
						System.out.println("Insira o cód do produto: ");
						codDeBarra = entrada.nextInt();
						System.out.println("Insira o preço unitario do produto: ");
						valorUnitario = entrada.nextDouble();
						System.out.println("Tipo de Produto: ");
						tipoProduto = entrada.next();

						System.out.println("Insira a Vida útil do produto: yyyy-mm-dd");
						dataDeValidade = entrada.next();
						LocalDate data = LocalDate.parse(dataDeValidade);
						
						System.out.println("Qual é quantidade unitaria desse produto: ");
						quantidade = entrada.nextInt();
						
						for(int y = 0; y< quantidade; y++ ) {
							Produto produto = new Produto(codDeBarra, valorUnitario, tipoProduto, notaFiscal, data, nomeDoProduto );
							produtos.setProdutoDAO(produto);							
						}
					}

					break;

				case "2":
					// Buscar Usuario
					System.out.println("<---Buscando um produto--->");
					System.out.println("Digite o Codigo do Produto: ");
					codDeBarra = entrada.nextInt();
					produtos.buscarProdutos(codDeBarra);
					break;

				case "3":

					System.out.println("<---Alterar Produto--->");
					
					
					System.out.println("Insira o cód do produto que deseja alterar os dados: ");
					
					int codAlteracaoDoProduto = entrada.nextInt();
					
					System.out.println("Insira o nome do Produto: ");
					entrada.nextLine();
					nomeDoProduto = entrada.nextLine();					
					System.out.println("Insira os dados do novo produto");

					System.out.println("Insira a chave da nota: ");
					chaveNota = entrada.next();
					System.out.println("Insira o Preço do valor total da Nota: ");
					valorTotal = entrada.nextDouble();

					System.out.println("Insira o preço do produto: ");
					valorUnitario = entrada.nextDouble();

					System.out.println("Tipo de Produto: ");
					tipoProduto = entrada.next();

					System.out.println("Insira a Vida útil do produto: ");
					dataDeValidade = entrada.next();
					LocalDate data = LocalDate.parse(dataDeValidade);

					notaFiscal = new Nota(chaveNota, valorTotal, 1, funcionarioLogado);
					Produto produto = new Produto(codAlteracaoDoProduto, valorUnitario, tipoProduto, notaFiscal, data, nomeDoProduto);
					produtos.alterarProduto(produto);

					break;

				case "4":
					//Excluir 
					System.out.println("<---Excluindo Produto--->");
					System.out.println("Insira o codigo do produto que deseja remover: ");
					int codigoProdutoDeletado = entrada.nextInt();					
					System.out.println("Deseja deletar quantos produtos?");
					quantidade= entrada.nextInt();
					produtos.deletarProduto(codigoProdutoDeletado, quantidade);
					
					break;

				case "5":
					System.out.println("<---Exibindo todos os Produtos--->");
					produtos.buscarTodosProdutos();
					break;
				case "6":
					System.out.println("Saindo...");
					statusMenu = false;
					Main.main(args);
					break;
				default:
					System.out.println("Opçãp inválida.");
					}
				}
			} while (statusMenu);
			
		} catch (Exception err) {
			System.out.println("Erro: " + err.getMessage());
		}
	}	
	
	}
		

