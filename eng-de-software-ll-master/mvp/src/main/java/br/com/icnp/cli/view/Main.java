package br.com.icnp.cli.view;

import br.com.icnp.cli.DAO.FuncionarioDAO;

public class Main {

    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Login login = new Login(funcionarioDAO);
    }
}
