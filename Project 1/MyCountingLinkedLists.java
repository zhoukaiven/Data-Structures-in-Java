/* @author Kaiven Zhou (kz2182)
 * 
 * A singly linked list with a sort, insert, delete, reverse
 * Code (very loosely) modified from the code posted on Courseworks
 * 
 */
import java.util.*;
public class MyCountingLinkedLists<AnyType>
{
	private int theSize; //number of ip's kept in the list
    private Node<AnyType> first; //the first node
    
    /**
     * Constructs an empty singly linked list
     */
	public MyCountingLinkedLists()
	{
		first = null;
		theSize = 0;
	}
	
	/**
	 * Increases the count of node with value x, or prepends a new node with value x
	 * @param x, the value to search for
	 */
	public void insert(AnyType x)
	{	
		theSize++;								//the number of ip's is guaranteed to increase by 1
		if(first == null) 						//if the list is empty, we take the data and create a new node
		{
			first = new Node(x,null);
			return;
		}
		else 									//otherwise, the list is not empty
		{
			Node<AnyType> current = first; 		//starting from the first node
			while(current != null)				//we iterate through all nodes
			{
				if(current.getData().equals(x)) //if the data is found, we increase the count of the node and end the method
				{
					current.changeCount(1);
					return;	
				}
				current = current.getNext();   //otherwise we move on
			}
			first = new Node(x, first); 		//if the data has not been found, we add a new node to the beginning of the list
												//which points to the previous first node in the list
		}	
	}
	
	/**
	 * Decreases the count of node with value x, or throws an exception.
	 * If a node's count is reduced to zero, the node is removed from the list.
	 * 
	 * @param x the value to search for
	 * @throws MYLLException States that the value is not in the list
	 */
	public void delete(AnyType x) throws MYLLException
	{
		Node<AnyType> prev = null;					//we keep track of the previous node incase the current node needs to be deleted
		Node<AnyType> current = first;
		
		while(current != null)
		{
			if(current.getData().equals(x))			//if the current node has the data
			{
				current.changeCount(-1);			//we decrease the node's count by 1
				if(current.getCount() == 0)			//if a node's count goes to zero, it will be removed
				{
					if(prev != null)				 //means we are not at the first node, so we can just delete this node
						prev.setNext(current.getNext());
					else 							//means current is the first node
						first = current.getNext(); 	//so we reset the first node to be the 2nd on the list
					
					theSize--;						//number of ip's in the list decreases by exactly 1
				}
				return;
			}
			prev = current;							//otherwise we update the previous node and current node
			current = current.getNext();
			
		}
		throw new MYLLException("Value not in list."); //if we reach here, then the data has not been found and an exception is thrown
	}
	/**
	 * Returns the index of the node with value x, or -1 if the node is not found.
	 * @param x
	 * @return index of the node with value x, or -1 if not found
	 */
	public int find(AnyType x)
	{
		int index = 0;						//the first node has zeroth index
		Node<AnyType> current = first;
		while(current != null)
		{
			if(current.getData().equals(x)) //if we find the node with the data, we return the index
			{
				return index;
			}
			current = current.getNext();   	//otherwise increment the index, and nove to the next node
			index++;
		}
		return -1;							//data not found
	}
	/**
	 * Reverses the list
	 */
	public void reverse()
	{
		Node<AnyType> storeNext;			//we store next
		Node<AnyType> prev = null;			//and the previous nodes	
		
		Node<AnyType> current = first;
		while(current != null)				//for every node in the list
		{
			storeNext = current.getNext();	//we store the next node in the list
			current.setNext(prev);			//set the next node to the previous in the list
			prev = current;					//store the current node as the new previous
			current = storeNext;			//and move on to the next node in the list
		}
		first = prev; 						//after running through the entire list, the last thing current is set to is null 
											//(after the originally-last-but-now-first element in the list), so prev is the 
											//location of the actual first node in list
	}
	/**
	 *bubble sorts the list into descending order
	 */
	public void sort() //
	{
		if(first != null)
		{
			boolean done = false;
			Node<AnyType> next = null;
			Node<AnyType> current = first;
			
			while(!done)									//keep sorting until the list is sorted into descending order
			{
				done = true;
				while(current.hasNext())					//while there are still adjacent nodes to compare
				{
					next = current.getNext();				//we look at the current and next nodes

					if(next.getCount() > current.getCount())  //if the next node has a greater count than the current
					{
						AnyType tempData = current.getData(); //we switch the data in the two nodes
						int tempCount = current.getCount();
						
						current.setData(next.getData());
						current.setCount(next.getCount());
						
						next.setData(tempData);
						next.setCount(tempCount);
						
						done = false;						  //a change has been made, meaning the list may not be in order
					}
					current = current.getNext();
				}
			}
		}
		else
			return;
	}
	/**
	 * Prints the entire list out
	 * @param printCount true if the number of times an ip appears should print. false if the % is printed
	 */
	public void print(boolean printCount)
	{
		//note that theSize (which is the number of ip's) is always greater than or equal to the number of nodes in the list
		//therefore the print method will always return the entire list
		print(theSize, printCount); 
	}
	
	/**
	 * Prints out the items that appear the most
	 * @warning the list should be sorted beforehand
	 * @param howMany the top how many nodes should be printed
	 * @param printCount true if the number of times an ip appears should print. false if the % is printed
	 */
	public void print(int howMany, boolean printCount)
	{
		Node<AnyType> current = first;
		while(howMany > 0 && current != null) //while we stil need to print out values
		{
			if(printCount)	//print the node value, formatting based on the boolean printCount: true prints count, false prints %s
				System.out.println(current.toString() + " " + current.getCount());
			else
			{
				double percent = 100*((double) current.getCount())/theSize;
				System.out.println(String.format(current.toString()+" %f",percent)+"%");
			}
			howMany--;
			current = current.getNext();  //move on to next node
		}
		System.out.println();
	}
}
