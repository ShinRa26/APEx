import java.util.*;

public class Track extends Segment
{
	private Train[] t;
	
	/* Constructor */
	public Track()
	{
		Random l = new Random();
		this.length = l.nextInt(20) + 1;
		this.cap = 1;
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
}
