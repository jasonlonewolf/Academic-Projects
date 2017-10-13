import java.rmi.Naming;

public class StoreServer {
	
	public StoreServer() {
		try {
			Store store = new StoreImpl();
			Naming.rebind("StoreService", store);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
	
	public static void main(String[] args) {
		new StoreServer();
		System.out.println("StoreService is running");
	}
}