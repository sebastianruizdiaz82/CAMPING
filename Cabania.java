package Logica;

import java.io.Serializable;

public class Cabania extends Lugar implements Serializable {

	private char identificador;
		
	
	public Cabania(double montodiario, boolean estaOcupado, char identificador) {
		super(montodiario, estaOcupado);
		this.identificador = identificador;
		//this.setEstaOcupado(false);
		
	}

	public char getIdentificador() {
		return identificador;
	}

	public void setIdentificador(char identificador) {
		this.identificador = identificador;
	

	

	}

}










