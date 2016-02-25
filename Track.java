import java.util.*;

public class Track extends Segment
{
	/* Constructor */
	public Track()
	{
		Random r = new Random();
		length = r.nextInt(100) + 10;
		cap = 1;
		space = new Train[cap];
	}
	
	/**
	 * Method to print out the state of the segment in String format
	 */
	public String printSegment(TrainThread t)
	{
		String track = "";
		
		if(space[0]!= null)
		{
			String trainId = "" + t.getId();
			track = String.format("|----Track--%s---|", trainId);
		}
		else
			track = "|----Track------|";
		
		return track;
	}
}
