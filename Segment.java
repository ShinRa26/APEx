
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
		for(int i = 0; i < this.occupied.length; i++)
		{
			if(this.occupied[i] != null)
				counter++;
		}
		
		if(counter == this.occupied.length)
			return true;
		else
			return false;
	}
	
	/**
	 * Method for adding a Train to the segment
	 * @return the array containing the newly added train
	 */
	public Train[] addTrain(Train t)
	{
		for(int i = 0; i < this.occupied.length; i++)
			if(this.occupied[i] == null)
			{
				this.occupied[i] = t;
				break;
			}
		
		return this.occupied;
	}
	
	/**
	 * Method for removing a train from a segment, only once it has been been moved.
	 * @param t The train to be moved.
	 */
	public Train[] removeTrain(Train t)
	{
		for(int i = 0; i < this.occupied.length; i++)
		{
			if(t == this.occupied[i])
			{
				this.occupied[i] = null;
				break;
			}
		}
		
		return this.occupied;
	}
	
	
	public  Integer getLength(){return this.length;}
	public Integer getCap(){return this.cap;}
}
