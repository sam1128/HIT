package hit.week6;
import java.util.StringTokenizer;

public class LinearDataStructureOneToMany {
	public static void main(String[] args) {
		String str="java,jee,python";
		
		StringTokenizer st=new StringTokenizer(str,",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}