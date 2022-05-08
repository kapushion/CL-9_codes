import java.net.*;
import java.io.*;
import java.lang.Math;

public class server
{
	private Socket socket=null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	public server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server Started");
			int i = 1;
			while(true) {
				try {
					System.out.println("Wating for client.... ");
					socket = server.accept();
					System.out.println("Client "+ i + " accepted");
					ServerThread st = new ServerThread(socket,"Client "+String.valueOf(i));
					i++;
					st.start();
				} catch(Exception e) {
					System.out.println("Connection error");
				}
			}
		} catch(IOException i) {
			System.out.println(i);
		}
	}
	public static void main(String args[])
	{
		server server1 = new server(5000);
	}
}

class ServerThread extends Thread {
	String s="";
	DataInputStream in = null;
	DataOutputStream out = null;
	Socket socket = null;
	String clientnum = "";
	public ServerThread(Socket s,String clientnum) {
		socket = s;
		this.clientnum = clientnum;
	}
	public void run() {
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			s = in.readLine();
			System.out.println("Recieved Base and Power. Answer is: "+s);
		} catch(IOException ie) {
			System.out.println("socket close error");
		}
	}
}