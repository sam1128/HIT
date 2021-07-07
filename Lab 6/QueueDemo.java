package hit.week6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue=new LinkedList<>();
		queue.add("hello");
		queue.add("hi");
		queue.add("hey");
		queue.add("hieee");
		
		System.out.println(queue);
		queue.remove(); //it throws exception if queue is empty so its diff from poll
		System.out.println(queue);
		
		System.out.println(queue.peek());//retrieves head of queue
		System.out.println(queue.poll());//retrieve and removes head of queue
		System.out.println(queue);
	}

}
