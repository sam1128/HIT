package hit.lab4;

public class Interface3 {
	public static void main(String[] args) {
		Student student=()->{System.out.println("Lamda expression of student....");
	};
	student.learn();
	
	Driver driver=(String s)->{
		System.out.println("Lamda expression of driver.....");
		System.out.println("string value is..."+s);
	};
	driver.drive("driving car.....");
	
	Pilot pilot=(n,sp)->{
		System.out.print("name is...."+n);
		System.out.print("    speed is....."+sp);
	};	
	pilot.fly("Riya", 1000);
	}

}

interface Student{
	public void learn();
}

interface Driver{
	public void drive(String s);
}

interface Pilot{
	public void fly(String name,int speed);
}