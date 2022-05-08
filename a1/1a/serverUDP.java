import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class serverUDP 
{
	public static void main(String[] args) throws IOException
	{
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		while(true)
		{
			if(data(receive).equals("bye")) {
				System.out.println("Client sent bye... exiting");
				break;
			}
			DpReceive = new DatagramPacket(receive,receive.length);
			ds.receive(DpReceive);
			String[] s = data(receive).split("\\s+");
			boolean substr = s[1].contains(s[0]);
			String c = null;
			if(substr == true) {
				 c = s[0]+" is substring of "+s[1];
			} else {
				c = s[0]+" is not substring of "+s[1];
			}
			System.out.println("Answer:- "+c);
			receive = new byte[65535];
		}
	}
	public static String data(byte[] a) {
		if(a == null) {
			return null;
		}
		StringBuilder ret = new StringBuilder();
		int i=0;
		while(a[i]!=0) {
			ret.append((char)a[i]);
			i++;
		}
		return ret.toString();
	}
}