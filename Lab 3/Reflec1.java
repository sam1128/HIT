import java.util.Scanner;
public class Reflec1{
  public static void main(String[] args) throws Exception{
    Paint staticPaint= new Blue();
    System.out.println("object created by static way...");
    
    Scanner sc=new Scanner(System.in);
    System.out.println("enter a class name...");
    String cls= sc.next();
    
    Paint dynamicPaint=(Paint)Class.forName(cls).newInstance();
    System.out.println("object created by dynamic way... "+dynamicPaint);
    
    Paint s=(Paint)Class.forName("Green").getConstructor().newInstance();
    System.out.println("object created by new dynamic way... "+s); 
    }
}

abstract class Paint{
  
}

class Red extends Paint{
  public Red(){
    System.out.println("Red paint applied...");
  }
}

class Blue extends Paint{
  public Blue(){
    System.out.println("Blue paint applied...");
    
  }
}

class Green extends Paint{
  public Green(){
    System.out.println("Green paint applied...");
  }
}
