package hit.week5.MethodExpression;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t=new Thread(new Demo()::run);  //method expression 
		t.start();
	}
	}

	class Demo implements Runnable{
		public void run() {
			System.out.println("Thread execution logic....");
		}
	}
