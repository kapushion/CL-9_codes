import java.rmi.*;
import java.rmi.server.*;

public class CalcRemote extends UnicastRemoteObject implements Calc {
	CalcRemote() throws RemoteException {
		super();
	} 
	public boolean calcpow(String x,String y)
	{
		return y.contains(x);
	}
}