import java.net.*;
import java.io.*;
import java.math.*;
import java.util.*;
public class client {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	public client(String address,int port) {
		try {
			socket = new Socket(address,port);
			System.out.println("Connected");
			input = new DataInputStream(System.in);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch(UnknownHostException u) {
			System.out.println(u);
		} catch(IOException i) {
			System.out.println(i);
		}
		Scanner sc = new Scanner(System.in);
		String a="";
		String b="";
		System.out.println("Enter base: ");
		a = sc.nextLine();
		System.out.println("Enter power: ");
		b = sc.nextLine();
		System.out.println("Sending Base and power to server");
		try {
			boolean substr = b.contains(a);
			if(substr == true) {
				String s = a+" is substring of "+b;
				out.writeChars(s);
			} else {
				String s = a+" is not substring of "+b;
				out.writeChars(s);
			}
		} catch(IOException i) {
				System.out.println(i);
		}
		try {
			System.out.println("Closing connection...");
			input.close();
			out.close();
			socket.close();
		} catch(IOException i) {
			System.out.println(i);
		}
	}
	public static void main(String args[]) {
		client client1 = new client("127.0.0.1",5000);
	}
}