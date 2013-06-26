/**
 * @author Kaiven Zhou
 *
 * @param <AnyType> the type of the node
 * 
 * The node class. Has data, a count, and the next node.
 */
public class Node<AnyType>
{
	/**
	 * Creates a Node
	 * @param d the data
	 * @param n the next node
	 */
    public Node( AnyType d, Node<AnyType> n )
    {
        data = d;
        next = n;
        count = 1;
    }
    
    private AnyType data; //the data stored
    private Node<AnyType> next; //the next node 
    private int count; //the count of the data
    
    /**
     * @return true if there is a next node, false if the next node is null
     */
    public boolean hasNext()
    {
    	return (next != null);
    }
    /**
     * @return the next node
     */
    public Node<AnyType> getNext()
    {
    	return next;
    }
    /**
     * Set the next node
     * @param n the next node
     */
    public void setNext(Node<AnyType> n)
    {
    	next = n;
    }
    /**
     * @return the data
     */
    public AnyType getData()
    {
    	return data;
    }
    /**
     * Set the data of the node
     * @param newData the data
     */
    public void setData(AnyType newData)
    {
    	data = newData;
    }
    /**
     * @return the count of the node
     */
    public int getCount()
    {
    	return count;
    }
    /**
     * Set the count of the node
     * @param newCount
     */
    public void setCount(int newCount)
    {
    	count = newCount;
    }
    /**
     * Change the count by some number
     * @param delta the amount to change the count by
     */
    public void changeCount(int delta)
    {
    	count += delta;
    	if(count < 0)
    		count = 0;
    }
    /**
     * @return the node data and count
     */
    public String toString()
    {
    	 return String.format("%s:%s",data,count);
	}
}