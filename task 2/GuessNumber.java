import java.util.*;

public class GuessNumber{
static ArrayList<Integer>scoreBoard=new ArrayList<Integer>();
public static void main(String args[])
{
GuessNumber methodchange=new GuessNumber();
methodchange.menu(scoreBoard);
}




// menu method
public void menu(ArrayList<Integer>scoreBoard)
{
GuessNumber methodchange=new GuessNumber();
Scanner sc=new Scanner( System.in);
System.out.println("**********************************");
System.out.println("Welcome to Number game");
System.out.println("1.Play the game");
System.out.println("2.Score Board");
System.out.println("3.Exit game");
System.out.println("*********************************");
try{
System.out.println("Enter your choice: ");
int choice=sc.nextInt();
	switch(choice){
		case 1: System.out.println("what would you like the range of the number to be?");
			int numrange=sc.nextInt();
			int randomNumber=methodchange.randomNumber(numrange);
			methodchange.guessnum(randomNumber);
			break;
		case 2: methodchange.displayScoreBoard();
			break;
		case 3:System.out.println("***Thankyou***");
			System.exit(1);
			break;
		default: throw new InputMismatchException("Invalid number entry. Please enter valid choice ");
}
}
catch(InputMismatchException e)
{
System.err.println("\n"+e.getMessage()+"\n");
menu(scoreBoard);
}
}


//randomnumber method

public int randomNumber(int numrange)
{
  Random random=new Random();
  int randomNumber=random.nextInt(numrange)+1;
  return randomNumber;
}


// guess num method


public void guessnum( int randomNumber)
{
Scanner sc=new Scanner (System.in);
int userguess;
int guess=0;
do{
System.out.print("Enter your guess Number : ");
userguess =sc.nextInt();

guess++;
if(userguess > randomNumber){
System.out.println("Lower");
}
else if(userguess < randomNumber){
System.out.println("Higher");
}
}
while(randomNumber!=userguess);
System.out.println(" ");
 if(guess==1)
{
	System.out.println("You answered number is right in "+ guess +"tries");
}
 else
{
System.out.println("You answered number is right in "+ guess +"tries");
}
scoreBoard.add(guess);
System.out.println(" ");

menu(scoreBoard);
}


//displayscoreboard

public void displayScoreBoard()
{
System.out.println("*********************************");
System.out.println(" Score Board");

System.out.println("your fastest game today in all tries is :"+"\n");
Collections.sort(scoreBoard);
for (int scores: scoreBoard)
{
System.out.println("Finished the number game in "+scores +" tries");
}
System.out.println(" ");
menu(scoreBoard);
}

}