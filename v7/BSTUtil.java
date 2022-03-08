import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.*;
public class BSTUtil {
   public static BSTNode min(BSTNode x)
   {
      if (x == null) { return null; }
      if (x.left == null) { return x; }
      return min(x.left);
   }

   public static BSTNode secondMin(BSTNode x)
   {

      if (x == null) { return null; }
      if (x.left == null) { return min(x.right); }

      BSTNode temp = x;
      while (temp.left.left != null)
      {
         temp = temp.left;
      }
      if (temp.left.right != null)
      {
         return min(temp.left.right);
      }
      return temp;
   }
}
