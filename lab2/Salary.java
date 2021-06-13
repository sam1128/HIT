package hit.lab2;

import java.util.Scanner;
import java.text.NumberFormat; 
public class Salary
{ 
public static void main(String[] args) 
{ 
double currentSalary;
double raise; 
double newSalary; 
 String rating; 
 Scanner sc = new Scanner(System.in);
System.out.print ("Enter the current salary: ");
currentSalary = sc.nextDouble(); 
 System.out.print ("Enter the performance rating (Excellent, Good, or Poor): "); 
 rating = sc.next(); 

if(rating.equals("Excellent")){
  raise= currentSalary/100*6;
}
else if(rating.equals("Good")){
  raise= currentSalary/100*4;
}
else if(rating.equals("Poor")){
  raise= currentSalary/100*1.5;
}
else{
  raise= 0;
  System.out.println("error! rating doesn't match.");
}
sc.close();
newSalary = currentSalary + raise; 

 NumberFormat money = NumberFormat.getCurrencyInstance(); 
 System.out.println(); 
 System.out.println("Current Salary: " + 
money.format(currentSalary)); 
 System.out.println("Amount of your raise: " + 
money.format(raise)); 
 System.out.println("Your new salary: " + 
money.format(newSalary)); 
 System.out.println(); 
} 
} 