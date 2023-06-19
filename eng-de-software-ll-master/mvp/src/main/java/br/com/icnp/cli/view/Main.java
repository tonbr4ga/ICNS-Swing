package br.com.icnp.cli.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.icnp.cli.DAO.FuncionarioDAO;
import br.com.icnp.cli.service.Funcionario;

public class Main extends JFrame {

	// Janelas
	private JFrame janela;

	// Button's HUB
	FuncionarioDAO funcionarios = new FuncionarioDAO();
	private JButton botaoTelaEntrar;

	public JButton getBotaoTelaEntrar() {
		botaoTelaEntrar = new JButton("Entrar");
		botaoTelaEntrar.setBounds(new Rectangle(420, 175, 140, 25));
		botaoTelaEntrar.setToolTipText("Pressione aqui para realizar Login");
		botaoTelaEntrar.setBackground(new Color(170, 12, 12));

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textoCPFlogin = txtCPFLogin.getText();
				String textoSenha = txtSenhaLogin.getText();
				Funcionario login = new Funcionario(textoCPFlogin, textoSenha);

				// Lógica de validação do login
				boolean loginValido = funcionarios.funcionarioExiste(login);

				if (loginValido) {
					System.out.println("Login realizado com sucesso!");

					// Transição para a tela JanelaLogado
					JanelaLogado janelaProdutos = new JanelaLogado();
					janelaProdutos.setVisible(true);
				} else {
					System.out.println("Usuário ou senha inválido");
				}
			}
		};

		botaoTelaEntrar.addActionListener(listener);

		return botaoTelaEntrar;
	}

	private JButton botaoTelaCadastrar;

	public JButton getBotaoTelaCadastrar() {
		botaoTelaCadastrar = new JButton("Cadastrar");
		botaoTelaCadastrar.setBounds(new Rectangle(40, 360, 140, 25));
		botaoTelaCadastrar.setBackground(new Color(170, 12, 12));
		botaoTelaCadastrar.setToolTipText("Pressione aqui para realizar o Cadastro");

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoCPFcadastro = txtCpf.getText();
				String textoNome = txtNome.getText();
				String textoEmail = txtEmail.getText();
				String textoSenha = txtSenha.getText();
				String textoRepetirSenha = txtRepetirSenha.getText();

				if (textoSenha.equals(textoRepetirSenha)) {
					Funcionario novoFuncionario = new Funcionario(textoCPFcadastro, textoNome, textoSenha, new Date(0),
							textoEmail);
					funcionarios.setFuncionarioDAO(novoFuncionario);
					System.out.println("\nUsuario Cadastrado");
				} else {
					System.out.println("\nErro no Cadastro!");
				}
			}

		};
		botaoTelaCadastrar.addActionListener(listener);
		return botaoTelaCadastrar;
	}

	// TextField
	private JTextField txtCpf;

	public JTextField getTxtCpf() {
		txtCpf = new JTextField(20);
		txtCpf.setBounds(new Rectangle(12, 75, 180, 25));
		return txtCpf;
	}

	private JTextField txtNome;

	public JTextField getTxtNome() {
		txtNome = new JTextField(20);
		txtNome.setBounds(new Rectangle(12, 125, 180, 25));
		return txtNome;
	}

	private JTextField txtEmail;

	public JTextField getTxtEmail() {
		txtEmail = new JTextField(20);
		txtEmail.setBounds(new Rectangle(12, 175, 180, 25));
		return txtEmail;
	}

	private JTextField txtSenha;

	public JTextField getTxtSenha() {
		txtSenha = new JTextField(20);
		txtSenha.setBounds(new Rectangle(12, 225, 180, 25));
		return txtSenha;
	}

	private JTextField txtRepetirSenha;

	public JTextField getTxtRepetirSenha() {
		txtRepetirSenha = new JTextField(20);
		txtRepetirSenha.setBounds(new Rectangle(12, 275, 180, 25));
		return txtRepetirSenha;
	}

	private JTextField txtCPFLogin;

	public JTextField getTxtCPFLogin() {
		txtCPFLogin = new JTextField(20);
		txtCPFLogin.setBounds(new Rectangle(400, 75, 180, 25));
		return txtCPFLogin;
	}

	private JTextField txtSenhaLogin;

	public JTextField getTxtSenhaLogin() {
		txtSenhaLogin = new JTextField(20);
		txtSenhaLogin.setBounds(new Rectangle(400, 125, 180, 25));
		return txtSenhaLogin;
	}

	// Label's

	private JLabel labelTitleICNS;

	public JLabel getLabelTitleICNS() {
		labelTitleICNS = new JLabel("ICNS - Manager");
		labelTitleICNS.setForeground(Color.black);
		labelTitleICNS.setFont(new Font("", Font.BOLD, 14));
		labelTitleICNS.setBounds(new Rectangle(10, 10, 130, 25));
		return labelTitleICNS;
	}

	private JLabel labelCPFCadastro;

	public JLabel getLabelCPFCadastro() {
		labelCPFCadastro = new JLabel("CPF");
		labelCPFCadastro.setForeground(Color.black);
		labelCPFCadastro.setFont(new Font("", Font.BOLD, 10));
		labelCPFCadastro.setBounds(new Rectangle(20, 45, 60, 25));
		return labelCPFCadastro;
	}

	private JLabel labelNome;

	public JLabel getLabelNome() {
		labelNome = new JLabel("Nome");
		labelNome.setForeground(Color.black);
		labelNome.setFont(new Font("", Font.BOLD, 10));
		labelNome.setBounds(new Rectangle(20, 95, 60, 25));
		return labelNome;
	}

	private JLabel labelEmail;

	public JLabel getLabelEmail() {
		labelEmail = new JLabel("Email");
		labelEmail.setForeground(Color.black);
		labelEmail.setFont(new Font("", Font.BOLD, 10));
		labelEmail.setBounds(new Rectangle(20, 145, 60, 25));
		return labelEmail;
	}

	private JLabel labelSenhaCadastro;

	public JLabel getLabelSenhaCadastro() {
		labelSenhaCadastro = new JLabel("Senha");
		labelSenhaCadastro.setForeground(Color.black);
		labelSenhaCadastro.setFont(new Font("", Font.BOLD, 10));
		labelSenhaCadastro.setBounds(new Rectangle(20, 200, 60, 25));
		return labelSenhaCadastro;
	}

	private JLabel labelRepetirSenha;

	public JLabel getLabelRepetirSenha() {
		labelRepetirSenha = new JLabel("Repitir Senha");
		labelRepetirSenha.setForeground(Color.black);
		labelRepetirSenha.setFont(new Font("", Font.BOLD, 10));
		labelRepetirSenha.setBounds(new Rectangle(20, 250, 100, 25));
		return labelRepetirSenha;
	}

	private JLabel labelCPFLogin;

	public JLabel getLabelCPFLogin() {
		labelCPFLogin = new JLabel("CPF");
		labelCPFLogin.setForeground(Color.black);
		labelCPFLogin.setFont(new Font("", Font.BOLD, 10));
		labelCPFLogin.setBounds(new Rectangle(400, 45, 60, 25));
		return labelCPFLogin;
	}

	private JLabel labelSenhaLogin;

	public JLabel getLabelSenhaLogin() {
		labelSenhaLogin = new JLabel("Senha");
		labelSenhaLogin.setForeground(Color.black);
		labelSenhaLogin.setFont(new Font("", Font.BOLD, 10));
		labelSenhaLogin.setBounds(new Rectangle(400, 95, 60, 25));
		return labelSenhaLogin;
	}

