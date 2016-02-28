import java.util.*;
import java.util.concurrent.locks.*;

/**
 * Class for creating Train objects
 * @author Graham Keenan 1105045
 *
 */
public class Train 
{
	private Integer speed;
	private String type;
	private String id;
	private ReentrantLock tLock = new ReentrantLock();
	private Condition move = tLock.newCondition();
	
	/*** Constructor ***/
	public Train()
	{
		//Generates a random speed for the Train between 1 and 100
		Random r = new Random();
		speed = r.nextInt(100) + 1;
		
		//If the speed is >= 50, then it is classed as an Express train. Else, it is classed as a Local train
		if(speed >= 50)
			type = "Express";
		else
			type = "Local";
	}
	
	/**
	 * Method to move a train onto the next segment if there is space.
	 */
	public void moveTrain(Segment s)
	{
		//Locks the current thread.
		tLock.lock();
		try
		{
			//The train will wait in the segment for a given time (Segment length/Train speed)
			Integer tSpeed = this.speed;
			Integer sLength = s.length;
			//Wait time is multiplied by 500 to ensure that the display is visible and doesn't move too fast
			Integer wait = (sLength/tSpeed)*500;
			Thread.sleep(wait);
			
			//While the next segment is full, await the signal from the lock condition
			while(s.isFull())
			{
				System.err.println("Locked and waiting...");
				move.await();
			}
			
			//Moves the train into the next segment
			s.addTrain(this);
			//Signals all threads waiting.
			move.signalAll();
			//System.out.println("Cleared, signalling.");
		}
		catch(InterruptedException e){}
		finally
		{
			//Finally, the thread is unlocked
			tLock.unlock();
		}
	}
	
	/*** Accessors ***/
	public Integer getSpeed(){return speed;}
	public String getType(){return type;}
	public String getId(){return id;}
	public void setId(String n){id = n;}
}
