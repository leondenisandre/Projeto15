package br.gui;

import java.awt.Color;



import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.text.SimpleDateFormat;

import br.com.Artigos;
import br.com.Cliente;
import br.com.Emprestimos;
import br.com.Exemplares;
import br.com.Livros;
import br.com.Periodicos;
import br.dados.Dclientes;
import br.dados.Demprestimos;
import br.dados.Dexemplares;

public class CadastroCliente {
	//clientes
	private JFrame frameCad = new JFrame();
	private JFrame frameBuscaCliente = new JFrame();
	private JFrame frameDeletaCliente = new JFrame();
	
	private JPanel contentPane;
	private JPanel cPane;
	private JPanel cP;
	
	private JTextField textFieldRg;
	private JTextField textFieldR;
	private JTextField tFRg;
	
	private JTextField textFieldNome;
	private JFormattedTextField textFieldFone;
	private JTextField textFieldEnd;
	private MaskFormatter mascaratel;
	private String dados= "";
	//
	//Emprestimos
	private JFrame cadEmp = new JFrame();
	private JFrame frameDev = new JFrame();
	private JPanel cPaneA, paneDev;
	private JTextField textFieldCodigoE,textFieldCodigoC, textFieldCodigoEdev,textFieldCodigoCdev;
	private String Emp = "";
	//
	//exemplares
	private JFrame frameLivro = new JFrame();
	private JFrame frameArtigo = new JFrame();
	private JFrame framePer = new JFrame();
	private JPanel PaneA,PaneB,PaneC;
	private JTextField textFieldCodigoLivro, textFieldEditoraLivro, textFieldNomeLivro, textFieldAutorLivro , textFieldEdicaoLivro;
	private JTextField textFieldCodigoArtigo, textFieldNomeArtigo, textFieldAutorArtigo;
	private JTextField textFieldCodigoPer, textFieldNomePer, textFieldEditoraPer;
	private String Exemp = "";
	//
	
	private Long novorg = (long) 0 ;
	private Long codigo = (long) 0;

	private Dclientes novoCliente = new Dclientes();
	private Demprestimos novoEmprestimo = new Demprestimos();
	private Dexemplares novoMaterial = new Dexemplares();
	
	// criar, listar, procurar e deletar clientes
	
