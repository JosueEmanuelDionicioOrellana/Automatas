package Main;

public class Pruebas {
	
	public static void main(String[] args) {
		String aa;
		Integer bb;
		Object numero;
		
		numero = "1";
		
		aa= numero.getClass().toString();
		
		System.out.println(aa);
		
		if(aa.equals("class java.lang.Integer")) {
			System.out.println("holi");
		}else {
			
			System.out.println("aaa");
		}
	}

}
