package hit.week5.AnonymousInnerClass;

public class ThreadDemo {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("Thread execution logic....");	
			}
		}.start();
	}

}
