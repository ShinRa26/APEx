import java.util.*;

public class TrainThread extends Thread
{
	private List<Segment> l;
	private Train t;
	private Display d;
	
	/* Constructor */
	public TrainThread(Train t, List<Segment> l)
	{
		this.t = t;
		this.l = l;
		d = new Display(l);
	}
	
	/**
	 * Run method for the Thread
	 */
	public void run()
	{
		d.showStatus();
		for(int i = 0; i < l.size(); i++)
		{
			if(i+1 == l.size())
			{
				l.get(i).removeTrain(t);
				d.showStatus();
				break;
			}
			else
			{
				t.moveTrain(l.get(i+1));
				l.get(i).removeTrain(t);
				d.showStatus();
			}
		}
	}
}
