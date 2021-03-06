package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_1_Servidor {

	public static void main(String[] args) {
		try {
			int puerto = 5555;
			ServerSocket server = new ServerSocket(puerto);

			System.out.println("A la espera del cliente...");

			Socket cliente = server.accept();

			OutputStream os = cliente.getOutputStream();
			DataOutputStream salida = new DataOutputStream(os);

			InputStream is = cliente.getInputStream();
			DataInputStream entrada = new DataInputStream(is);

			String texto = "";

			while (true) {
				texto = entrada.readUTF();
				System.out.println("Mensaje del cliente: " + texto);
				if(texto.equals("*")) {
					System.out.println("Fin del servicio");
					break;
				}
				salida.writeInt((texto.length()));				
			}

			entrada.close();
			salida.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
