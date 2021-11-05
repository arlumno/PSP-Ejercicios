package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class devolverCadenaAFicheroMaster {

	public static void main(String[] args) {
		ProcessBuilder pb = null;
		String entrada;
		File resultadoSalida =new File("src\\tesTing\\ficheros\\devolverCadenaAFicheroMaster.txt");
		try {
			//pb= new ProcessBuilder("java","tesTing.devolverCadena");
			pb= new ProcessBuilder("java","tesTing.devolverCadena","con un argumento");
			pb.directory(new File(".\\bin"));			
			pb.redirectOutput(ProcessBuilder.Redirect.to(resultadoSalida));
			
			Process p = pb.start();			

		}catch (Exception e) {
			// TODO: handle exception
		}


	}

}
