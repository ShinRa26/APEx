import java.util.*;

public class Railway extends Thread
{
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
		for(;;)
		{
			try
			{
				Random r = new Random();
				Integer wait = r.nextInt(7000) + 1;
				Thread.sleep(wait);
				t = new Train();
				line.get(0).addTrain(t);
			}
			catch(InterruptedException e){}
		}
	}
}
