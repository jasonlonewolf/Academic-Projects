import java.util.List;

public interface Store extends java.rmi.Remote {
	
	List<Apple> sortApples(List<Apple> box) throws java.rmi.RemoteException;
	int weight(List<Apple> box) throws java.rmi.RemoteException;	
}