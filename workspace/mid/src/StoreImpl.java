import java.rmi.RemoteException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StoreImpl extends java.rmi.server.UnicastRemoteObject
		implements Store {

	protected StoreImpl() throws RemoteException {
		super();
	}

	public List<Apple> sortApples(List<Apple> box)
			throws RemoteException {
		//Cannot invoke compareTo(int) on the primitive type int
		//Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());
		

		box.sort(c);
		return box;
	}

	public int weight(List<Apple> box) throws RemoteException {
		int weight = 0;
		
		Iterator<Apple> it = box.iterator();
		while (it.hasNext()) {
			Apple a = (Apple) it.next();
			weight += a.getWeight();
		}		
		return weight;
	}
}