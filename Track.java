import java.util.*;

/**
 * Class extending the Segment abstract class for creating Track objects
 * @author Graham Keenan 1105045
 *
 */
public class Track extends Segment
{
	/*** Constructor ***/
	public Track()
	{
		//Generates a new random number for the length of the Track
		Random r = new Random();
		//Length is anywhere between 100 and 250
		length = r.nextInt(250) + 100;
		//Track can only have one Train in it at a time so is set equal to 1.
		cap = 1;
		//Instantiates the array with the capacity.
		space = new Train[cap];
	}
	
}
