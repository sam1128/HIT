package hit.lab4;

public class InnerClass2 {
	public static void main(String[] args) {
		Kali2 kalimark=new Kali2();
		kalimark.sellCola();
		
		Pepsi2 pepsico=new Pepsi2();
		pepsico.sellCola();
	}
}
interface Cola2{
	public void makeCola();
}
class Pepsi2{
	public void sellCola() {
		//if you want to access a inner class  -- below is the syntax
		//Kali.CampaCola cc=new Kali().new CampaCola();
		
		//Cola cc=new Kali().thief();
		//cc.makeCola();
		//System.out.println("Pepsi fills campa cola in pepsi bottle and sell..");
	}
}
class Kali2{
	public void sellCola() {
		//local inner class - a class with in a method...
		//merging.... 1
		//merging 1 problem - The class called campacola is still existing..
//		class CampaCola implements Cola{//inner class
//			@Override
//			public void makeCola() {
//				System.out.println("Cola made by campa cola...");
//			}
//		}
		//Merging 2 - The class campa cola will be dissolved.
		//Strategy 1  - anonymous inner class
		new Cola2() {			
			@Override
			public void makeCola() {
				System.out.println("campa cola is made....");
			}
		}.makeCola();
		//CampaCola cc=new CampaCola();
		//cc.makeCola();
		//Strategy 2 - Method Expression
		Cola2 cc=new Kali2()::makeKaliCola;
		cc.makeCola();
		
		//Strategy 3 - Lambda
		Cola2 ccc=()->{System.out.println("Cola made by campa cola....using lambda....");};
		ccc.makeCola();
		System.out.println("kali fills campa cola in bovonto bottle and sell..");
	}
	private void makeKaliCola() {
		System.out.println("cola made by kali using campa cola formula....");
	}
//	public Cola thief() {
//		return new CampaCola();
//	}
	//kalimark has acquired campacola...
//	private class CampaCola implements Cola{//inner class
//		@Override
//		public void makeCola() {
//			System.out.println("Cola made by campa cola...");
//		}
//	}
}
