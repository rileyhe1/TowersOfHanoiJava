import java.util.ArrayList;

public class Peg 
{
	protected ArrayList<Integer> diskHolder = new ArrayList<Integer>();
	protected String pegName;
	private static int numMoves = 0;
	
	public Peg(String newName)
	{
		this.setPegName(newName);
	}
	
	public Peg(int numDisks, String newName)
	{
		for( int i = numDisks; i > 0; i--)
		{
			this.getDiskHolder().add(i);
		}
		
		this.setPegName(newName);
	}
	
	public ArrayList<Integer> getDiskHolder()
	{
		return this.diskHolder;
	}
	
	public void setDiskHolder(ArrayList<Integer> newDiskHolder)
	{
		for(int i = 0; i < newDiskHolder.size(); i++)
		{
			this.diskHolder.add(newDiskHolder.get(i));
		}
	}
	
	public String getPegName()
	{
		return this.pegName;
	}
	
	public void setPegName(String newName)
	{
		this.pegName = newName;
	}
	
	public void printPeg()
	{
		System.out.print(this.getPegName() + " has disks: ");
		for(int crawler : this.diskHolder)
		{
			System.out.print(crawler);
		}
		System.out.println();
		System.out.println();
	}
	
	public static void incrementNumMoves()
	{
		Peg.numMoves++;
	}
	
	public static int getNumMoves()
	{
		return Peg.numMoves;
	}
}
