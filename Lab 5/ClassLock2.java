package hit.practice;

public class ClassLock2 {
	public static void main(String[] args) {
		Room1 r1= new Room1();
		Room1 r2= new Room1();
		
		Thread t1=new Thread(new Guard1(r1));
		Thread t2=new Thread(new Guard1(r2));
		
		t1.start();
		t2.start();
	}

}

class Guard1 implements Runnable{
	public Guard1(Room1 room) {
	}

	public void run() {
			
		try {
			Room1.enter();
			Room1.police();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Room1{
	synchronized static void enter() throws InterruptedException { //common people have only one key for many rooms
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" Entering the room....");
		Thread.sleep(2000);
		System.out.println(t.getName()+" Exiting the room....");
	}
	 static void police() throws InterruptedException { //police have masterkey to enter rooms 
		Thread t=Thread.currentThread();
		System.out.println("I'm normal static method..... police entered....."+t.getName());
		Thread.sleep(5000);
		System.out.println("I'm normal static method..... police exit....."+t.getName());
	}

}
