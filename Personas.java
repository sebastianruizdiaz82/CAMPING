package Logica;

import java.io.Serializable;

public class Personas implements Serializable{
	
	private Persona[] Personas;
	private int tope = 0;
	
	public int gettope() {
		return tope;
	}
	
	public Persona[] getPersonas() {
		return Personas;
	
	}
	public void setPersonas(Persona[] personas) {
		Personas = personas;
	}
	public void settope(int tope) {
		this.tope = tope;
	}
	
	public Personas(int cuantas)
	{
		this.Personas = new Persona[cuantas];
		
	}
	

	public void agregarPersona(Persona p){
		Personas[tope]=p;
		tope++;}
		

    public void listar()
    {
    	for(int i = 0; i< tope; i++)
    	{
    		System.out.println("la persona es "+Personas[i].getNombre());
    	}
    }
   
    public int tamanioLista() {
    	
    	return tope;
    }
	
    public Persona buscarPersona(long cedula)
    {
    	int i = 0;
    	boolean loencontre=false;
    	Persona p = null;
    	while ((Personas[i]!=null) && (loencontre==false)){
    		if (Personas[i].getNrocedula()== cedula){
    			loencontre=true;
    			p = Personas[i];
    		}
    		i++;
    }
    	return p;
    }
}
