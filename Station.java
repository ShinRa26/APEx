import java.util.*;

public class Station extends Segment
{
	/* Constructor */
	public Station()
	{
		Random r = new Random();
		length = r.nextInt(7) + 1;
		cap = r.nextInt(4) + 1;
		space = new Train[cap];
	}
}
