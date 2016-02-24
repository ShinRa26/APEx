import java.util.*;

public class Display 
{
	private List<Segment> l;
	
	public Display(List<Segment> l)
	{
		this.l = l;
	}
	
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
