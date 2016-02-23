
public abstract class Segment 
{
	protected Integer length;
	protected Integer cap;
	protected Train[] occupied;
	
	abstract boolean isFull();
	abstract Train[] addTrain(Train t);
}
