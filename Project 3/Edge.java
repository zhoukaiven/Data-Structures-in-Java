/**
 * @author Kaiven Zhou [kz2182]
 *
 */
public class Edge 
{
	private City end;
	private int weight;
	
	public Edge(City end, int weight)
	{
		this.end = end;
		this.weight = weight;
	}
	
	public City getEnd()
	{
		return end;
	}
	public int getWeight()
	{
		return weight;
	}
}
