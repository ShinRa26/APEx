import java.util.*;

/**
 * Class for creating the Railway thread which will create a List of Track and Station objects
 * and use the TrainThread objects for simulating the Railway.
 * @author Graham Keenan 1105045
 *
 */
public class Railway extends Thread
{
	protected List<Segment> l;
	
	/*** Constructor ***/
	public Railway(Integer totSegs)
	{
		//Creates a new ArrayList of Segments to hold the Railway.
		l = new ArrayList<Segment>();
		
		//Loops through the given number (totSegs) to create the Railway, consisting of Station and Track objects.
		for(int i = 0; i < totSegs; i++)
		{
			//If the index is even, creates a new Station object.
			//If the index is odd, creates a new Track object.
			if(i % 2 == 0)
				l.add(new Station());
			else
				l.add(new Track());
		}
	}
	
	/**
	 * Run method for the Railway thread
	 */
	public void run()
	{
		//Thread will be continuously running, hence infinite loop.
		for(;;)
		{
			try
			{
				//Creates a new random number
				Random r = new Random();
				//Random number is between 1000 and 5000
				Integer wait = r.nextInt(5000) + 1000;
				//Thread sleeps for 1-5 seconds before adding a new Train object.
				Thread.sleep(wait);

				//If the first station is not full...
				if(!l.get(0).isFull())
				{
					//Creates a new Train object
					Train t = new Train();
					//Creates a new ThrainThread object, taking the Train and List as parameters.
					TrainThread tt = new TrainThread(t, l);
					//Sets the ID of the Train to its Thread ID in a String format.
					String trainId = "" + tt.getId();
					t.setId(trainId);
					//Adds the train to the first segment (Station)
					l.get(0).addTrain(t);
					//Starts the TrainThread thread.
					tt.start();
				}
				//If the first segment (Station) is full...
				else
				{
					//Alerts the user that it is full and prints out the IDs of the trains currently occupying it.
					System.out.println("Home station full...");
					for(int i = 0; i < l.get(0).space.length; i++)
						System.err.println("Train in home station: " + l.get(0).space[i].getId());
					
					//Creates a Display to show the status
					Display d = new Display(l);
					d.showStatus();
					
					//Thread sleeps for 2 seconds before trying again.
					Thread.sleep(2000);
				}
			}
			catch(InterruptedException e){}
		}
	}
	
	/*** Accessors ***/
	public List<Segment> getRailway(){return l;}
}