	public void aux(){
		ActionLimparClientes actionLimparClientes = new ActionLimparClientes();
		ActionSalvar actionSalvar = new ActionSalvar();
		ActionCanc actionCanc = new ActionCanc();
		
		frameCad.setTitle("Cadastro de Clientes");
		frameCad.setBounds(100, 100, 463, 317);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameCad.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(36, 55, 72, 23);
		contentPane.add(lblNome);
		
		JLabel lblRegistroGeralrg = new JLabel("Registro Geral(RG)");
		lblRegistroGeralrg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroGeralrg.setBounds(36, 89, 138, 23);
		contentPane.add(lblRegistroGeralrg);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(36, 123, 126, 23);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereo.setBounds(36, 157, 126, 23);
		contentPane.add(lblEndereo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(184, 58, 230, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldRg = new JTextField();
		textFieldRg.setBounds(184, 92, 138, 20);
		contentPane.add(textFieldRg);
		textFieldRg.setColumns(10);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setBounds(184, 160, 230, 20);
		contentPane.add(textFieldEnd);
		textFieldEnd.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.addActionListener(actionSalvar);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(100, 207, 86, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.addActionListener(actionLimparClientes);
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setBounds(200, 207, 86, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCanc = new JButton("Sair");
		btnCanc.setFont(new Font("Tahoma",Font.BOLD,11));
		btnCanc.addActionListener(actionCanc);
		btnCanc.setBackground(Color.red);
		btnCanc.setBounds(300, 207, 86, 23);
		contentPane.add(btnCanc);
		
		try{
			mascaratel = new MaskFormatter("(##)#####-####");
			mascaratel.setPlaceholderCharacter('_');
		}
		catch(ParseException excp){}
		textFieldFone = new JFormattedTextField(mascaratel);
		textFieldFone.setBounds(184, 126, 138, 20);
		contentPane.add(textFieldFone);
		textFieldFone.setColumns(10); 
		frameCad.setVisible(true);
	}

	private class ActionLimparClientes implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			limpaFormClientes();
		}
	}
	
	public void BuscarCliente() {
			ActionBuscarCliente actionBc = new ActionBuscarCliente();
			ActionCanc1 actionCanc1 = new ActionCanc1();
			
			cPane = new JPanel();
			cPane.setBackground(SystemColor.activeCaption);
			cPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frameBuscaCliente.setContentPane(cPane);
			cPane.setLayout(null);
			
			JLabel lblDigiteRg = new JLabel("Codigo do Cliente(RG)");
			lblDigiteRg.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDigiteRg.setBounds(20, 58, 171, 32);
			cPane.add(lblDigiteRg);
			
			textFieldR = new JTextField();
			textFieldR.setBounds(180, 66, 150, 20);
			cPane.add(textFieldR);
			textFieldR.setColumns(10);
			
			JButton btnDeletarCliente = new JButton("Procurar");
			btnDeletarCliente.addActionListener(actionBc);
			btnDeletarCliente.setForeground(Color.WHITE);
			btnDeletarCliente.setBackground(Color.GREEN);
			btnDeletarCliente.setBounds(30, 125, 130, 23);
			cPane.add(btnDeletarCliente);
			
			JButton btnCanc = new JButton("Sair");
			btnCanc.addActionListener(actionCanc1);
			btnCanc.setForeground(Color.WHITE);
			btnCanc.setBackground(Color.RED);
			btnCanc.setBounds(200, 125, 130, 23);
			cPane.add(btnCanc);
			frameBuscaCliente.setBounds(100, 100, 365, 267);
			frameBuscaCliente.setTitle("Buscar Cliente");
			frameBuscaCliente.setVisible(true);		
	}
	
	public void deletC(){
		ActionDc actionDc = new ActionDc();
		ActionCanc2 actionCanc2 = new ActionCanc2();
	
		cP = new JPanel();
		cP.setBackground(SystemColor.activeCaption);
		cP.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameDeletaCliente.setContentPane(cP);
		cP.setLayout(null);
		
		JLabel lblDigRg = new JLabel("Codigo do Cliente(Rg)");
		lblDigRg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDigRg.setBounds(20, 58, 171, 32);
		cP.add(lblDigRg);
		
		tFRg = new JTextField();
		tFRg.setBounds(180, 66, 150, 20);
		cP.add(tFRg);
		tFRg.setColumns(10);
		
		JButton btnDeletarCliente = new JButton("Excluir Cliente");
		btnDeletarCliente.addActionListener(actionDc);
		btnDeletarCliente.setForeground(Color.WHITE);
		btnDeletarCliente.setBackground(Color.GREEN);
		btnDeletarCliente.setBounds(30, 125, 130, 23);
		cP.add(btnDeletarCliente);
		
		JButton btnCanc = new JButton("Sair");
		btnCanc.addActionListener(actionCanc2);
		btnCanc.setForeground(Color.WHITE);
		btnCanc.setBackground(Color.RED);
		btnCanc.setBounds(200, 125, 130, 23);
		cP.add(btnCanc);
		frameDeletaCliente.setTitle("Excluir Cliente");
		frameDeletaCliente.setBounds(100, 100, 365, 267);
		frameDeletaCliente.setVisible(true);	
	}
	
	private void criarCliente(){
		Cliente cl = new Cliente();//novo
		Cliente p5 = new Cliente();//armazernar
		try{	
		  	novorg = Long.parseLong(textFieldRg.getText());	
			String nome = textFieldNome.getText();
	        String telefone = textFieldFone.getText();
	        String endereco = textFieldEnd.getText();
	         
	  		cl = novoCliente.localizaCliente(novorg);
	          if (cl != null) { 
	              JOptionPane.showMessageDialog(null, " Rg já cadastrado!");
	          }
	          else{  
	              //entao cadastra         
	              p5.setRg(novorg);
	              p5.setNome(nome);
	              p5.setTelefone(telefone);
	              p5.setEndereco(endereco);
	              novoCliente.createCliente(p5);     
	              JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
	          }
		}
	    catch(Exception e){
	    	 JOptionPane.showMessageDialog(null, "error");
	     }
	}
	
	private void excluirCliente(){
			try{
				Cliente cl = new Cliente();
				Long novorg = Long.parseLong(tFRg.getText());
				cl = novoCliente.localizaCliente(novorg);
		        if (cl != null){ 
		            novoCliente.removeCliente(novorg);
		            JOptionPane.showMessageDialog(null," Cliente removido com sucesso!"); 
		        }
		        else{   
		            JOptionPane.showMessageDialog(null,"Cliente com Rg não cadastrado");
		        }
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro");
			}
	}
	
	private void buscarCliente(){
		try{
			Cliente cl = new Cliente();
			novorg = Long.parseLong(textFieldR.getText());
			cl = novoCliente.localizaCliente(novorg);
			 if (cl != null){ 
		            String valor = cl.getNome(); String valor1 = cl.getTelefone(); String valor2 = cl.getEndereco();		
		            JOptionPane.showMessageDialog(null,"Nome: "+valor+" Telefone: "+valor1+" Endereço: "+valor2);
		        }
		        else{   
		            JOptionPane.showMessageDialog(null,"Cliente com Rg não cadastrado");
		        }
		}
		catch(Exception e){JOptionPane.showMessageDialog(null, "inválido!!!");}
	}
	
	private class ActionDc implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			excluirCliente();
		}
	}
	
