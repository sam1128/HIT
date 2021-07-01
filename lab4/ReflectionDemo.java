package hit.lab4;
import java.util.Scanner;

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {
		//1. static binding.... things which cannot be changed..
				Paint staticPaint=new Red();
				System.out.println("Object created through static way...:"+staticPaint);
				
				//2. dynamic binding.... To dynamically create objects...
				Scanner scan=new Scanner(System.in);
				System.out.println("Please enter the qualified class name...:");
				String paintClass=scan.next();
				//Where ever the return type of a method is Object, you need to do type casting
				scan.close();
				Paint dynamicPaint=(Paint)Class.forName(paintClass).newInstance();
				System.out.println("Object created through dynamic way...:"+dynamicPaint);
				
				//3. new way of creating objects dynamically....after jdk9
				Paint s=(Paint)Class.forName(paintClass).getConstructor().newInstance();
				System.out.println("Object created through new dynamic way...:"+s);
				
	}
			}
		
		abstract class Paint{
			
		}
		class Red extends Paint{
			public Red() {
				
			}
		}
		class Blue extends Paint{
			public Blue() {
				

	}

}

