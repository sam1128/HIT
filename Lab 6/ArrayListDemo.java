package hit.week6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		//Arrays
				String s[]=new String[4];
				s[0]="hello";
				//s[1]=new Stone();
				//Arrays are homogeneous - viz, Strictly u can add only one type of data
				//array size is fixed - you cannot change the array size at runtime..
				
				//reading a array
				for(int i=0;i<s.length;i++) {
					System.out.println(s[i]);
				}
				//latest for loop
				for(String str:s) {
					System.out.println(str);
				}
				
				
		List list=new ArrayList();
		
		list.add("hello world");
		list.add("hai");
		list.add(120);
		list.add(new Stone());
		//collections are heterogeneous - viz., they can accept any object type
		//collections size is not fixed and u can add as many objects as you can...
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//new for loop
		for(Object o:list) {
			System.out.println(o);
		}
		//but collections provide more methods to read
		Iterator iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		//cursor created by iterator is forward only cursor and its fail fast - once read it cannot be reused.
		
		//list iterator has the advantage of moving your cursor back and forth
		ListIterator listIter=list.listIterator();
		
		//list.add("aaaaaaaaaaaaaaaaaaaaa"); - you will get a concurrent modification exception
		//if u add something to the main collection after creating the iterator or listiterator
		
		while(listIter.hasNext()) {
			System.out.println(listIter.next());
		}
		while(listIter.hasPrevious()) {
			System.out.println(listIter.previous());
		}
	}
}
class Stone{
//	public Stone(){
//		System.out.println("class Stone");
//	}
}
