package hit.week5.Lambda;

public class ThreadDemo3 {
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		t.setName("muhaimeen");
		System.out.println("Reservation counter starting working..."+t.getName());
		
		ReservationCounter central=new ReservationCounter();
		
		Thread imran=new Thread(()-> {synchronized (central) {
				central.bookTicket(1000);
				central.giveChange();
				}
		},"imran");
		
		Thread taqi=new Thread(()-> {synchronized (central) {
				central.bookTicket(600);
				central.giveChange();
      }			
		},"taqi");
		
		imran.start();
		taqi.start();
	}
}

class ReservationCounter{
	int amt;
	public void bookTicket(int amt) {
		Thread t=Thread.currentThread();
		this.amt=amt;
		String name=t.getName();
		System.out.println(name+" has come to book the ticket...");
		System.out.println(name+" brought...:"+amt);
	}
	
	public void giveChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change given to...:"+name);
		System.out.println(name+" takes...:"+(amt-100));
	}

}
