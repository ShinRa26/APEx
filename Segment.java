public abstract class Segment 
{
	protected Integer length;
	protected Integer cap;
	public Train[] space;
	
	/**
	 * Method to check if the current segment's capacity is full
	 * @return Boolean indicative of whether or not the segment is at capacity
	 */
	public boolean isFull()
	{
		int counter = 0;
		for(int i = 0; i < space.length; i++)
		{
			if(space[i] != null)
				counter++;
			else
				break;
		}
		
		if(counter == space.length)
			return true;
		else 
			return false;
	}
	
	/**
	 * Method to add a train to the first available space in the segment
	 * @param t The train to add.
	 */
	public void addTrain(Train t)
	{
		for(int i = 0; i < space.length; i++)
		{
			if(space[i] == null)
			{
				space[i] = t;
				break;
			}
		}
	}
	
	/**
	 * Method to remove a selected train from a segment.
	 * @param t  The train to remove
	 */
	public void removeTrain(Train t)
	{
		for(int i = 0; i < space.length; i++)
		{
			if(t == this.space[i])
			{
				space[i] = null;
				break;
			}
		}
	}
	
	
	/*** Accessors ***/
	public Integer getLength() {return length;}
	public Integer getCap() {return cap;}
	public Train[] getSpaces() {return space;}
}
