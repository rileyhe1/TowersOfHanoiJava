import java.util.Scanner;
import java.util.InputMismatchException;

public class Hanoi 
{
	
	public static int promptNumDisks() throws InputMismatchException
	{
		System.out.println("~~~~~~~~~~  Welcome to Riley's Tower of Hanoi Simulator!  ~~~~~~~~~~");
		
		Scanner keyboard = new Scanner(System.in);
		int numDisks = 0;
		try 
		{
			System.out.println("How Many Disks Would You Like in the Puzzle?");
			numDisks = keyboard.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input in wrong format, enter as an integer!");
		}
		keyboard.close();
		return numDisks;
	}
	
	public static void moveDisk(Peg start, Peg goal)
	{
		int temp = start.getDiskHolder().remove(start.getDiskHolder().size()-1);
		goal.getDiskHolder().add(temp);
		System.out.println("Moved disk " + temp + " from " + start.getPegName() + " to " + goal.getPegName());
		Peg.incrementNumMoves();
	}
	
	public static void hanoi(int numDisks, Peg start, Peg temp, Peg goal)
	{
		if(numDisks > 0)
		{
			hanoi(numDisks-1, start, goal, temp);
			moveDisk(start, goal);
			hanoi(numDisks-1,temp, start, goal);
		}
	}

	public static void main(String[] args) 
	{
		int numDisks = promptNumDisks();
		Peg peg1 = new Peg(numDisks, "Starting Peg");
		Peg peg2 = new Peg("Temporary Peg");
		Peg peg3 = new Peg("Goal Peg");
		
		System.out.println("Starting Condition of Disks:");
		peg1.printPeg();
		peg2.printPeg();
		peg3.printPeg();
		
		hanoi(numDisks, peg1, peg2, peg3);
		
		System.out.println("Ending Condition of Disks:");
		peg1.printPeg();
		peg2.printPeg();
		peg3.printPeg();
		
		System.out.println("Puzzle solved in " + Peg.getNumMoves() + " moves");
	}
}
