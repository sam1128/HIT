package hit.lab4;

public class InnerClass {
	public static void main(String[] args) {
		Kali k=new Kali();
		k.sellCola();
		
		Pepsi p=new Pepsi();
		p.sellCola();
	}

}
interface Cola{
	public void makeCola();

	}
class Pepsi{
	public void sellCola() {
	Cola cc=new Kali().theif();
	cc.makeCola();
	System.out.println("pepsi bottle filled with campcola & sell....");
}
}

class Kali{
	public void sellCola() {
	//	class CampCola implements Cola{
	//		@Override
	//		public void makeCola() {
	//			System.out.println("Cola made by campcola....");
	//		}
	//	}
		
		CampCola cc=new CampCola();
		cc.makeCola();
		System.out.println("kali bottle filled with campcola & sell....");
	}
	
	public Cola theif(){
		return new CampCola();
	}
	private class CampCola implements Cola{
		@Override
		public void makeCola() {
		System.out.println("Cola made by campcola....");
		}
	}
}
	