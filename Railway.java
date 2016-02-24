import java.util.*;

public class Railway extends Thread
{
	protected List<Segment> l;
	
	/* Constructor */
	public Railway(Integer totSegs)
	{
		l = new ArrayList<Segment>();
		for(int i = 0; i < totSegs; i++)
		{
			if(i % 2 == 0)
				l.add(new Station());
			else
				l.add(new Track());
		}
	}
	
	public void run()
	{
		for(;;)
		{
			try
			{
				Random r = new Random();
				Integer wait = r.nextInt(5000) + 1000;
				Thread.sleep(wait);
				System.out.println(l.get(0).space.length);
				if(!l.get(0).isFull())
				{
					Train t = new Train();
					//System.err.println("Train ID: " + t.getTrain());
					TrainThread tt = new TrainThread(t, l);
					l.get(0).addTrain(t);
					tt.start();
				}
				else
				{
					System.out.println("Home station full...");
					for(int i = 0; i < l.get(0).space.length; i++)
						System.err.println(l.get(0).space[i]);
					Thread.sleep(5000);
				}
			}
			catch(InterruptedException e){}
		}
	}
}
