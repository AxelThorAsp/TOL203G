public class BSTNode{
	public String key;
	public BSTNode left, right;


	public BSTNode(String key){
		this.key = key;

	}

	public static String toString(BSTNode x){
		return x.key;
	}
}
