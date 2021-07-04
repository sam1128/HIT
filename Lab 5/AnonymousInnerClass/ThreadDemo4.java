package hit.week5.AnonymousInnerClass;

public class ThreadDemo4 {
	public static void main(String[] args) {
		Canon gun=new Canon();
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				Thread t=Thread.currentThread();
				if(t.getName().equals("naina")) {
					for(int i=0;i<5;i++) {
						gun.fill();
					}
				}
				else if(t.getName().equals("shabeer")) {
					for(int i=0;i<5;i++) {
						gun.shoot();
					}
				}			
			}
		};
    new Thread(r,"naina").start();
		new Thread(r,"shabeer").start();
    
class Canon{
	boolean flag;
	synchronized public void fill() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println(name+" fills the gun.......");
		flag=true;
		notify();
	}
	
	synchronized public void shoot() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(!flag) {
			try {wait();}catch(Exception e) {}
		}
		System.out.println(name+" shoot the gun...........");
		flag=false;
		notify();
	}
}
