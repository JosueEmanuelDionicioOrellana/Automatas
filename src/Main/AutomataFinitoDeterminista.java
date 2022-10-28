package Main;

import java.util.ArrayList;
public class AutomataFinitoDeterminista {


	public static void main(String[] args) {
		
		
		ArrayList<String> lenguajes = new ArrayList<>();
		ArrayList<String> letras = new ArrayList<>();
		
		
		//no debe eliminarse los guion bajo de las esquinas
		
		//el lenguaje finito determinista
		String lenguaje = "_ab+c+b_";
		
		//el ejemplo a validar
		String validacion="_abbbccb_";
		
		String valor;
		String concatenar = "";
		boolean resultado = true ;
		
		
		//separamos el lenguaje en partes
		for (int i = 0; i < lenguaje.length(); i++) {
			
			if(lenguaje.charAt(i)!='+' && lenguaje.charAt(i)!='*'&& lenguaje.charAt(i)!='_') {
				
				if(lenguaje.charAt(i+1)!='+'&& lenguaje.charAt(i+1)!='*') {
					lenguajes.add(lenguaje.charAt(i)+" ");
				}else {
					String conjunto = lenguaje.charAt(i)+""+lenguaje.charAt(i+1)+"";
					lenguajes.add(conjunto);	
					}
			}
		}
		
		
		for (int i = 0; i < validacion.length(); i++) {
			
			if(validacion.charAt(i)!='_') {
				
				if(validacion.charAt(i)==validacion.charAt(i+1)) {
					valor = validacion.charAt(i)+"";
					while(validacion.charAt(i)==validacion.charAt(i+1)) {
						concatenar = concatenar+""+validacion.charAt(i+1);
						i++;
						
					}
					concatenar = concatenar+""+validacion.charAt(i);
					letras.add(concatenar+" ");
				}else {
					valor = validacion.charAt(i)+"";
					concatenar = validacion.charAt(i)+"";
					letras.add(concatenar+" ");
				}
				
				concatenar="";
			}
		}
	
		
		for (int i = 0; i < lenguajes.size(); i++) {
			String leng = lenguajes.get(i);
			
			if(leng.charAt(1)=='*') {
				try {
					resultado = unoOmuchos(leng,letras.get(i));}
					catch(IndexOutOfBoundsException e) {
						resultado = true;
					}
			}else if(leng.charAt(1)=='+') {
				try {
				resultado = unoOmuchos(leng,letras.get(i));}
				catch(IndexOutOfBoundsException e) {
					resultado = false;
				}
			}else {
				try {
				resultado= uno(leng, letras.get(i));}
				catch(IndexOutOfBoundsException e) {
					resultado = false;
				}
			}
		}
		
		
		System.out.println("El lenguaje determinista es: "
				+ "" +lenguaje);
		
		System.out.println("El ejemplo a tratar es:  "+ validacion);
		
		if(resultado==true) {
			System.out.println("El ejemplo es valido");
		}else {
			System.out.println("El ejemplo no es valido");
		}
		
	}
	
	
	public static boolean uno(String lenguaje,String letra) {
		
		if(lenguaje!=letra.charAt(0)+"") {
			
			if(letra.length()<3) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean unoOmuchos(String lenguaje,String letra) {
		
		
		if(lenguaje!=letra.charAt(0)+"") {
			return true;
		}
		return false;
	}

}