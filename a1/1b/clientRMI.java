import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public class clientRMI {
	private clientRMI() throws RemoteException {}
	public static void main(String[] args) {
		try {
			Calc stub = (Calc)Naming.lookup("rmi://localhost:5000/calculate");
			Scanner sc = new Scanner(System.in);
			String a,b,choice;
			while(true) {
				System.out.println("Enter your base and power: ");
				System.out.println("Enter your first number");
				a = sc.nextLine();
				System.out.println("Enter your second number");
				b = sc.nextLine();
				System.out.println("Result of "+ a + "and " + b + "is "+ stub.calcpow(a,b));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}