import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
public class Bully {
	static int num_proc = 6;
	static boolean[] state = new boolean[num_proc];
	static int coordinator = 0;
	public static void elect(int startid) 
	{
		int tmpcoord = startid;
		int i = startid;
		int j = i+1;
		for(i=startid;i<num_proc;i++) {
			if(state[i] == true) {
				System.out.println("\nMessage sent from "+i+" to "+ j);
			}
			for(j=i+1;j<num_proc;j++) {
				if(state[j]==true && state[i]==true) {
					System.out.println("\nOK sent from "+j+" to "+i);
					tmpcoord = j;
				}
			}
		}
		coordinator = tmpcoord;
		System.out.println("\nCoordinator is "+ coordinator);
	}
	public static void bringUp(int proc_id) {
		state[proc_id]=true;
		elect(proc_id);
	}
	public static void bringDown(int proc_id) {
		state[proc_id] = false;
	}
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<Bully.num_proc;i++) {
			Bully.state[i] = true;
		}
		System.out.println("5 active process are: ");
		System.out.println("Process up = p1 p2 p3 p4 p5");
		System.out.println("Process 5 is coordinator");
		Bully.bringDown(5);
		Bully.bringDown(4);
		Bully.elect(2);
		Bully.bringUp(5);
		Bully.bringUp(4);
	}
}
