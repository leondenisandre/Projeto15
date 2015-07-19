package br.App;



import javax.swing.ImageIcon;
import javax.swing.JFrame;

import br.gui.Principal;

public class Main {
	public static void main(String[] args){
		Principal a = new Principal();
		
		ImageIcon img = new ImageIcon("C:/Users/Leon Andre/Pictures/bookicon.png");
		a.setIconImage(img.getImage());
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setBounds(100, 100, 450, 300);
		a.setVisible(true);
	}
}
