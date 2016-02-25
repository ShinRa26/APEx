import java.util.*;

public class Station extends Segment
{
	/* Constructor */
	public Station()
	{
		Random r = new Random();
		length = r.nextInt(50) + 1;
		cap = r.nextInt(4) + 1;
		space = new Train[cap];
	}
	
	/*** FIX THIS ***/
	public String printSegment(TrainThread t)
	{
		String station = "";
		String[] vac = new String[cap];
		
		for(int i = 0; i < cap; i++)
			vac[i] = "-";
		
		for(int i = 0; i < cap; i++)
		{
			if(space[i] != null)
				vac[i] = "" + t.getId();
			else
				continue;
		}
		
		return "";
	}
}
