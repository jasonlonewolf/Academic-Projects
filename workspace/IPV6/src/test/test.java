package test;

import java.util.*;
import inet.ipaddr.*;

public class test {	
	
	static void print(IPAddress address) {
	       System.out.println(address.toCanonicalString());
	       System.out.println(address.toCanonicalWildcardString());
	       System.out.println(address.toFullString());
	       System.out.println(address.toNormalizedString());
	       System.out.println(address.toSQLWildcardString());
	       System.out.println();
	}
	
	public static void main(String[] args) {
		
		  IPAddress address = new IPAddressString("a:b:c::/64").getAddress();
	       print(address);
	       address = new IPAddressString("a:b:c:*::/64").getAddress();
	       print(address);
			}
	

	
//		String[] sa = {"a", "b", "a", "c", "c", "a"};
//		Map<String, Integer> m = new HashMap<>();
//
//		for (String key : sa) {
//			Integer val = m.get(key);
//			Integer newVal = (val == null) ? 1 : val + 1;
//			m.put(key, newVal);
//		}
//		for (Map.Entry<String, Integer> e : m.entrySet())
//			System.out.print(e.getKey() + ":" + e.getValue() + " ");
//		
//		String[] oss = {"Windows", "Unix", "MacOS", "Andorid", "Linux"};
//		
//		Arrays.sort(oss);
//		System.out.println(oss[0]);
	//}
	
}