//Janela

	public void montaJanela() {

		janela = new JFrame();
		janela.setTitle("Projeto ICNS - Gerenciamento ");
		janela.setSize(800, 600);
		janela.setLocation(300, 150);
		janela.setLayout(null);
		janela.setResizable(true);
		janela.getContentPane().setBackground(new Color(255, 165, 0));

		janela.getContentPane().add(getLabelTitleICNS());

		janela.getContentPane().add(getLabelCPFCadastro());

		janela.getContentPane().add(getTxtCpf());

		janela.getContentPane().add(getLabelNome());

		janela.getContentPane().add(getTxtNome());

		janela.getContentPane().add(getLabelEmail());

		janela.getContentPane().add(getTxtEmail());

		janela.getContentPane().add(getLabelSenhaCadastro());

		janela.getContentPane().add(getTxtSenha());

		janela.getContentPane().add(getLabelRepetirSenha());

		janela.getContentPane().add(getTxtRepetirSenha());

		janela.getContentPane().add(getBotaoTelaCadastrar());

		janela.getContentPane().add(getLabelCPFLogin());

		janela.getContentPane().add(getTxtCPFLogin());

		janela.getContentPane().add(getLabelSenhaLogin());

		janela.getContentPane().add(getTxtSenhaLogin());

		janela.getContentPane().add(getBotaoTelaEntrar());
		
		janela.setVisible(true);

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Main().montaJanela();
	}

}
