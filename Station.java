import java.util.*;

public class Station extends Segment
{
	/*** Constructor ***/
	public Station()
	{
		Random r = new Random();
		length = r.nextInt(20) + 5;
		cap = r.nextInt(2) + 2;
		space = new Train[cap];
	}
	
}
