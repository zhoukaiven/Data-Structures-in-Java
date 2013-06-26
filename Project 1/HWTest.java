/**
 * @author Kaiven Zhou (kz2182)
 */
import java.util.*;
import java.io.*;
public class HWTest {
	public static void main(String[] args) 
	{
		try
		{
			MyCountingLinkedLists<String> test = new MyCountingLinkedLists<String>();
			Scanner scanner = new Scanner(new File("ip_list.txt"));
			
			String ip="";
	        while (scanner.hasNextLine()) {
	            ip = scanner.nextLine();
	            test.insert(ip);
	        }
	        scanner.close();
	        test.print(5,false);
	        test.sort(); //sorts list
	        
	        Scanner getInput = new Scanner(System.in);
	        System.out.println("Print top ___ :");
	        int howMany = getInput.nextInt();
			test.print(howMany,false); //prints the %s
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
