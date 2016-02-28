/**
 * Class for starting the program
 * @author Graham Keenan 1105045
 *
 */
public class Runme 
{
	/**
	 * Main method for starting the program
	 * @param args The arguments
	 */
	public static void main(String[] args)
	{
		//Creates a new Railway object of N segments (CHANGE THE VALUE TO WHAT YOU DESIRE)
		Railway r = new Railway(5);
		//Starts the Railway thread.
		r.start();
	}
}
