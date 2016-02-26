import java.util.*;

public class Track extends Segment
{
	/*** Constructor ***/
	public Track()
	{
		Random r = new Random();
		length = r.nextInt(250) + 100;
		cap = 1;
		space = new Train[cap];
	}
	
}
