package br.com;

public class Artigos extends Exemplares {
	  private String autor;
	    
	    public void Artigos(String autor){
	        this.autor = autor;
	    }
	    public String getAutor(){
	        return this.autor;
	    }
	    public void setAutor(String autor){
	        this.autor = autor;
	    }

}
