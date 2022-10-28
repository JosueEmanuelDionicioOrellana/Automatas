package Main;

import java.util.ArrayList;

public class GramaticaLibreContexto {


public static void main(String[] args) {
		
		
		ArrayList<String> lenguajes = new ArrayList<>();
		ArrayList<String> letras = new ArrayList<>();
		ArrayList<String> lengua = new ArrayList<>();
		ArrayList<String> ejemplos = new ArrayList<>();
		
		String letra = ""; 
		String randoms= "";
		String concatenacion = null;
		String sobreposicion = null;
		int valor =0;
		int posicion = 0;
		int contador = 0;
		int subcontador =0;
		int supercontador = 0;
		int verificacion= 0;
		
		//si se agrega una nueva lengua en la lista de abajo, se debe agregar la lengua aqui,que no sea repetida
		lengua.add("S");
		lengua.add("A");
		lengua.add("B");
		
		//por cada linea que se desea agregar, debe modificar el siguiente linea de codigo y agregarle la modificacion =>
		//lenguajes.add("aqui va la regla"); letras.add("aqui va el contenido");
		lenguajes.add("S"); letras.add("aAa");
		lenguajes.add("A"); letras.add("bAb");
		lenguajes.add("A"); letras.add("cBc");
		lenguajes.add("B"); letras.add("dBd");
		lenguajes.add("B"); letras.add("c");

		//cantidad de ejemplos
		int cantidadEjemplos=3;
		
		String lenguaje = lenguajes.get(0);
			
		
		
		while (verificacion <cantidadEjemplos) {
			
			//debe empezar con una S
			if(lenguaje=="S") {

				while(supercontador<=3) {
				
				letra = letras.get(0);
				
				if(subcontador!=0) {
					letra = concatenacion;
				}
				
				//busca cual es el lenguaje dentro de las letras
				for (int j = 0; j < lengua.size(); j++) {
					 posicion = letra.indexOf(lengua.get(j));
					
					if(posicion!=-1) {
						j=lengua.size();
					}
				}
				
				 sobreposicion = letra.charAt(posicion)+"";
		
				while(contador!=1) {
					valor =(int) ((Math.random()*((lenguajes.size()-1)+1))+0);
				
					if(sobreposicion.equals(lenguajes.get(valor))) {
						contador++;
					}
					
				}
				
				concatenacion = letra.replace(sobreposicion,letras.get(valor));
				subcontador++;
				
				//se consulta si el valor agregado tiene una lengua
				letra = letras.get(valor);
				for (int j = 0; j < lengua.size(); j++) {
					 posicion = letra.indexOf(lengua.get(j));
					
					if(posicion!=-1) {
						j=lengua.size();
					}
				}
				
				if(posicion==-1) {
					
					if(!ejemplos.contains(concatenacion)) {
						ejemplos.add(concatenacion);
						verificacion++;
					}

					supercontador=3;
				}else {
				}
				contador=0;
				supercontador++;
				}
				subcontador=0;
				supercontador=0;
			}
			
			
			
		}
		
		
		System.out.println("Algunos ejemplos pueden ser:");
		for (int i = 0; i < ejemplos.size(); i++) {
			System.out.println(ejemplos.get(i));
		}
	}
	 
}
