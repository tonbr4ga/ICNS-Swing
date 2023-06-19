package br.com.icnp.cli.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaLogado extends JFrame {

	private JFrame janelaAreaLogado;

	private JLabel labelTitleICNS;

	public JLabel getLabelTitleICNS() {
		labelTitleICNS = new JLabel("ICNS - Manager");
		labelTitleICNS.setForeground(Color.black);
		labelTitleICNS.setFont(new Font("", Font.BOLD, 14));
		labelTitleICNS.setBounds(new Rectangle(10, 10, 130, 25));
		return labelTitleICNS;
	}

	public void janelaProdutos() {

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

	public static void main(String[] args) {

		new JanelaLogado().janelaProdutos();

	}

}
