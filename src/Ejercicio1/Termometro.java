package Ejercicio1;

import java.util.Arrays;

public class Termometro {

	private float temperaturas[];
	private int mes;
	private float tempMinima;
	private float tempMaxima;
	private float tempMedia;
	private float maximaDiasPares;
	private float mediaDiasImpares;
	private float minimaQuincena1;
	private float minimaQuincena2;
	
	public Termometro(int mes){
	
		this.mes = mes;
		generarEspacioTemperaturas(mes);
		tempAleatoria(mes);
		
		//calcular las estadisticas es mucho mejor hacerlo todo en una operacion no es lo mismo que tengamos que recorrer una vez como 
		//en esta operacion que tenga que recorrer como minimo 3 veces para sacar cada temperatura.
		calculosEstadisticos();
	}

	
	
	
	private void calculosEstadisticos() {

		tempMaxima = -1000;
		tempMinima = 1000;
		float suma = 0;
		maximaDiasPares = -1000;
		float sumaImpares= 0;
		mediaDiasImpares = 0;
		int diasImpares = 0;
		minimaQuincena1 = 1000;
		minimaQuincena2 = 1000;
		for(int i = 0;i<temperaturas.length;i++) {
			
			//minimas por quincenas
			if((i<=14) && (temperaturas[i]<this.minimaQuincena1)) {
				minimaQuincena1 = temperaturas[i];
			}
			else if((i>=15) && (temperaturas[i]<this.minimaQuincena2)) {
				minimaQuincena2 = temperaturas[i];
			}
			
			//maxima del mes
			if(temperaturas[i]>this.tempMaxima) {
				tempMaxima = temperaturas[i];
			}
			
			//minima del mes
			if(temperaturas[i]<this.tempMinima) {
				tempMinima = temperaturas[i];
			}
			
			//suma de temperaturas para la media
			  suma += temperaturas[i]; 
			  
			//calculos estadisticos avanzados para sacar cosas pares y impares  
			if(i%2!=0) {
				if(temperaturas[i]>maximaDiasPares) {
					 maximaDiasPares = temperaturas[i];
				}
			}
			
			else {
				sumaImpares += temperaturas[i];
				diasImpares++;
			}
			
		}
	
		tempMedia = suma/temperaturas.length;
		mediaDiasImpares = sumaImpares/diasImpares;
		
		
	}

	
	public float getMaximaDiasPares() {
		return maximaDiasPares;
	}
	
	public float getMediaImpares() {
		return mediaDiasImpares;
	}

	private void generarEspacioTemperaturas(int mes) {
		switch(mes) {
		
		
		case 1,3,5,7,8,10,12:
			temperaturas = new float[31];
			break;
		
		case 4,6,9,11:
			temperaturas = new float[30];
			break;
		
		case 2: 
			temperaturas = new float[28];
			break;
		
		default:
			temperaturas = new float[31];
			this.mes = 1;
			break;
		}
	}

	private void tempAleatoria(int mes) {
		
		for(int i=0;i<temperaturas.length;i++) {
			
			switch(mes) {
				case 12,1,2:
					temperaturas[i] = (float)(Math.random()*18-5);
					break;
			
				case 3,4,5:
					temperaturas[i] = (float)(Math.random()*16+2);
					break;
					
				case 6,7,8:
					temperaturas[i] = (float) (Math.random()*14+15);
					break;
				
				case 9,10,11:
					temperaturas[i] = (float)((Math.random()*15)+8);
					break;
	
			}
			
			
		}
	}
	
	public float getMaxima() {
		 tempMaxima = -1000;
		
		 for(int i =0;i<temperaturas.length;i++) {
			
			if(temperaturas[i]>tempMaxima) {
				tempMaxima = temperaturas[i];
			}
		}
		
		return tempMaxima;
	}
	
	public float getMinima() {
		tempMinima = 1000;
		
		for(int i = 0;i<temperaturas.length;i++) {
			
			if(temperaturas[i]<tempMinima) {
				tempMinima = temperaturas[i];
			}
		}
		return tempMinima;
	}
	
	public float getMedia() {
		tempMedia = 0;
		
		for(int i=0;i<temperaturas.length;i++) {
			 tempMedia += temperaturas[i];
		}
		
		return tempMedia/temperaturas.length;
		
	}
	
	
	public String toString() {
		 
		
		return "El|"+mes+"|tiene como temperaturas"+"{ "+Arrays.toString(temperaturas)+"}\n"
				+ "max ("+tempMaxima+")\n"
				+ "min ("+tempMinima+")\n"
				+ "media ("+tempMedia+")\n";
	}




	public float getMinQuincena(int quincena) {
		
		if(quincena == 1) {
			return minimaQuincena1;
		}
		
		else return minimaQuincena2;
	}
	
	
		

}
