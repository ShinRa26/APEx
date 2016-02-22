import java.util.*;
import java.util.concurrent.locks.*;

public class Railway extends Thread
{
	private ReentrantLock trainLock = new ReentrantLock();
	private Condition safeToMove = trainLock.newCondition();
	private List<Segment> line;
	private Train t;
	private Integer counter;
	
	/* Constructor */
	public Railway(Integer totSegs)
	{
		line = new ArrayList<Segment>();
		
		for(int i = 0; i < totSegs; i++)
		{
			if(i % 2 == 0)
				line.add(new Station());
			else
				line.add(new Track());
		}
		counter = 0;
	}
	
	/**
	 * Run method for thread
	 * !!!NEEDS FIXING!!!
	 */
	public void run()
	{
		for(;;)
		{
			try
			{
				t = new Train();
				t.start();
				line.get(0).addTrain(t);
				Integer speed = t.getSpeed();
				Integer segLength = line.get(counter).length;
				Thread.sleep((speed/segLength)*100);
				moveTrain();
				counter++;
				
				if(counter >= line.size())
					counter = 0;
			}
			catch(InterruptedException e){}
		}
	}
	
	/**
	 * Method to move a train onto the next segment
	 * !!!NEEDS FIXING!!!
	 */
	public void moveTrain()
	{
		trainLock.lock();
		try
		{
			if(counter+1 >= line.size())
				line.remove(counter);
			else
			{
				while(line.get(counter+1).isFull())
					safeToMove.await();
				
				line.get(counter+1).addTrain(t);
				line.remove(counter);
				signalTrain();
			}	
		}
		catch(InterruptedException e){}
		finally
		{
			trainLock.unlock();
		}
	}
	
	/**
	 * Method to signal all held threads that the next segment is clear
	 * !!!NEEDS FIXING!!!
	 */
	public void signalTrain()
	{
		if(line.get(counter+1).isFull() == false)
			safeToMove.signalAll();
	}
	
	/* Accessors */
	
}
