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
				Integer wait = r.nextInt(10000) + 1000;
				Thread.sleep(wait);
				Train t = new Train();
				System.out.println(l.get(0).space.length);
				if(!l.get(0).isFull())
				{
					l.get(0).addTrain(t);
					System.out.println("Added Train");
				}
				else
					System.out.println("Full");
				
			}
			catch(InterruptedException e){}
		}
	}
}
