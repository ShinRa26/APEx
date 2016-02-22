import java.util.*;

public class Track extends Segment
{
	private Train[] t;
	
	/* Constructor */
	public Track()
	{
		Random l = new Random();
		this.length = l.nextInt(20) + 1;
		this.cap = 1;
		t = new Train[cap];
		this.occupied = t;
	}
}
