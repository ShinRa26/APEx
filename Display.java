import java.util.*;

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

		
		for(int i = 0; i < l.size(); i++)
		{
			String[] id = {"-","-","-","-"};
			
			if(i % 2 == 0)
			{
				for(int j = 0; j < l.get(i).space.length; j++)
				{
					if(l.get(i).space[j] != null)
						id[j] = l.get(i).space[j].getId();
				}
				
				segment = String.format("|----Station--%s%s%s%s|", id[0],id[1],id[2],id[3]);
			}
			else
			{
				for(int j = 0; j < l.get(i).space.length; j++)
				{
					if(l.get(i).space[j] != null)
						id[j] = l.get(i).space[j].getId();
				}
				segment = String.format("|----Track--%s%s%s%s|", id[0],id[1],id[2],id[3]);
			}
			
			status += segment;
		}
		System.out.println(status);
		return status;
	}
}
