package tesTing;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


/*
 * 1. Escribe una clase llamada Ejecuta que reciba como argumentos el comando y las opciones del comando que se quiere ejecutar. 
 * 	El programa debe crear un proceso hijo que ejecute el comando con las opciones
	correspondientes mostrando un mensaje de error
	en el caso de que no se realizase correctamente la
	ejecuci�n. El padre debe esperar a que el hijo termine de informar si se produjo alguna anomal�a en la
	ejecuci�n del hijo
 */
public class Ejecuta {
	public static void main(String[] args) {//ejecutar desde consola
		// TODO Auto-generated constructor stub
		/*
		String comando = args[0];
		List<String> lista = Arrays.asList(args);
		lista.remove(0);
		String[] opciones = new String[lista.size()]; 
		opciones = lista.toArray(opciones);
		*/
		if(args.length == 0) {
			
				System.out.println("Error: La petici�n no contiene argumentos");
		}else {
			
			ProcessBuilder pb = new ProcessBuilder(args);
			try {
				Process p = pb.start();
				InputStream is = p.getErrorStream();
				StringBuilder errores = new StringBuilder();
				int c;			
				while ((c = is.read()) != -1) {
					errores.append((char)c);
				}
				is.close();
				if(errores.length()>0) {
					System.out.println("Se han detectado los siguientes errores:");
					System.out.println(errores.toString());												
				}
				if(p.waitFor() == 0) {
					System.out.println("Operaci�n finalizada con �xito");
				}else{
					System.out.println("Operaci�n NO se ha realizado con �xito, algo malo ha ocurrido.");
				}
				
			}catch (Exception e) {
				System.out.println("Errores: " + e.toString());
			}
		
		}
	}
}