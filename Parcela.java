package Logica;

import java.io.Serializable;

public class Parcela extends Lugar implements Serializable {

		 private int numero;

		public Parcela(double precio, boolean estaOcupado, int numero) {
			super(precio, estaOcupado);
			this.numero = numero;
			//this.setEstaOcupado(false);
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}
			
			


}

