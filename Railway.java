import java.util.*;

public class Railway extends Thread
{
	private List<Segment> line;
	private Train t;
	private TrainThread tt;
	
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
				Integer wait = r.nextInt(7000) + 3000;
				Thread.sleep(wait);
				t = new Train();
				line.get(0).addTrain(t);
				System.out.println(line.get(0).occupied[0].getSpeed());
				tt = new TrainThread(t, line);
				tt.start();
				
			}
			catch(InterruptedException e){}
		}
	}
	public Train[] getStatus(Integer n)
	{
		return line.get(n).occupied;
	}
}
