/*
 * @author Kaiven Zhou kz2182
 * 
 * Stack ADT implementation using an ArrayList, and an int to keep track of the top of the list.
 */
import java.util.ArrayList;

public class Stack<T>
{
	private ArrayList<T> stk;
	int top; //index of the empty spot "above" the top of the stack i.e. where the next element added will go
	
	/*
	 * Constructs empty stack 
	 */
	public Stack()
	{
		stk = new ArrayList<T>();
		top = 0;
	}
	/*
	 * Returns and removes the top of the stack
	 * @return top of the stack
	 */
	public T pop()
	{
		//my int top is the index of where the next element added will go. 
		//Hence, the actual top of the stack is at index top - 1
		T tmp = stk.get(top-1);
		stk.remove(top-1);
		top--;
		return tmp;
	}
	/*
	 * Adds a value to the top of the stack
	 * @param value, the value to add
	 */
	public void push(T value)
	{
		stk.add(top, value);
		top++;
	}
}
