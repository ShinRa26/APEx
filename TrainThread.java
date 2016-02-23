import java.util.*;

public class TrainThread extends Thread
{
	private Train t;
	private List<Segment> l;
	private ListIterator<Segment> it;
	
	public TrainThread(Train t, List<Segment> l)
	{
		this.t= t;
		this.l = l;
		
		it = l.listIterator();
	}
	
	public void run()
	{
		int count = 0;
		System.out.println(getName() + " created!");
		while(it.hasNext())
		{
			t.moveTrain(l.get(count+1));
			System.err.println(l.get(count+1).occupied[0].getSpeed());
			t.removeTrain(l.get(count));
			
			count++;
		}
		
		if(!it.hasNext())
			t.removeTrain(l.get(l.size()-1));
	}
}
