//Written by Tyler Holland and Spencer Ellsworth
public class BinaryNode<AnyType>
{
	BinaryNode (AnyType theElement)
	{
		this(theElement, null, null);
	}
	
	BinaryNode (AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt)
	{
		nodeData = theElement;
		left = lt;
		right = rt;
	}
	
	AnyType nodeData;
	BinaryNode<AnyType> left;
	BinaryNode<AnyType> right;
}
