
public abstract class Segment 
{
	protected Integer length;
	protected Integer cap;
	protected Train[] occupied;
	
	/**
	 * Method for determining if a segment is full
	 * @return boolean telling if it's full or not
	 */
	public boolean isFull()
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
	 * Method to add a train to a segment
	 * @param t The train to add
	 */
	public void addTrain(Train t)
	{
		for(int i = 0; i < occupied.length; i++)
		{
			if(occupied[i] != null)
			{
				occupied[i] = t;
				break;
			}
		}
		
		if(isFull())
			System.out.println("Now full");
	}
}
