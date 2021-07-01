package hit.lab4;

public class Clone2 {
	public static void main(String[] args) {
		Cow mothercow= new Cow();
		mothercow.name="I am mother cow.....";
		
		//Cow rupa= new Cow(); //multition
		// Cow rupa= mothercow; //singleton
		Cow rupa= mothercow.createClone(); //cloning
		rupa.name="I am the clone rupa....";
		
		System.out.println("Mother name:..."+mothercow.name);
		System.out.println("Clone name:...."+rupa.name);
	}

}

class Cow implements Cloneable{
	public Cow() {
		System.out.println("Cow object is created....");
	}
	public Cow createClone() {
		try {
		return (Cow)super.clone();
		} catch(CloneNotSupportedException ce) {
			ce.printStackTrace();
			return null;
		}
		
	}
	public String name;
}