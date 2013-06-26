/**
 * @author Kaiven Zhou [kz2182]
 *
 */
import java.io.*;
public class main {

	public static void main(String[] args) {
		
		String choice;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Graph graph = new Graph();

		while(true)
		{
			choice = "";
			System.out.println("a. Load a text file into the system");
			System.out.println("b. load a graph from a file called mygraph.bin");
			System.out.println("c. save current graph to file called mygraph.bin");
			System.out.println("d. Search for state and list all cities of that state with the in/out counts for each");
			System.out.println("e. Search for city and display some information about it. (gps and in/out count)");
			System.out.println("f. Set City X as current (X is between 0-N cities)");
			System.out.println("g. print current city");
			System.out.println("h. Find n closest cities to current city using gps distances");
			System.out.println("i. Find all cities from current city with directed edge costs less than Y");
			System.out.println("j. Find shortest path between current and some target city");
			System.out.println("k. quit");
			System.out.print("Your choice: ");
			try
			{
				choice = in.readLine();
			}
			catch(IOException e)
			{
				System.out.println("Please input valid data.");
				e.printStackTrace();
				break;
			}

			try
			{
				if(choice.equals("a"))
				{
					System.out.print("File name?: ");
					graph.load(in.readLine());
				}
				else if(choice.equals("b"))
				{
					graph.loadBin();
				}
				else if(choice.equals("c"))
				{
					graph.save();
				}
				else if(choice.equals("d"))
				{
					System.out.print("State?: ");
					graph.searchState(in.readLine());
				}
				else if(choice.equals("e"))
				{
					System.out.print("City?: ");
					graph.searchCity(in.readLine());
				}
				else if(choice.equals("f"))
				{
					System.out.print("City ID?: ");
					graph.setCurrent(Integer.parseInt(in.readLine()));
				}
				else if(choice.equals("g"))
				{
					graph.showCurrent();
				}
				else if(choice.equals("h"))
				{
					System.out.print("How many?: ");
					graph.gpsClosest(Integer.parseInt(in.readLine()));
				}
				else if(choice.equals("i"))
				{
					System.out.print("Threshold?: ");
					graph.closest(Integer.parseInt(in.readLine()));
				}
				else if(choice.equals("j"))
				{
					System.out.print("City ID?: ");
					graph.shortest(Integer.parseInt(in.readLine()));
				}
				else if(choice.equals("k"))
				{
					System.out.print("Goodbye!");
					break;
				}
			}
			catch(IOException e)
			{
				System.out.println("Please input valid data.");
				e.printStackTrace();
				break;
			}
		}
		
	}

}
