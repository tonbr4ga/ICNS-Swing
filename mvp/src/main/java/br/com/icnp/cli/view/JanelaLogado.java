package br.com.icnp.cli.view;

import br.com.icnp.cli.DAO.FuncionarioDAO;

import javax.swing.*;
import java.awt.*;

public class JanelaLogado extends JFrame {

	private JFrame janelaAreaLogado;

	FuncionarioDAO funcionarioDAO;
	private JLabel labelTitleICNS;

	public JLabel getLabelTitleICNS() {
		labelTitleICNS = new JLabel("ICNS - Logado - Manager");
		labelTitleICNS.setForeground(Color.black);
		labelTitleICNS.setFont(new Font("", Font.BOLD, 14));
		labelTitleICNS.setBounds(new Rectangle(10, 10, 130, 25));
		return labelTitleICNS;
	}

	public void montaJanela() {
		janelaAreaLogado = new JFrame();
		janelaAreaLogado.setTitle("Projeto ICNS - Gerenciamento ");
		janelaAreaLogado.setSize(800, 600);
		janelaAreaLogado.setLocation(300, 150);
		janelaAreaLogado.setLayout(null);
		janelaAreaLogado.setResizable(true);
		janelaAreaLogado.getContentPane().setBackground(new Color(255, 165, 0));
		janelaAreaLogado.getContentPane().add(getLabelTitleICNS());
		janelaAreaLogado.setVisible(true);
		janelaAreaLogado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JanelaLogado(FuncionarioDAO funcionarioDAO)
	{
		this.funcionarioDAO=funcionarioDAO;
		this.montaJanela();

	}

}
