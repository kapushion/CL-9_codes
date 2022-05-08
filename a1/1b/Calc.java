import java.rmi.*;

public interface Calc extends Remote {
	public boolean calcpow(String x,String y) throws RemoteException;
}