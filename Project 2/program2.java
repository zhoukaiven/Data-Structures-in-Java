import java.util.StringTokenizer;

public class program2 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(args[0]); //split the input into tokens, where each token is an integer or operator 
		Stack<ExpTree> stk = new Stack<ExpTree>();
		
		String tmp;
		while (st.hasMoreTokens())
		{
			tmp = st.nextToken();
			try //if the token is an integer, then we push the integer onto the stack
			{
				Integer.parseInt(tmp);
				stk.push(new ExpTree(tmp));
			}
			catch(NumberFormatException e) //if the token is an operator, attempting to convert it to an integer throws an exception
			{
				//Operator is the root of a new tree. The first pop is the right tree, and the 2nd is the left tree.
				//This new tree is then pushed back onto the stack
				ExpTree operator = new ExpTree(tmp);
				operator.getRoot().setRight(stk.pop().getRoot()); 
				operator.getRoot().setLeft(stk.pop().getRoot());
				stk.push(operator);
			}
		}
		
		ExpTree test = stk.pop();
		
		test.prefix();
		test.infix();
		test.postfix();
		test.result();
	}
}
