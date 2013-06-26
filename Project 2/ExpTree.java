/* @author Kaiven Zhou (kz2182)
 * 
 * An expression tree has methods to print the prefix, infix, and postfix traversal of the tree,
 * as well as a method to evaluate the result of the original tree.
 */

public class ExpTree 
{
	private ExpNode root;
	
	/*
	 * Constructs an empty tree
	 */
	public ExpTree()
	{
		root = null;
	}
	/*
	 * Constructs a tree, with the root having value = data.
	 * @param data, the 
	 */
	public ExpTree(String data)
	{
		root = new ExpNode(data);
	}
	/*
	 * @return the root of the tree
	 */
	public ExpNode getRoot()
	{
		return root;
	}
	/*
	 * Prints the pre-order traversal of the tree
	 */
	public void prefix()
	{
		System.out.print("prefix: ");
		prefixHelp(root);
		System.out.println();
	}
	/*
	 * Recursively prints the preorder traversal of a given tree
	 * @param parent, the root of the subtree currently being examined 
	 */
	private void prefixHelp(ExpNode parent)
	{
		//print the parent's value
		System.out.print(parent.toString() + ' ');
		
		if(parent.getLeft() != null) //if the left subtree exists, print its preorder traversal
			prefixHelp(parent.getLeft());
		if(parent.getRight() != null) //if the right subtree exists, print its preorder traversal
			prefixHelp(parent.getRight());
	}
	/*
	 * Prints the in-order traversal of the tree
	 */
	public void infix()
	{
		System.out.print("infix: ");
		infixHelp(root);
		System.out.println();
	}
	/*
	 * Recursively prints the inorder traversal of a given tree
	 * @param parent, the root of the subtree currently being examined
	 */
	private void infixHelp(ExpNode parent)
	{
		boolean isOperator = false;
		try //if the parent's value is an integer
		{ 
			Integer.parseInt(parent.getValue());
			isOperator = false;
		}
		catch(NumberFormatException e) //exception caught when the parent's value is an operator
		{
			isOperator = true;
		}
		
		if(isOperator) //print a left bracket if the parent's value is an operator
			System.out.print("(");
		if(parent.getLeft() != null) // if the left subtree exists, print the inorder traversal of the left subtree
			infixHelp(parent.getLeft());
		
		System.out.print(parent.toString()); //print the parent's value
		
		if(parent.getRight() != null) //if the right subtree exists, print the inorder traversal of the right subtree
			infixHelp(parent.getRight());
		if(isOperator) //print a right bracket if the parent's value is an operator
			System.out.print(")");
	}
	/*
	 * Prints the post-order traversal of the tree
	 */
	public void postfix()
	{
		System.out.print("postfix: ");
		postfixHelp(root);
		System.out.println();
	}
	/*
	 * Recursively prints the post-order traversal of a given tree
	 * @param parent, the root of the subtree currently being examined
	 */
	private void postfixHelp(ExpNode parent)
	{
		if(parent.getLeft() != null) //if the left subtree exists, print its post-order
			postfixHelp(parent.getLeft());
		if(parent.getRight() != null) //if the right subtree exists, print its post-order
			postfixHelp(parent.getRight());
		
		System.out.print(parent.toString() + ' '); //print the parent's value
	}
	/*
	 * Evaluates the result of the tree. Prints an error message if an arithmetic exception is thrown.
	 */
	public void result()
	{
		try
		{
			System.out.println("result: " + resultHelp(root));
		}
		catch(ArithmeticException e)
		{
			System.out.println("result: ARITHMETIC ERROR (probably division by zero).");
		}
	}
	public int resultHelp(ExpNode parent)
	{
		//if the parent's value is an operator, perform the operation using the results of the left and right subtrees
		switch(parent.getValue())
		{
			case "+": 
				return resultHelp(parent.getLeft()) + resultHelp(parent.getRight());
			case "-": 
				return resultHelp(parent.getLeft()) - resultHelp(parent.getRight());
			case "*": 
				return resultHelp(parent.getLeft()) * resultHelp(parent.getRight());
			case "/": 
				return resultHelp(parent.getLeft()) / resultHelp(parent.getRight());
			default: 
				return Integer.parseInt(parent.getValue()); //if the parent's value is not an operator, it must be an integer
		}
	}
}
