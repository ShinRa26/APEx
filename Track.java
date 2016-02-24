import java.util.*;

public class Track extends Segment
{
	/* Constructor */
	public Track()
	{
		Random r = new Random();
		length = r.nextInt(20) + 10;
		cap = 1;
		space = new Train[cap];
	}
}
