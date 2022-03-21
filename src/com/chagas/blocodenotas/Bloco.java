package com.chagas.blocodenotas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public final class Bloco extends JFrame {
	private JFrame janela = new JFrame();
	/*
	 * Componentes devem estar no contexto da instância, para que possam ser
	 * acessados em todos os métodos não-estáticos da classe
	 */
	private JTextArea texto = new JTextArea();
	private JTextField salvar = new JTextField();
	//private JTextPane text = new JTextPane();
	private JButton botao = new JButton("salvar");
	private JButton botao2 = new JButton("salvar o nome");
    private String arquivo ;
	public Bloco() {
		// Define o título da janela
		super("Bloco de Notas");
		//add(text);
		add(botao);
		
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		texto.setBackground(Color.white);
		texto.setForeground(Color.black);
		botao.setBackground(Color.cyan);
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String entrada = texto.getText();
				
				try {
					BufferedWriter escritor = new BufferedWriter(new FileWriter("arquivo"+".txt",true));
					
					escritor.write(entrada);
					escritor.newLine();
					escritor.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(entrada);
			}
		});
		botao.setBounds(100,200, 100, 60);
		this.montaJanela();
	}

	private void montaJanela() {
		this.getContentPane().add(texto);
	}
	
	public static void main(String[] args) {
		// Cria objeto:
		Bloco janela = new Bloco();
		
	}
}
