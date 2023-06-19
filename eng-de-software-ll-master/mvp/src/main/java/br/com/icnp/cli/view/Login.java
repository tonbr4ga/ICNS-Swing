package br.com.icnp.cli.view;

import br.com.icnp.cli.DAO.FuncionarioDAO;
import br.com.icnp.cli.service.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	FuncionarioDAO funcionarioDAO;
	private JFrame janela;
	private JButton botaoTelaEntrar;
	private JButton botaoTelaCadastrar;
	private JTextField txtCPFLogin;
	private JPasswordField txtSenhaLogin;
	// Label's
	private JLabel labelTitleICNS;
	private JLabel labelSenhaLogin;
	private JLabel labelCPFLogin;

	public Login(FuncionarioDAO funcionarioDAO){
		this.funcionarioDAO = funcionarioDAO;
		this.montaJanela();
	}
	public JLabel getLabelSenhaLogin() {
		labelSenhaLogin = new JLabel("Senha");
		labelSenhaLogin.setForeground(Color.black);
		labelSenhaLogin.setFont(new Font("", Font.BOLD, 10));
		labelSenhaLogin.setBounds(new Rectangle(100, 95, 60, 25));
		return labelSenhaLogin;
	}
	public JTextField getTxtCPFLogin() {
		txtCPFLogin = new JTextField(20);
		txtCPFLogin.setBounds(new Rectangle(100, 75, 180, 25));
		return txtCPFLogin;
	}
	public JTextField getTxtSenhaLogin() {
		txtSenhaLogin = new JPasswordField(20);
		txtSenhaLogin.setBounds(new Rectangle(100, 125, 180, 25));
		return txtSenhaLogin;
	}
	public JButton getBotaoTelaEntrar() {
		botaoTelaEntrar = new JButton("Entrar");
		botaoTelaEntrar.setBounds(new Rectangle(100, 175, 75, 25));
		botaoTelaEntrar.setToolTipText("Pressione aqui para realizar Login");
		botaoTelaEntrar.setBackground(new Color(219, 19, 19));

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textoCPFlogin = txtCPFLogin.getText();
				String textoSenha = txtSenhaLogin.getText();
				Funcionario login = new Funcionario(textoCPFlogin, textoSenha);

				boolean loginValido = funcionarioDAO.funcionarioExiste(login);

				if (loginValido) {
					System.out.println("Login realizado com sucesso!");
					JanelaLogado janelaProdutos = new JanelaLogado(funcionarioDAO);
					janela.dispose();
				} else {
					System.out.println("Usuário ou senha inválido");
				}
			}
		};

		botaoTelaEntrar.addActionListener(listener);

		return botaoTelaEntrar;
	}
	public JButton getBotaoTelaCadastrar() {
		botaoTelaCadastrar = new JButton("Cadastrar");
		botaoTelaCadastrar.setBounds(new Rectangle(185, 175, 95, 25));
		botaoTelaCadastrar.setToolTipText("Pressione aqui para realizar Login");
		botaoTelaCadastrar.setBackground(new Color(219, 19, 19));

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				Cadastro telaCadastro = new Cadastro(funcionarioDAO);
			}
		};
		botaoTelaCadastrar.addActionListener(listener);

		return botaoTelaCadastrar;
	}
	public JLabel getLabelCPFLogin() {
		labelCPFLogin = new JLabel("CPF");
		labelCPFLogin.setForeground(Color.black);
		labelCPFLogin.setFont(new Font("", Font.BOLD, 10));
		labelCPFLogin.setBounds(new Rectangle(100, 45, 60, 25));
		return labelCPFLogin;
	}
	public JLabel getLabelTitleICNS() {
		labelTitleICNS = new JLabel("ICNS - Manager");
		labelTitleICNS.setForeground(Color.black);
		labelTitleICNS.setFont(new Font("", Font.BOLD, 14));
		labelTitleICNS.setBounds(new Rectangle(10, 10, 130, 25));
		return labelTitleICNS;
	}
	public void montaJanela() {
		janela = new JFrame();
		janela.setTitle("Projeto ICNS - Gerenciamento ");
		janela.setSize(400, 300);
		janela.setLocation(800,100 );
		janela.setLayout(null);
		janela.setResizable(true);
		janela.getContentPane().setBackground(new Color(255, 165, 0));
		janela.getContentPane().add(getLabelTitleICNS());
		janela.getContentPane().add(getLabelCPFLogin());
		janela.getContentPane().add(getTxtCPFLogin());
		janela.getContentPane().add(getLabelSenhaLogin());
		janela.getContentPane().add(getTxtSenhaLogin());
		janela.getContentPane().add(getBotaoTelaEntrar());
		janela.getContentPane().add(getBotaoTelaCadastrar());
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
