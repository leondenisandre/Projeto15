package br.gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame{
	private JPanel contentPane;
	private CadastroCliente cadastroCliente;
	public Principal(){
		super("Biblioteca-UFPA");
		cria();
	}
	
	CadastroCliente novo = new CadastroCliente();
	private void cria(){
		//Clientes
		ActionNovo actionNovo = new ActionNovo();
		ActionListar actionListar = new ActionListar();
		ActionBuscarCliente actionBuscarCliente = new ActionBuscarCliente();
		ActionDcl actionDcl = new ActionDcl();
		ActionSair actionSair = new ActionSair();
		//Emprestimos
		ActionEmp actionEmp = new ActionEmp();
		ActionListEmp actionListEmp = new ActionListEmp();
		ActionDevolucao actionDevolucao = new ActionDevolucao();
		//Exemplares
		ActionLivro actionLivro = new ActionLivro();
		ActionArtigo actionArtigo = new ActionArtigo();
		ActionPer actionPer = new ActionPer();
		ActionListarExemplar actionListarExemplar = new ActionListarExemplar();
		//Ajuda
		ActionSobre actionSobre = new ActionSobre();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 2, 430, 21);
		contentPane.add(menuBar);
		
		//menu cliente
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmNovoCliente = new JMenuItem("Novo Cliente");
		mntmNovoCliente.addActionListener(actionNovo);
		mnClientes.add(mntmNovoCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.addActionListener(actionListar);
		mnClientes.add(mntmListarClientes);
		
		JMenuItem mntmProcurarCliente = new JMenuItem("Procurar Cliente");
		mntmProcurarCliente.addActionListener(actionBuscarCliente);
		mnClientes.add(mntmProcurarCliente);
		
		JMenuItem mntmDeletarCliente = new JMenuItem("Deletar Cliente");
		mntmDeletarCliente.addActionListener(actionDcl);
		mnClientes.add(mntmDeletarCliente);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(actionSair);
		mnClientes.add(mntmSair);
		
		//menu emprestimos
		JMenu mnEmprestimos = new JMenu("Emprestimos");
		menuBar.add(mnEmprestimos);
		
		JMenuItem mntmNovoEmprestimo = new JMenuItem("Novo Emprestimo");
		mntmNovoEmprestimo.addActionListener(actionEmp);
		mnEmprestimos.add(mntmNovoEmprestimo);
		
		JMenuItem mntmListarEmprestimos = new JMenuItem("Listar Emprestimos");
		mntmListarEmprestimos.addActionListener(actionListEmp);
		mnEmprestimos.add(mntmListarEmprestimos);
		
		JMenuItem mntmRegistrarDevoluo = new JMenuItem("Registrar Devolução");
		mntmRegistrarDevoluo.addActionListener(actionDevolucao);
		mnEmprestimos.add(mntmRegistrarDevoluo);
		
		//menu exemplares
		JMenu mnExemplares = new JMenu("Exemplares");
		menuBar.add(mnExemplares);
		
		JMenu mnNovoExemplar = new JMenu("Novo Exemplar");
		mnExemplares.add(mnNovoExemplar);
		
		JMenuItem mntmLivro = new JMenuItem("Livro");
		mntmLivro.addActionListener(actionLivro);
		mnNovoExemplar.add(mntmLivro);
		
		JMenuItem mntmArtigo = new JMenuItem("Artigo");
		mntmArtigo.addActionListener(actionArtigo);
		mnNovoExemplar.add(mntmArtigo);
		
		JMenuItem mntmPeriodico = new JMenuItem("Periodico");
		mntmPeriodico.addActionListener(actionPer);
		mnNovoExemplar.add(mntmPeriodico);
		
		JMenuItem mntmListarExemplares = new JMenuItem("Listar Exemplares");
		mntmListarExemplares.addActionListener(actionListarExemplar);
		mnExemplares.add(mntmListarExemplares);
		
		//menu ajuda
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(actionSobre);
		mnAjuda.add(mntmSobre);
		
		JLabel lblBibliotecaUfpa = new JLabel("Biblioteca UFPA");
		lblBibliotecaUfpa.setForeground(Color.DARK_GRAY);
		lblBibliotecaUfpa.setFont(new Font("Baskerville Old Face", Font.BOLD, 22));
		lblBibliotecaUfpa.setBounds(118, 73, 189, 62);
		contentPane.add(lblBibliotecaUfpa);
	}
	private class ActionNovo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			novo.aux();
		}
	}
	
	private class ActionListar implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.listagem();
		}
	}
	
	private class ActionBuscarCliente implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.BuscarCliente();
		}
	}
	
	private class ActionDcl implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.deletC();;
		}
	}
	
	private class ActionSair implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			System.exit(0);
		}
	}
	
	//submenu de exemplares
	private class ActionLivro implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.cadLivro();
		}
	}
	
	private class ActionArtigo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.cadArtigo();
		}
	}
	
	private class ActionPer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.cadPer();
		}
	}
	
	private class ActionListarExemplar implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.listaExemplares();
		}
	}
	
	//eventos emprestimos
	private class ActionEmp implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			novo.tcadEmp();
		}
	}
	
	private class ActionDevolucao implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.cadDevolucao();
		}
	}
	
	private class ActionListEmp implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			novo.listaEmprestimos();
		}
	}
	
	// eventos sobre
	private class ActionSobre implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Sobre x = new Sobre();
			x.setVisible(true);
		}
		
	}
	
}
