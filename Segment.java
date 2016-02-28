/**
 * ABstract class for creating Station and Track objects
 * @author Graham Keenan 1105045
 *
 */
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
		//Counter for checking occupancy
		int counter = 0;
		
		//Loops through the array to check for occupied slots
		for(int i = 0; i < space.length; i++)
		{
			//If the space is occupied, increment the counter. Else, break
			if(space[i] != null)
				counter++;
			else
				break;
		}
		
		//If the counter equals the length of the array, the array is full. Returns true
		//Else, array is not full. Returns False.
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
		//Loops through the array for an empty slot
		for(int i = 0; i < space.length; i++)
		{
			//If the array index is empty, add the train and break.
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
		//Loops through the array, looking for the given train.
		for(int i = 0; i < space.length; i++)
		{
			//If the trian is found, set the space equal to null and break.
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
