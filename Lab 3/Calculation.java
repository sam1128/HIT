import java.util.Scanner;
public class Calculation {
  public static void main(String[] args) {
  int cal;
 float num1,num2,result;
 System.out.println("calculator ...choose "
     + "Add 1"
     + "/ subtract 2 "
     + " /divide 3"
     + " /multiply 4");
 
 Scanner in = new Scanner(System.in);
 cal = in.nextInt();
 System.out.println("enter two numbers");
 num1 = in.nextFloat();
 num2 = in.nextFloat();
 switch (cal) {
 case 1:
   result = num1 + num2;
   System.out.println("the vaue of addition is"+result);
   break;
case 2:
  result = num1 - num2;
   System.out.println("the vaue of subraction is "+result);
   break;
   
 case 3:
   result = num1 / num2;
   System.out.println("the value of division is"+result);
   break;
   
 case 4:
   result = num1 * num2;
   System.out.println("the value of multiplication is"+result);
   break;
 }
 in.close();
  }
}
