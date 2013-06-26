/**
 * 
 * @author Kaiven Zhou [kz2182]
 *
 */
import java.util.LinkedList;
import java.io.Serializable;
public class City implements Serializable
{
	private int id;
	private String name;
	private String state;
	private double latitude;
	private double longitude;
	
	private int inOut; //the in/out count
	private LinkedList<Edge> adj; //all the Citys this points to
	
	public City(int newId, String newName, String newState, double newLatitude, double newLongitude)
	{
		id = newId;
		name = newName;
		state = newState;
		latitude = newLatitude;
		longitude = newLongitude;
		
		inOut = 0;
		adj = new LinkedList<Edge>();
	}

	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getState()
	{
		return state;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public int getInOut()
	{
		return inOut;
	}
	
	public LinkedList<Edge> getAdj()
	{
		return adj;
	}
	
	public boolean hasIncoming()
	{
		//since adj.size() is the number of outgoing connections, 
		//then inOut == adj.size() means there are no incoming
		return (inOut != adj.size()); 
	}
	public void updateInOut(int delta)
	{
		inOut += delta;
	}
	
	public void addCity(City x, int weight)
	{
		adj.add(new Edge(x,weight));
		inOut++;
	}
	
	public boolean hasCity(int cityId)
	{
		for(int i = 0; i < adj.size(); i++)
		{
			if(adj.get(i).getEnd().getId() == cityId)
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		return String.format("id: %s\n"+"name: %s\n"+"state: %s\n"+"latitude: %s\n"+"longitude: %s\n"+"in/out: %s\n",
				id,name,state,latitude,longitude,inOut);
	}
}