	private class ActionBuscarCliente implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			buscarCliente();
		}
	}

	private class ActionSalvar implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {	
			criarCliente();
			limpaFormClientes();
		}  	
	}
	
	public void listagem(){
		for(Cliente a : novoCliente.CadastradosList()){
            dados += " Nome: "+a.getNome()
            		+" Telefone: "+a.getTelefone()+"\n\n";
        }   
		if (!novoCliente.CadastradosList().isEmpty()) {
    	   JOptionPane.showMessageDialog(null, dados);	
        } 
        else{
        	 JOptionPane.showMessageDialog(null,"Não há clientes cadastrados");        
        }
        dados="";
	}
	//events pra cancelar
	private class ActionCanc implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameCad.setVisible(false);
		}
	}
	private class ActionCanc1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameBuscaCliente.setVisible(false);
		}
		
	}
	private class ActionCanc2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameDeletaCliente.setVisible(false);
		}
		
	}
	
	//cadastro, listagem e devolução de emprestimos
	
	public void tcadEmp(){
		ActionCadEmp actionCadEmp = new ActionCadEmp();
		ActionSairEmp actionSairEmp = new ActionSairEmp();
	
		cPaneA = new JPanel();
		cPaneA.setBackground(SystemColor.activeCaption);
		cPaneA.setBorder(new LineBorder(new Color(0, 0, 0)));
		cadEmp.setContentPane(cPaneA);
		cPaneA.setLayout(null);
		
		JLabel lblCodigoClienterg = new JLabel("Código do cliente (Rg):");
		lblCodigoClienterg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoClienterg.setBounds(40, 32, 171, 39);
		cPaneA.add(lblCodigoClienterg);
		
		JLabel lblCdigoDoExemplar = new JLabel("Código do Exemplar");
		lblCdigoDoExemplar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoDoExemplar.setBounds(40, 86, 171, 48);
		cPaneA.add(lblCdigoDoExemplar);
		
		textFieldCodigoC = new JTextField();
		textFieldCodigoC.setBounds(220, 40, 165, 26);
		cPaneA.add(textFieldCodigoC);
		textFieldCodigoC.setColumns(10);
		
		textFieldCodigoE = new JTextField();
		textFieldCodigoE.setBounds(220, 99, 165, 26);
		cPaneA.add(textFieldCodigoE);
		textFieldCodigoE.setColumns(10);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(actionCadEmp);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(176, 167, 101, 23);
		cPaneA.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(actionSairEmp);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(306, 167, 101, 23);
		cPaneA.add(btnSair);
		
		cadEmp.setTitle("Cadastro de Emprestimos");
		cadEmp.setBounds(100, 100, 478, 301);
		cadEmp.setVisible(true);
		
		
	}
	public void cadDevolucao(){
		ActionCadDev actionCadDev = new ActionCadDev();
		ActionSairDev actionSairDev = new ActionSairDev();
	
		paneDev = new JPanel();
		paneDev.setBackground(SystemColor.activeCaption);
		paneDev.setBorder(new LineBorder(new Color(0, 0, 0)));
		frameDev.setContentPane(paneDev);
		paneDev.setLayout(null);
		
		JLabel lblCodigoClienterg = new JLabel("Código do cliente (Rg):");
		lblCodigoClienterg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoClienterg.setBounds(40, 32, 171, 39);
		paneDev.add(lblCodigoClienterg);
		
		JLabel lblCdigoDoExemplar = new JLabel("Código do Exemplar");
		lblCdigoDoExemplar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoDoExemplar.setBounds(40, 86, 171, 48);
		paneDev.add(lblCdigoDoExemplar);
		
		textFieldCodigoCdev = new JTextField();
		textFieldCodigoCdev.setBounds(220, 40, 165, 26);
		paneDev.add(textFieldCodigoCdev);
		textFieldCodigoCdev.setColumns(10);
		
		textFieldCodigoEdev = new JTextField();
		textFieldCodigoEdev.setBounds(220, 99, 165, 26);
		paneDev.add(textFieldCodigoEdev);
		textFieldCodigoEdev.setColumns(10);
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(actionCadDev);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(176, 167, 101, 23);
		paneDev.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(actionSairDev);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(306, 167, 101, 23);
		paneDev.add(btnSair);
		
		frameDev.setTitle("Cadastro de Devoluções");
		frameDev.setBounds(100, 100, 478, 301);
		frameDev.setVisible(true);
		
	}
	
	//funcoes
	private void criaEmp(){
		try{
			Long ng = Long.parseLong(textFieldCodigoC.getText());
		    Cliente retornoPessoa = novoCliente.localizaCliente(ng);
            
            if (retornoPessoa != null) { 
                Exemplares retornoMaterial = novoMaterial.procuraCodigo(Long.parseLong(textFieldCodigoE.getText()));
                
                if (retornoMaterial == null) {
                    JOptionPane.showMessageDialog(null, " material Não Cadastrado!");
                } 
                else {
                    Emprestimos e = new Emprestimos(); 
                    e = novoEmprestimo.criarEmp(retornoPessoa, retornoMaterial, new java.util.Date());
                    JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso");
                }
            }
            else{
            	JOptionPane.showMessageDialog(null, "Cliente não Cadastrado!!!");
            }
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null, " error");}
	}
	private void criaDevolu(){
		try{
	        codigo = Long.parseLong(textFieldCodigoEdev.getText()); 
	        novorg = Long.parseLong(textFieldCodigoCdev.getText());

	        Emprestimos aux = novoEmprestimo.proc(novorg, codigo);
	        if (aux != null) 
	        {
	            if (aux.getDataDevolucao() == null && aux.getExemplares().getCodigo() == codigo)
	            {
	                novoEmprestimo.removerEmprestimo(codigo, novorg);
	            }
	        }
	        
	        else 
	        {
	            JOptionPane.showMessageDialog(null, "Exemplar não encontrado na lista dos emprestimos");
	        }
		}
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "inválido");
        }
	}
	
	public void listaEmprestimos(){
            SimpleDateFormat dataform = new SimpleDateFormat("dd/MM/yyyy");
            for(Emprestimos aux : novoEmprestimo.procuraEmprestimos()){
               if (aux.getDataDevolucao() == null) {
                   Emp += " Nome: " + aux.getCliente().getNome()+",  Telefone:"+aux.getCliente().getTelefone()
                   + ",  Exemplar: " +aux.getExemplares().getN_exemplar()
                   + ",  Codigo Exemplar:"+aux.getExemplares().getCodigo()
                   + "  Data do Emprestimo: " +
                   dataform.format(aux.getDataEmprestimo())+ "\n\n";
               }
            } 
            if (Emp.equals("")) {
              JOptionPane.showMessageDialog(null, "Não há Exemplares emprestados!");
             
            } 
            else{
              JOptionPane.showMessageDialog(null, Emp);
            }
           Emp = "";  
	}
	private class ActionCadEmp implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			criaEmp();
		}
	}
	private class ActionCadDev implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			criaDevolu();
		}
	}
	private class ActionSairEmp implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			cadEmp.setVisible(false);
		}
	}
	private class ActionSairDev implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameDev.setVisible(false);
		}
	}
	
	///cadastro, listagem de Exemplares
	
	public void cadLivro(){
		ActionSalvarLivro actionSalvarLivro = new ActionSalvarLivro();
		ActionLimpL actionLimpL = new ActionLimpL();
		ActionSairLivro actionSairLivro = new ActionSairLivro();
		
		frameLivro.setBounds(100, 100, 478, 362);
		PaneA = new JPanel();
		PaneA.setBackground(SystemColor.activeCaption);
		PaneA.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameLivro.setContentPane(PaneA);
		PaneA.setLayout(null);
		
		JLabel lblCodigoDoLivro = new JLabel("Codigo");
		lblCodigoDoLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoDoLivro.setBounds(37, 29, 106, 25);
		PaneA.add(lblCodigoDoLivro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(37, 73, 71, 25);
		PaneA.add(lblNome);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutor.setBounds(37, 122, 60, 25);
		PaneA.add(lblAutor);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditora.setBounds(37, 167, 57, 28);
		PaneA.add(lblEditora);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o");
		lblEdio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdio.setBounds(37, 218, 57, 25);
		PaneA.add(lblEdio);
		
		textFieldCodigoLivro = new JTextField();
		textFieldCodigoLivro.setBounds(140, 31, 257, 25);
		PaneA.add(textFieldCodigoLivro);
		textFieldCodigoLivro.setColumns(10);
		
		textFieldNomeLivro = new JTextField();
		textFieldNomeLivro.setColumns(10);
		textFieldNomeLivro.setBounds(140, 75, 257, 25);
		PaneA.add(textFieldNomeLivro);
		
		textFieldEditoraLivro = new JTextField();
		textFieldEditoraLivro.setColumns(10);
		textFieldEditoraLivro.setBounds(140, 171, 257, 25);
		PaneA.add(textFieldEditoraLivro);
		
		textFieldAutorLivro = new JTextField();
		textFieldAutorLivro.setColumns(10);
		textFieldAutorLivro.setBounds(140, 124, 257, 25);
		PaneA.add(textFieldAutorLivro);
		
		textFieldEdicaoLivro = new JTextField();
		textFieldEdicaoLivro.setColumns(10);
		textFieldEdicaoLivro.setBounds(140, 220, 86, 25);
		PaneA.add(textFieldEdicaoLivro);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(actionSalvarLivro);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(70, 275, 89, 23);
		PaneA.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(actionLimpL);
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setBounds(185, 275, 89, 23);
		PaneA.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(actionSairLivro);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(300, 275, 89, 23);
		PaneA.add(btnSair);
		frameLivro.setTitle("Cadastro de Livros");
		frameLivro.setVisible(true);
	}
	
	public void cadArtigo(){
		ActionSalvarArtigo actionSalvarArtigo = new ActionSalvarArtigo();
		ActionLimpA actionLimpA = new ActionLimpA();
		ActionSairArtigo actionSairArtigo = new ActionSairArtigo();
		
		PaneB = new JPanel();
		PaneB.setBackground(SystemColor.activeCaption);
		PaneB.setBorder(new EmptyBorder(5, 5, 5, 5));
		frameArtigo.setContentPane(PaneB);
		PaneB.setLayout(null);
		
		JLabel lblCodigoDoLivro = new JLabel("Codigo");
		lblCodigoDoLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoDoLivro.setBounds(37, 29, 106, 25);
		PaneB.add(lblCodigoDoLivro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(37, 73, 71, 25);
		PaneB.add(lblNome);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutor.setBounds(37, 122, 60, 25);
		PaneB.add(lblAutor);
		
		textFieldCodigoArtigo = new JTextField();
		textFieldCodigoArtigo.setBounds(140, 31, 257, 25);
		PaneB.add(textFieldCodigoArtigo);
		textFieldCodigoArtigo.setColumns(10);
		
		textFieldNomeArtigo = new JTextField();
		textFieldNomeArtigo.setColumns(10);
		textFieldNomeArtigo.setBounds(140, 75, 257, 25);
		PaneB.add(textFieldNomeArtigo);
		
		textFieldAutorArtigo = new JTextField();
		textFieldAutorArtigo.setColumns(10);
		textFieldAutorArtigo.setBounds(140, 124, 257, 25);
		PaneB.add(textFieldAutorArtigo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(actionSalvarArtigo);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(80, 200, 89, 23);
		PaneB.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(actionLimpA);
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setBounds(192, 200, 89, 23);
		PaneB.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(actionSairArtigo);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(304, 200, 89, 23);
		PaneB.add(btnSair);
		
		frameArtigo.setTitle("Cadastro de Artigos");
		frameArtigo.setBounds(100, 100, 478, 362);
		frameArtigo.setVisible(true);
	}
	public void cadPer(){
		ActionSalvarPer actionSalvarPer = new ActionSalvarPer();
		ActionLimpP actionLimpP = new ActionLimpP();
		ActionSairPer actionSairPer = new ActionSairPer();
		
		PaneC = new JPanel();
		PaneC.setBackground(SystemColor.activeCaption);
		PaneC.setBorder(new EmptyBorder(5, 5, 5, 5));
		framePer.setContentPane(PaneC);
		PaneC.setLayout(null);
		
		JLabel lblCodigoDoLivro = new JLabel("Codigo");
		lblCodigoDoLivro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoDoLivro.setBounds(37, 29, 106, 25);
		PaneC.add(lblCodigoDoLivro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(37, 73, 71, 25);
		PaneC.add(lblNome);
		
		JLabel label = new JLabel("Editora");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(37, 122, 71, 25);
		PaneC.add(label);
		
		textFieldCodigoPer = new JTextField();
		textFieldCodigoPer.setBounds(140, 31, 257, 25);
		PaneC.add(textFieldCodigoPer);
		textFieldCodigoPer.setColumns(10);
		
		textFieldNomePer = new JTextField();
		textFieldNomePer.setColumns(10);
		textFieldNomePer.setBounds(140, 75, 257, 25);
		PaneC.add(textFieldNomePer);
		
		textFieldEditoraPer = new JTextField();
		textFieldEditoraPer.setColumns(10);
		textFieldEditoraPer.setBounds(140, 124, 257, 25);
		PaneC.add(textFieldEditoraPer);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(actionSalvarPer);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBounds(80, 200, 89, 23);
		PaneC.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(actionLimpP);
		btnLimpar.setBackground(Color.ORANGE);
		btnLimpar.setBounds(192, 200, 89, 23);
		PaneC.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(actionSairPer);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(304, 200, 89, 23);
		PaneC.add(btnSair);
		
		framePer.setTitle("Cadastro de Periódicos");
		framePer.setBounds(100, 100, 478, 362);
		framePer.setVisible(true);
	}
	// metodos para cadastrar exemplares
	private void cadElivro(){
		 try{
			 codigo = Long.parseLong(textFieldCodigoLivro.getText());
	         Exemplares buscaLivro = novoMaterial.procuraCodigo(codigo);
	         if (buscaLivro != null) {
	             JOptionPane.showMessageDialog(null, "Exemplar já Cadastrado!");
	         }
	         else{
	             Livros livro = new Livros();
	             
	             livro.setN_exemplar(textFieldNomeLivro.getText());
	             livro.setCodigo(codigo);
	             livro.setAutor(textFieldAutorLivro.getText());
	             livro.setEditora(textFieldEditoraLivro.getText());
	             livro.setEdicao(Integer.parseInt(textFieldEdicaoLivro.getText()));
	             livro.setT_exemplar(1);
	             novoMaterial.create(livro);
	             JOptionPane.showMessageDialog(null, "Cadastro de Livro com Sucesso!!");
	         }
		 }
		 catch(Exception e){
			 JOptionPane.showMessageDialog(null, "Código ou Edição inválidos");
		 }
	}
	private void cadEArtigo(){
		try{
            codigo = Long.parseLong(textFieldCodigoArtigo.getText());
            Exemplares buscaArtigo = novoMaterial.procuraCodigo(codigo);
            if (buscaArtigo != null){
                JOptionPane.showMessageDialog(null, " Exemplar já Cadastrado!");
            }
            else{
                Artigos artig = new Artigos();
                
                artig.setN_exemplar(textFieldNomeArtigo.getText());
                artig.setCodigo(codigo);
                artig.setAutor(textFieldAutorArtigo.getText());
                artig.setT_exemplar(2);
                novoMaterial.create(artig);
                JOptionPane.showMessageDialog(null, "Cadastro de Artigo com Sucesso!!");
            }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Código inválido");}
	}
	private void cadEper(){
		try{
            codigo = Long.parseLong(textFieldCodigoPer.getText());
            Exemplares buscaPeriodic = novoMaterial.procuraCodigo(codigo);
            if (buscaPeriodic != null) 
            {
                JOptionPane.showMessageDialog(null, "Exemplar já Cadastrado!");
            }
            else
            {   
                Periodicos periodc = new Periodicos();
                
                periodc.setN_exemplar(textFieldNomePer.getText());
                periodc.setCodigo(codigo);
                periodc.setEditora(textFieldEditoraPer.getText());
                periodc.setT_exemplar(3);
                novoMaterial.create(periodc);
                JOptionPane.showMessageDialog(null, "Periodico Cadastrado!");
             }
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "codigo inválido!");
		}
	}
	//metodo para listar todos exemplares
	public void listaExemplares(){
		 for (Exemplares a : novoMaterial.ListarExemplares()){
             Exemp += "Nome do Exemplar: "+a.getN_exemplar()         		 
             +" Codigo: "+a.getCodigo()+"\n\n";
         }
         if (!novoMaterial.ListarExemplares().isEmpty()) {
                 JOptionPane.showMessageDialog(null, Exemp);
         } 
         else{
                 JOptionPane.showMessageDialog(null, "Não há Exemplares cadastrados!");    
         }
         Exemp = "";  
	}
	
	//eventos salvar exemplares
	private class ActionSalvarLivro implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			cadElivro();
			limpaFormLivros();
		}
	}
	private class ActionSalvarArtigo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			cadEArtigo();
			limpaFormArtigos();
		}
	}
	private class ActionSalvarPer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			cadEper();
			limpaFormPer();
		}
	}
	
	//Limpar campos
	private class ActionLimpL implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			limpaFormLivros();
		}	
	}
	private class ActionLimpA implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			limpaFormArtigos();
		}
	}
	private class ActionLimpP implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			limpaFormPer();
		}	
	}
	//eventos sair
	private class ActionSairLivro implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameLivro.setVisible(false);
		}
	}
	private class ActionSairArtigo implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			frameArtigo.setVisible(false);
		}
	}
	private class ActionSairPer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			framePer.setVisible(false);
		}
	}
	
	//Limpar formularios dos textField
	private void limpaFormClientes(){
		textFieldEnd.setText("");textFieldFone.setText("");textFieldNome.setText("");textFieldRg.setText("");
	}
	private void limpaFormLivros(){
		textFieldCodigoLivro.setText(""); textFieldEditoraLivro.setText("");
		textFieldNomeLivro.setText("");textFieldAutorLivro.setText("");textFieldEdicaoLivro.setText("");
	}
	private void limpaFormArtigos(){
		textFieldCodigoArtigo.setText("");textFieldNomeArtigo.setText("");textFieldAutorArtigo.setText("");
	}
	private void limpaFormPer(){
		textFieldCodigoPer.setText(""); textFieldNomePer.setText(""); textFieldEditoraPer.setText("");;
	}

}
