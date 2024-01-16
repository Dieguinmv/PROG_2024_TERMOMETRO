package Ejercicio1;

public class Start {

	public static void main(String[] args) {

		Termometro termometro = new Termometro(6);
		
		System.out.println(termometro);
		System.out.println("------------------");
		System.out.println("La maxima de los dias pares ---> "+termometro.getMaximaDiasPares());
		System.out.println("La media de los dias Impares es----> "+termometro.getMediaImpares());
		System.out.println("La minima de la quincena "+termometro.getMinQuincena(1));
		System.out.println("La minima de la quincena "+termometro.getMinQuincena(2));
	}

}
