package hit.week5;

public class EvenOdd {
	public static void main(String[] args) {

		Numbers num=new Numbers();
		
		Thread e=new Thread(new Evod(num),"Even");
		Thread o=new Thread(new Evod(num),"Odd");
		
		e.start();
		o.start();
	}

}

class Evod implements Runnable{
	Numbers num;
	public Evod(Numbers num) {
		this.num=num;
	}
	
	public void run() {
		Thread t=Thread.currentThread();
		if(t.getName().equals("Even"))
			num.even();	
		else if(t.getName().equals("Odd"))
			num.odd();
	}
}

class Numbers{
	public void even() {
		Thread t= Thread.currentThread();
		String name=t.getName();
		System.out.println("Even numbers....."+name);
		for(int i=0;i<=100;i++) {
			if(i%2==0)
			System.out.println(i);
			else
			{}
		}
	}
	public void odd() {
		Thread t= Thread.currentThread();
		String name=t.getName();
		System.out.println("Odd numbers....."+name);
		for(int i=0;i<=100;i++) {
			if(i%2!=0)
			System.out.println(i);
			else
				{}
	}
}
}
