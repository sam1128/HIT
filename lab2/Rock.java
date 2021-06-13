package hit.lab2;

import java.util.Random;
import java.util.Scanner;

public class Rock
{
public static void main(String[] args)
{
 String personPlay; //User's play -- "R", "P", or "S"
 String computerPlay; //Computer's play -- "R", "P",or "S"
int computerInt; //Randomly generated number used todetermine
//computer's play
Scanner scan = new Scanner(System.in);
Random generator = new Random();
System.out.println("Enter your Option(R,P,S):-");
personPlay=scan.nextLine();
if(personPlay.equals("R")) {
	personPlay= "R";
}
else if(personPlay.equals("P")) {
	personPlay="p";
}
else if(personPlay.equals("S")) {
	personPlay="S";
}
else{
	System.out.println("Error! Invalid option.");
}//Get player's play -- note that this is stored as astring
//Make player's play uppercase for ease of comparison
//Generate computer's play (0,1,2)
//Translate computer's randomly generated play to string
computerInt= generator.nextInt(2);
System.out.println(computerInt);
switch (computerInt)
{
case 0: 
	computerPlay="R";
	break;
case 1:
	computerPlay="P";
	break;
case 2:
	computerPlay="S";
	break;
default:
	computerPlay="error!";
}
System.out.println("Computer play is:- "+computerPlay);
scan.close();
//Print computer's play
//See who won. Use nested ifs instead of &&.
if (personPlay.equals(computerPlay))
System.out.println("It's a tie!");
else if (personPlay.equals("R")) {
	if (computerPlay.equals("S"))
		System.out.println("Rock crushes scissors. You win!!");
	else{
		System.out.println("Computer win!!");// ... Fill in rest of code
}
}
else if(personPlay.equals("P")) {
	if (computerPlay.equals("S"))
		System.out.println(" You win!!");
	else {
		System.out.println("Computer win!!");// ... Fill in rest of code
	}
}
else if(personPlay.equals("S")) {
	if(computerPlay.equals("P"))
		System.out.println(" You win!!");
	else {
		System.out.println("Computer win!!");// ... Fill in rest of code
		}
}
else
{
	System.out.println("Computer win!");
}
}
}


