import java.util.*;

/**
 * Class extending the Segment abstract class for creating Station objects
 * @author Graham Keenan 1105045
 *
 */
public class Station extends Segment
{
	/*** Constructor ***/
	public Station()
	{
		//Generates a new random number for length and capacity of the Station.
		Random r = new Random();
		//Lenght is anyehere between 5 and 20.
		length = r.nextInt(20) + 5;
		//Capacity is anywhere between 2 and 4.
		cap = r.nextInt(2) + 2;
		//Instantiates the array with the capacity.
		space = new Train[cap];
	}
	
}
