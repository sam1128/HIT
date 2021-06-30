package hit.week5;

public class EvenOdd {
	public static void main(String[] args) {
		
		Numbers num=new Numbers();
		
		Thread e=new Thread(new Even(num));
		Thread o=new Thread(new Odd(num));
		
		e.start();
		o.start();
	}

}

class Even implements Runnable{
	Numbers num;
	public Even(Numbers num) {
		this.num=num;
	}
	
	public void run() {
			num.even();	
	}
}

class Odd implements Runnable{
	Numbers num;
	public Odd(Numbers num) {
		this.num=num;
	}
	
	public void run() {
		num.odd();
	}
}

class Numbers{
	public void even() {
		System.out.println("Even numbers.....");
		for(int i=0;i<=100;i++) {
			if(i%2==0)
			System.out.println(i);
			else
			{}
		}
	}
	public void odd() {
		System.out.println("Odd numbers.....");
		for(int i=0;i<=100;i++) {
			if(i%2!=0)
			System.out.println(i);
			else
				{}
	}
}
}