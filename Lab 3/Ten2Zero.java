public class Ten2Zero{
public static void main(String[] args){
  Acls a=new Cls();
  a.num(10);
 
}
}
abstract class Acls{
  public void Acls(){
    System.out.println("Abstract class...");
  }
  int num(int n){      
    return num(n);
  }
}
class Cls extends Acls{
  int num(int n){
  System.out.println(n);
  try{
    if(n>0)
    return num(--n);
  }
  catch(Exception e){
    System.out.println("execption happened...");
  }
  finally{
    return 0;
  }
  }
}
