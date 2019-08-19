package Logica;


import java.io.Serializable;
import java.util.Vector;

public class ColeccionLugares implements Serializable {
	
	private int cantidadCabanias;
	private int cantidadParcelas;
	private Lugar [] lugares;
	
	
	
	//Constructor del arreglo (y la clase) sin parámetros.
	public ColeccionLugares() {
		this.cantidadCabanias = 0;
		this.cantidadParcelas = 0;
		lugares=new Lugar[cantidadCabanias+cantidadParcelas];
	}

	//Constructor del arreglo, que contiene la cantidad de parcelas y cabanias
	public void inicializar(int cantidadCabanias, int cantidadParcelas)
	{
		this.cantidadCabanias = cantidadCabanias;
		this.cantidadParcelas = cantidadParcelas;		
		lugares=new Lugar[cantidadCabanias+cantidadParcelas];
	}
	
	//asigna a los primero lugares del arreglo, la cabania y a los siguientes la parcela, c/u con su identificador.
	public void guardarencoleccion (double montoDiarioCabania, double montoDiarioParcela){
		char a = 'A';
		int p=1;
		for(int i =0;i<cantidadCabanias;i++){
			
				lugares [i]= new Cabania(montoDiarioCabania, false,a);
				a=(char)(a+1);
			}
		for (int i=cantidadCabanias;i<cantidadCabanias+cantidadParcelas;i++)
		{
			lugares [i]= new Parcela (montoDiarioParcela,false,p);
			p=p+1;
		}}
		

	//Lista todos los lugares creados en el sistema.
	
	/*public void listarLugares (){
		for (int i=0;i<lugares.length;i++){
			if (lugares[i] instanceof Cabania)
			System.out.println(((Cabania)lugares [i]).getIdentificador());
			else if (lugares[i] instanceof Parcela)
			System.out.println(((Parcela)lugares [i]).getNumero());}}
	*/
	
	//Recibe el char que identifica a la cabania y la devuelve.
	public Cabania buscarLugarCab (char n){
		int i =0;
		boolean loencontre=false;
		Cabania cabaniaauxiliar=null;
		Cabania cabaniafinal=null;
		char idaux='#';
		while ((lugares[i]!=null)&&(loencontre==false)){
			if (lugares[i] instanceof Cabania ){
			cabaniaauxiliar=(Cabania)lugares[i];
			idaux=cabaniaauxiliar.getIdentificador();
					if(n==idaux){
						loencontre=true;
						cabaniafinal=cabaniaauxiliar;}}
			i++;		
		}
			return cabaniafinal;}
		
	
	
	//Recibe el int que identifica a la Parcela  y la devuelve.
	
	public Parcela buscarLugarPar (int n){
		int i =0;
		boolean loencontre=false;
		Parcela parcelaauxiliar=null;
		Parcela parcelafinal=null;
		int idaux=0;
		while ((lugares[i]!=null)&&(loencontre==false)){
			if (lugares[i] instanceof Parcela ){
			parcelaauxiliar=(Parcela)lugares[i];
			idaux=parcelaauxiliar.getNumero();
					if(n==idaux){
						loencontre=true;
						parcelafinal=parcelaauxiliar;}}
			i++;		
		}
			return parcelafinal;}
	
	
	

	
	public Vector <String>  listarCabdisponibles (){
		
		Vector <String> cabaniasdisponibles = new Vector <String>();
		Cabania cabaux=null;
		for(int i =0;i<lugares.length;i++){
			if((lugares[i]!=null)&&(lugares[i] instanceof Cabania)&&(!lugares[i].isEstaOcupado())){
				cabaux=(Cabania)lugares[i];
				cabaniasdisponibles.add(cabaux.getIdentificador()+"");
			}/// FUNCIONA ?
		}
			return cabaniasdisponibles;

		}
	
	
	
	public Vector <String>  listarPardisponibles (){
		
		Vector <String> parcelasdisponibles = new Vector <String>();
		Parcela paraux=null;
		for(int i =0;i<lugares.length;i++){
			if((lugares[i]!=null)&&(lugares[i] instanceof Parcela)&&(!lugares[i].isEstaOcupado())){
				paraux=(Parcela)lugares[i];
				parcelasdisponibles.add(paraux.getNumero()+ "");
			}/// FUNCIONA ?
		}
			return parcelasdisponibles;

		}
	
}
