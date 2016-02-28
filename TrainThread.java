import java.util.*;

/**
 * Class for creating Threads of Train objects
 * @author Graham Keenan 1105045
 *
 */
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
		//Displays the current status of the railway
		d.showStatus();
		
		//Loops through the length of the railway
		for(int i = 0; i < l.size(); i++)
		{
			//If we're at the end of the Railway, remove the Train from the current segment, show the status, and break.
			if(i+1 == l.size())
			{
				l.get(i).removeTrain(t);
				d.showStatus();
				break;
			}
			//Else, move the train into the next segment, remove the train from the previous segment, and show the status.
			else
			{
				t.moveTrain(l.get(i+1));
				l.get(i).removeTrain(t);
				d.showStatus();
			}
		}
	}
}
