package hit.week5;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t= new Thread(new Demo());
		t.start();
	}

}

class Demo implements Runnable{
	public void run() {
		System.out.println("Thread execution logic....");
	}
}