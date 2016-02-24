import java.util.*;
import java.util.concurrent.locks.*;

public class Train 
{
	private Integer speed;
	private String type;
	private ReentrantLock tLock = new ReentrantLock();
	private Condition move = tLock.newCondition();
	
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
	 * Method to move a train onto the next segment if there is space.
	 */
	public void moveTrain(Segment s)
	{
		tLock.lock();
		try
		{
			Integer tSpeed = this.speed;
			Integer sLength = s.length;
			Integer wait = (sLength/tSpeed);
			Thread.sleep(wait);
			
			while(s.isFull())
			{
				System.out.println("Locked and waiting...");
				move.await();
			}
			
			s.addTrain(this);
			move.signalAll();
			System.out.println("Cleared, signalling.");
		}
		catch(InterruptedException e){}
		finally
		{
			tLock.unlock();
		}
	}
	
	/* Accessors */
	public Integer getSpeed(){return speed;}
	public String getType(){return type;}
	public Train getTrain(){return this;}
}
