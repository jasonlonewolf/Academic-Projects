package test2;

public class Main {
	 public static void main(String[] arg){
		byte a = 'A';
		System.out.print("input "+ a );

		String hex = Integer.toHexString(a);
		System.out.println("Hex value is " + hex);
		String bin = Integer.toBinaryString(a);
		
		System.out.println("Hex value is " + bin);
        byte x=5,y=7;
        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);
        String Z = Integer.toBinaryString(x^y);
        System.out.println(X+" "+Y+" "+Z);

        byte x1 = 1;
        boolean y1 = false;
        String X1 = Byte.toString(x1);
        String Y1 = Boolean.toString(y1);

        System.out.println(X1 + " " + x1);
        System.out.println(Y1 + " " + y1);
        
        			
	}
}
