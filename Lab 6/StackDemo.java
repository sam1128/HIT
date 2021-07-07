package hit.week6;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> stack=new Stack<>();
				stack.push("hello");
				stack.push("sam");
				stack.push("hii");
				stack.push("how are you?");
				stack.push("noo");
				
				System.out.println(stack);
				stack.pop();
				
				System.out.println(stack);
				System.out.println(stack.empty());
				System.out.println(stack.peek());
				stack.add(2,"yes");  //vector class method
				System.out.println(stack);
				System.out.println(stack.search("sam"));
				
				
				for(String s:stack) {
					System.out.println(s);
				}		
	}
}
