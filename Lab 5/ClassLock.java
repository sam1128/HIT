package hit.practice;

public class ClassLock {
	public static void main(String[] args) {
		Room r1= new Room();
		Room r2= new Room();
		
		Thread t1=new Thread(new Guard(r1));
		Thread t2=new Thread(new Guard(r2));
		
		t1.start();
		t2.start();
	}

}

class Guard implements Runnable{
	Room room;
	public Guard(Room room) {
		this.room=room;
	}
	
	public void run() {
		try {
			room.enter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class Room{
	 public void enter() throws InterruptedException {
		 synchronized(Room.class) {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" Entering the room....");
		Thread.sleep(2000);
		System.out.println(t.getName()+" Exiting the room....");
	}
	}
}