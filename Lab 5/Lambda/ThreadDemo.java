package hit.week5.Lambda;

public class ThreadDemo {
	public static void main(String[] args) {
		Demo d=new Demo();
		Thread t1= new Thread(()->d.run()); //lambda expression 
		Thread t=new Thread(()->{ System.out.println("Thread execution logic...."+Thread.currentThread().getName());
		},"other way");  //other way lambda for an instance
		t.start();
		t1.start();
	}
	}

	class Demo implements Runnable{
		public void run() {
			System.out.println("Thread execution logic....");
		}
	}
