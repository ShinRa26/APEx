import java.util.*;

public class Railway extends Thread
{
	protected List<Segment> l;
	
	/*** Constructor ***/
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
	
	/**
	 * Run method for the Railway thread
	 */
	public void run()
	{
		for(;;)
		{
			try
			{
				Random r = new Random();
				Integer wait = r.nextInt(5000) + 1000;
				Thread.sleep(wait);

				if(!l.get(0).isFull())
				{
					Train t = new Train();
					TrainThread tt = new TrainThread(t, l);
					String trainId = "" + tt.getId();
					t.setId(trainId);
					l.get(0).addTrain(t);
					tt.start();
				}
				else
				{
					System.out.println("Home station full...");
					for(int i = 0; i < l.get(0).space.length; i++)
						System.err.println(l.get(0).space[i].getId());
					Thread.sleep(5000);
				}
			}
			catch(InterruptedException e){}
		}
	}
	
	/* Accessors */
	public List<Segment> getRailway(){return l;}
}
