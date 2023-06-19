package br.com.icnp.cli.view;

import br.com.icnp.cli.DAO.FuncionarioDAO;
import br.com.icnp.cli.service.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class Cadastro {
    private JFrame janela;
    private JLabel labelCPFCadastro;
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelSenhaCadastro;
    private JLabel labelRepetirSenha;
    private JButton botaoTelaCadastrar;
    private JPasswordField txtRepetirSenha;
    private JPasswordField txtSenha;
    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JLabel labelTitleICNS;
    private JButton botaoVoltar;

    FuncionarioDAO funcionarioDAO;

    public Cadastro(FuncionarioDAO funcionarioDAO){
        this.funcionarioDAO = funcionarioDAO;
        this.montaJanela();
    }
    public JButton getBotaoVoltar() {
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(new Rectangle(100, 325, 75, 25));

        botaoVoltar.setBackground(new Color(170, 12, 12));
        botaoVoltar.setToolTipText("Pressione aqui para realizar o Cadastro");

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(funcionarioDAO);
                janela.dispose();
            }


        };
        botaoVoltar.addActionListener(listener);
        return botaoVoltar;
    }
    public JButton getBotaoTelaCadastrar() {
        botaoTelaCadastrar = new JButton("Cadastrar");
        botaoTelaCadastrar.setBounds(new Rectangle(185, 325, 95, 25));
        botaoTelaCadastrar.setBackground(new Color(170, 12, 12));
        botaoTelaCadastrar.setToolTipText("Pressione aqui para realizar o Cadastro");

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoCPFcadastro = txtCpf.getText();
                String textoNome = txtNome.getText();
                String textoEmail = txtEmail.getText();
                String textoSenha = txtSenha.getText();
                String textoRepetirSenha = txtRepetirSenha.getText();
                Funcionario novoFuncionario = new Funcionario(textoCPFcadastro, textoNome, textoSenha, new Date(0),textoEmail);

                boolean isBlank = textoSenha.isBlank() || textoEmail.isBlank() || textoCPFcadastro.isBlank() || textoNome.isBlank();

                if (!(isBlank) && textoSenha.equals(textoRepetirSenha) && !(funcionarioDAO.funcionarioExiste(novoFuncionario.getCpf()))) {
                    funcionarioDAO.setFuncionarioDAO(novoFuncionario);
                    JOptionPane.showMessageDialog(janela, "Usuario Cadastrado!");
                    System.out.println("\nUsuario cadastrado: ! "+novoFuncionario.getNome());
                    Login login = new Login(funcionarioDAO);
                    janela.dispose();
                } else {
                    System.out.println("\nErro no Cadastro!");
                    JOptionPane.showMessageDialog(janela, "Usuario já cadastro ou possui campos invalidos!");
                }
            }

        };
        botaoTelaCadastrar.addActionListener(listener);
        return botaoTelaCadastrar;
    }
    public JLabel getLabelRepetirSenha() {
        labelRepetirSenha = new JLabel("Repitir Senha");
        labelRepetirSenha.setForeground(Color.black);
        labelRepetirSenha.setFont(new Font("", Font.BOLD, 10));
        labelRepetirSenha.setBounds(new Rectangle(100, 250, 100, 25));
        return labelRepetirSenha;
    }
    public JLabel getLabelSenhaCadastro() {
        labelSenhaCadastro = new JLabel("Senha");
        labelSenhaCadastro.setForeground(Color.black);
        labelSenhaCadastro.setFont(new Font("", Font.BOLD, 10));
        labelSenhaCadastro.setBounds(new Rectangle(100, 200, 60, 25));
        return labelSenhaCadastro;
    }
    public JLabel getLabelEmail() {
        labelEmail = new JLabel("Email");
        labelEmail.setForeground(Color.black);
        labelEmail.setFont(new Font("", Font.BOLD, 10));
        labelEmail.setBounds(new Rectangle(100, 145, 60, 25));
        return labelEmail;
    }
    public JLabel getLabelNome() {
        labelNome = new JLabel("Nome");
        labelNome.setForeground(Color.black);
        labelNome.setFont(new Font("", Font.BOLD, 10));
        labelNome.setBounds(new Rectangle(100, 95, 60, 25));
        return labelNome;
    }
    public JLabel getLabelCPFCadastro() {
        labelCPFCadastro = new JLabel("CPF");
        labelCPFCadastro.setForeground(Color.black);
        labelCPFCadastro.setFont(new Font("", Font.BOLD, 10));
        labelCPFCadastro.setBounds(new Rectangle(100, 45, 60, 25));
        return labelCPFCadastro;
    }
    // TextField
    public JTextField getTxtCpf() {
        txtCpf = new JTextField(20);
        txtCpf.setBounds(new Rectangle(100, 75, 180, 25));
        return txtCpf;
    }
    public JTextField getTxtNome() {
        txtNome = new JTextField(20);
        txtNome.setBounds(new Rectangle(100, 125, 180, 25));
        return txtNome;
    }
    public JTextField getTxtEmail() {
        txtEmail = new JTextField(20);
        txtEmail.setBounds(new Rectangle(100, 175, 180, 25));
        return txtEmail;
    }
    public JPasswordField getTxtSenha() {
        txtSenha = new JPasswordField(20);
        txtSenha.setBounds(new Rectangle(100, 225, 180, 25));
        return txtSenha;
    }
    public JTextField getTxtRepetirSenha() {
        txtRepetirSenha = new JPasswordField(20);
        txtRepetirSenha.setBounds(new Rectangle(100, 275, 180, 25));
        return txtRepetirSenha;
    }
    public JLabel getLabelTitleICNS() {
        labelTitleICNS = new JLabel("ICNS - Manager");
        labelTitleICNS.setForeground(Color.black);
        labelTitleICNS.setFont(new Font("", Font.BOLD, 14));
        labelTitleICNS.setBounds(new Rectangle(12, 10, 130, 25));
        return labelTitleICNS;
    }
    public void montaJanela() {
        janela = new JFrame();
        janela.setTitle("Projeto ICNS - Gerenciamento ");
        janela.setSize(400, 450);
        janela.setLocation(800,100 );
        janela.setLayout(null);
        janela.setResizable(true);
        janela.getContentPane().setBackground(new Color(255, 165, 0));
        janela.getContentPane().add(getLabelTitleICNS());
        janela.getContentPane().add(getBotaoVoltar());
        janela.getContentPane().add(getLabelCPFCadastro());
        janela.getContentPane().add(getLabelNome());
        janela.getContentPane().add(getLabelEmail());
        janela.getContentPane().add(getLabelSenhaCadastro());
        janela.getContentPane().add(getLabelRepetirSenha());
        janela.getContentPane().add(getBotaoTelaCadastrar());
        janela.getContentPane().add(getTxtCpf());
        janela.getContentPane().add(getTxtNome());
        janela.getContentPane().add(getTxtEmail());
        janela.getContentPane().add(getTxtSenha());
        janela.getContentPane().add(getTxtRepetirSenha());
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
