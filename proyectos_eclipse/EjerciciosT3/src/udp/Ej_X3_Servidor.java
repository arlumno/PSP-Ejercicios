package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ej_X3_Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 12345;
		DatagramPacket paqueteEntrada;
		DatagramPacket paqueteSalida;
		byte[] bufer = new byte[1024];
		boolean fin = false;
		byte[] mensajeRetorno = new byte[1024];
		String mensaje = "";
		InetAddress ipCliente;
		int puertoCliente;
		final String USUARIO = "armando";
		final String PASS = "java";
		String usuarioCliente;
		String passCliente;
		
		try {
			DatagramSocket socket = new DatagramSocket(port);

			while (!fin) {
				
				System.out.println("Esperando usuario");
				bufer = new byte[1024];				
				paqueteEntrada = new DatagramPacket(bufer, bufer.length);
				socket.receive(paqueteEntrada);
				System.out.println("Datagrama recibido.");
				usuarioCliente = new String(paqueteEntrada.getData()).trim();			
				System.out.println("Usuario: " + usuarioCliente);
				
				
				System.out.println("Esperando clave");
				bufer = new byte[1024];				
				paqueteEntrada = new DatagramPacket(bufer, bufer.length);
				socket.receive(paqueteEntrada);
				System.out.println("Datagrama recibido.");
				passCliente = new String(paqueteEntrada.getData()).trim();			
				System.out.println("Pass: " + passCliente);
				
				
				ipCliente = paqueteEntrada.getAddress();
				puertoCliente = paqueteEntrada.getPort();

				if(usuarioCliente.equals(USUARIO) && passCliente.equals(PASS)) {
					mensaje= "Credenciales validadas";
				}else {
					mensaje= "Error, usuario o contraseņa incorrectos";
				}
				mensajeRetorno = mensaje.getBytes();
					
				paqueteSalida = new DatagramPacket(mensajeRetorno, mensajeRetorno.length, ipCliente, puertoCliente);
				socket.send(paqueteSalida);
			}

			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
