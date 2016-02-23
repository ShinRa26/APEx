import java.util.*;
import java.util.concurrent.locks.*;

public class Train extends Thread
{
	private Integer speed;
	private String type;
	private ReentrantLock trainLock = new ReentrantLock();
	private Condition safeToMove = trainLock.newCondition();
	
	/* Constructor */
	public Train()
	{
		Random r = new Random();
		speed = r.nextInt(100) + 1;
		
		if(speed >= 50)
			type = "Express";
		else
			type = "Local";
	}
	
	
	/**
	 * Method to move a train into the next segment
	 * @param s The segment to move to
	 */
	public void moveTrain(Segment s)
	{
		trainLock.lock();
		try
		{
			Integer tSpeed = this.getSpeed();
			Integer sLength = s.getLength();
			Thread.sleep((sLength/tSpeed) * 1000);
			
			while(s.isFull())
				safeToMove.await();
			
			s.addTrain(this);
		}
		catch(InterruptedException e){}
		finally
		{
			trainLock.unlock();
		}
	}
	
	/**
	 * Method to signal any sleeping threads that the segment has a free space
	 * @param s The segment to clear.
	 */
	public void signalTrain(Segment s)
	{
		s.removeTrain(this);
		safeToMove.signalAll();
	}
	
	/* Accessors */
	public Integer getSpeed(){return speed;}
	public String getType(){return type;}
}
