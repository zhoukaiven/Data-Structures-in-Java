/*@author Kaiven Zhou kz2182
 * 
 * Node class taken from class lectures, with minor modifications
 * 
 */
public class ExpNode {

	private String value;
	private ExpNode left;
	private ExpNode right;
	
	public ExpNode(String newValue){
		value = newValue;
		left = right = null;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String newValue){
		value = newValue;
	}
	
	public ExpNode getLeft(){
		return left;
	}
	
	public ExpNode getRight(){
		return right;
	}
	
	public void setLeft(ExpNode b){
		left = b;
	}
	
	public void setRight(ExpNode b){
		right = b;
	}
	
	public String toString()
	{
		return value;
	}
}