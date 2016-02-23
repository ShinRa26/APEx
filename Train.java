import java.util.*;

public class Train extends Thread
{
	private Integer speed;
	private String type;
	
	/* Constructor */
	public Train()
	{
		Random r = new Random();
		speed = r.nextInt(100) + 1;
		
		if(speed >= 50)
			type = "Express";
		else
			type = "Local";
	}
	
	
	/**
	 * Run method for Train thread
	 * !!!MAY NEED MORE INFO IN IT LIKE AN ACTUAL FUCKING TRAIN!!!
	 */
	public void run()
	{
		try
		{
			Train t = new Train();
			System.out.println(getName() + " created.");
			Random r = new Random();
			Integer wait = r.nextInt(5000);
			Thread.sleep(wait);
		}
		catch(InterruptedException e){}
	}
	
	public Integer getSpeed(){return speed;}
	public String getType(){return type;}
}
