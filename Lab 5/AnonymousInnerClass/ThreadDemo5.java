package hit.week5.AnonymousInnerClass;

public class ThreadDemo5 {
	public static void main(String[] args) {
		CounsellingHall university=new CounsellingHall();
		 Runnable r=new Runnable() {
			@Override
			public void run() {
				if(Thread.currentThread().getName().equals("imran")) {
					university.table1();university.table2();
				}
				else if(Thread.currentThread().getName().equals("secondtaqi")){
					university.water();
				}
			}		
		};
    new Thread(r,"imran").start();
		new Thread(r,"secondtaqi").start();
	}
}

class CounsellingHall{
	synchronized public void table1() {
		System.out.println("entered table1...:"+Thread.currentThread().getName());
		try {Thread.sleep(5000);}catch(Exception e) {}
	}
	synchronized public void table2() {
		System.out.println("entered table2...:"+Thread.currentThread().getName());
	}
	public void water() {
		System.out.println("entered water area to drink water....:"+Thread.currentThread().getName());
	}

}
