import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflec2 {
    public static void main(String[] args)throws Exception {
        HolyMan holy=new HolyMan();
        holy.doService();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter method name: doService/doPreach");
        String methodName=sc.next();
        sc.close();

        Class c=holy.getClass();
        Method m=c.getMethod(methodName);
        m.invoke(holy);
        
        m=c.getMethod("collectMoney", int.class);
        m.invoke(holy, 1000);
        
        m=c.getMethod("register", String.class,int.class);
        m.invoke(holy, "superman",1000);
    }
}

class HolyMan{
    public void doService() {
        System.out.println("I do social service.....");
    }
    
    public void doPreach() {
        System.out.println("I preach personality development...");
    }
    
    public void collectMoney(int money) {
        System.out.println("Money collected....:"+money);
    }
    public void register(String name,int fees) {
        System.out.println("Registered as bakra...:"+name+"   fees...:"+fees);
    }
} 
