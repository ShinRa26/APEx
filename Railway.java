import java.util.*;
import java.util.concurrent.locks.*;

public class Railway extends Thread
{
	private ReentrantLock trainLock = new ReentrantLock();
	private Condition safeToMove = trainLock.newCondition();
	private List<Segment> line;
	private Train t;
	
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
	}
	
	/**
	 * Run method for thread
	 * !!!NEEDS FIXING!!!
	 */
	public void run()
	{
		t = new Train();
		t.start();
	}
	
	/**
	 * Method to move a train onto the next segment
	 * !!!NEEDS FIXING!!!
	 */
	public void moveTrain()
	{
		//PH
	}
}
