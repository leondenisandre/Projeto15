package br.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class Sobre extends JFrame {
	private JPanel contentPane;
	public Sobre(){
		super("Sobre");
		inicia();
	}
	private void inicia(){
		ActionFechar actionFechar = new ActionFechar();
		
		
		setBounds(100, 100, 478, 301);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.inactiveCaption);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(41, 99, 368, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCopyrigth = new JLabel("Copyright 2015");
		lblCopyrigth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblCopyrigth.setBounds(143, 29, 137, 42);
		contentPane.add(lblCopyrigth);
		
		JTextPane txtpnEssePrograma = new JTextPane();
		txtpnEssePrograma.setEditable(false);
		txtpnEssePrograma.setBounds(10, 11, 348, 83);
		panel.add(txtpnEssePrograma);
		txtpnEssePrograma.setForeground(SystemColor.controlLtHighlight);
		txtpnEssePrograma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEssePrograma.setBackground(SystemColor.activeCaption);
		txtpnEssePrograma.setText("Este programa foi desenvolvido por estudantes de Engenharia da Computa\u00E7\u00E3o da Universidade  Federal do Par\u00E1.");
		
		JButton btnOk = new JButton("Fechar");
		btnOk.addActionListener(actionFechar);
		btnOk.setBounds(176, 227, 89, 23);
		contentPane.add(btnOk);
		
		
	}
	private class ActionFechar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
		
	}

}
