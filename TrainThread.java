import java.util.*;

public class TrainThread extends Thread
{
	private List<Segment> l;
	private Train t;
	
	/* Constructor */
	public TrainThread(Train t, List<Segment> l)
	{
		this.t = t;
		this.l = l;
	}
	
	/**
	 * Run method for the Thread
	 */
	public void run()
	{
		System.out.println(getName() + " created");
		for(int i = 0; i < l.size(); i++)
		{
			if(i+1 == l.size())
			{
				l.get(i).removeTrain(t);
				break;
			}
			else
			{
				t.moveTrain(l.get(i+1));
				l.get(i).removeTrain(t);
			}
		}
	}
}
