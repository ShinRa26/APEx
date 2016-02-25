import java.util.*;

public class Display 
{
	private List<Segment> l;
	
	/* Constructor */
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
		String trainLine = "";
		String segment = "";
		
		for(int i = 0; i < l.size(); i++)
		{
			if(i%2 == 0)
				segment = "|----Station------|";
			else
				segment = "|----Track------|";
			
			for(;;)
			{
				trainLine+=segment;
				break;
			}
		}
		
		return trainLine;
	}
}
