import java.util.*;
import java.io.Serializable;

public class Apple implements Serializable {
	private int weight = 0;
	private String color = "";
	
//	public Integer getWeight() {
//		return weight;
//	}
	
	//Cannot invoke compareTo(int) on the primitive type int
	//A primitive-type variable can be used to invoke a method. -> false
	//An import statement is not required when one class in a package uses another in the same package. -> true
	//A class that is declared final cannot be subclassed -> true
	//One can override a private method ->false
	//Integer.parseInt(s); You have to catch NumberFormatException
	//new Thread( () -> System.out.println (x % 2 == 0)).start();
   //strList.removeIf(s -> s.length() <= 5); removes all strings with less than or equal five characters
//[Second]
	

	public int getWeight() {
		return weight;
	}
	
	public String getColor() {
		return color;
	}
	
	public Apple(int weight, String color){
		this.weight = weight;
		this.color = color;
	}
	
	public String toString() {
		return "Apple{" + "color='" + color + '\'' +", weight=" + weight +'}';
	}

	public static void main(String[] args) {
		List<Apple> box = Arrays.asList(new Apple(80,"green"), 
                    new Apple(155, "green"), new Apple(120, "red"));
		
		//Cannot invoke compareTo(int) on the primitive type int
		//Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());
		box.sort(c);
		System.out.println(box);
	}
}