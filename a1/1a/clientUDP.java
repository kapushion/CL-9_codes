import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clientUDP 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		System.out.println("Enter base and power: ");
		while(true) {
			String eqn = sc.nextLine();
			if(eqn.equals("bye")) {
				break;
			}
			buf = eqn.getBytes();
			DatagramPacket DpSend = new DatagramPacket(buf,buf.length,ip,1234);
			ds.send(DpSend);
		}
	}
}