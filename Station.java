import java.util.*;

public class Station extends Segment
{
	private Train[] t;
	
	/* Constructor */
	public Station()
	{
		Random len = new Random();
		this.length=len.nextInt(10) + 1;
		Random c = new Random();
		this.cap = c.nextInt(4) + 1;
		t = new Train[cap];
		this.occupied = t;
	}
}
