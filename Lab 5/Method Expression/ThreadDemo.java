package hit.week5.MethodExpression;

public class ThreadDemo {
	public static void main(String[] args) {
		Runnable r=new Demo()::run; //method expression
		Thread t=new Thread(r);
		t.start();
	}
	}

	class Demo{
		public void run() {
			System.out.println("Thread execution logic....");
		}
	}
