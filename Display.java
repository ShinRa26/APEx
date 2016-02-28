import java.util.*;

/**
 * Class for creating Display objects that will show the status of the Railway
 * @author Graham Keenan 1105045
 *
 */
public class Display 
{
	private List<Segment> l;
	
	/*** Constructor ***/
	public Display(List<Segment> l)
	{
		this.l = l;
	}
	
	/**
	 * Method to show the status of the Railway. What trains are in what segments etc.
	 * @return a String that shows the status.
	 */
	public String showStatus()
	{
		String status = "";
		String segment = "";

		//Loops through the given List.
		for(int i = 0; i < l.size(); i++)
		{
			//String array to hold the positions within the segment.
			String[] id = {"-","-","-","-"};
			
			//If the index is even (Station)...
			if(i % 2 == 0)
			{
				//Loops through the segment's Train array
				for(int j = 0; j < l.get(i).space.length; j++)
				{
					//If the index of the train array is not null, set the index of the id array to equal the train's ID.
					if(l.get(i).space[j] != null)
						id[j] = l.get(i).space[j].getId();
				}
				
				//Formats the string to give the train's occupying the segment.
				segment = String.format("|----Station--%s%s%s%s|", id[0],id[1],id[2],id[3]);
			}
			//If the index is odd (Track)...
			else
			{
				//Loops through the segment's train array
				for(int j = 0; j < l.get(i).space.length; j++)
				{
					//If the index of the train array is not null, set the index of the id array to equal the train's id.
					if(l.get(i).space[j] != null)
						id[j] = l.get(i).space[j].getId();
				}
				
				//Formats the string to give the trains occupying the segment
				segment = String.format("|----Track--%s%s%s%s|", id[0],id[1],id[2],id[3]);
			}
			
			//Concatenates the segment to the status string
			status += segment;
		}
		
		//Prints out the status of the Railway to the console.
		System.out.println(status);
		
		//returns the status.
		return status;
	}
}
