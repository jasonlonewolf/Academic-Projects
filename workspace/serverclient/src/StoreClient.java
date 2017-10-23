import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class StoreClient {
	
	public static void main(String[] args) {
		
		List<Apple> box = Arrays.asList(new Apple(80, "red"),
				new Apple(10, "red"), new Apple(90, "green"));
		System.out.println("Befor sort: " + box);
		try {
			Store sos = (Store) Naming.lookup("StoreService");
			System.out.println("Box weight:" + sos.weight(box));
			
			List<Apple> after = sos.sortApples(box);
			System.out.println("After sort: " + after);
			

		} catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
	}

}