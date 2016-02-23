import java.util.*;

public class Station extends Segment
{
	private Train[] t;
	
	/* Constructor */
	public Station()
	{
		Random len = new Random();
		this.length=len.nextInt(10) + 1;
		Random c = new Random();
		this.cap = c.nextInt(4) + 1;
		t = new Train[cap];
		this.occupied = t;
	}
	
	/**
	 * Method for determining if a segment is full
	 * @return boolean telling if it's full or not
	 */
	boolean isFull()
	{
		int counter = 0;
		for(int i = 0; i < occupied.length; i++)
		{
			if(occupied[i] != null)
				counter++;
		}
		
		if(counter == occupied.length)
			return true;
		else
			return false;
	}
	
	/**
	 * Method for adding a Train to the segment
	 * @return the array containing the newly added train
	 */
	Train[] addTrain(Train t)
	{
		for(int i = 0; i < occupied.length; i++)
			if(occupied[i] == null)
			{
				occupied[i] = t;
				break;
			}
		
		return occupied;
	}
	
	/* Accessors */
	public Integer getLength() {return length;}
	public Integer getCap() {return cap;}
}
