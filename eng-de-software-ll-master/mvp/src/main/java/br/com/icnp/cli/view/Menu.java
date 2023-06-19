package br.com.icnp.cli.view;

public class Menu {
    public static String apresetacao(){
        return """
                Seja bem-vindo ao nosso primeiro MVP do sistema de Gerenciamento de Caixa, Estoque e Vendas. 
                A ideia deste mini projeto é colocar em prática nossos conhecimentos de Programação Orientada a Objetos,
                juntamente com a disciplina de Engenharia II. Realizamos levantamentos de requisitos funcionais e não funcionais do projeto, 
                bem como Diagramas de Caso de Uso e de Classe.
                """;
    }
    public static String apresetacaoMenu(){
        return  """
                Seja bem-vindo, gostaria de realizar o Login em nosso Sistema ou deseja se cadastrar?
                1 - Login
                2 - Cadastro
                3 - Alterar Usuario
                4 - Excluir Usuario
                5 - Buscar Usuario
                6 - Sair
                """;
    }
    
    public static String apresentacaoLogado() {
		return """
				Seja bem-vindo!
			
1 - Cadastrar Produto
2 - Buscar Produto
3 - Alterar Produto
4 - Excluir Produto 
5 - Buscar Todos os Produtos 
6 - Sair
                """;
    	
    }
    
 

}
