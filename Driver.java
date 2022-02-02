import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Driver{

  public static void main(String[] args) {
    QuickFindUF uf = new QuickFindUF(10);
     while (!StdIn.isEmpty()) {
       int p = StdIn.readInt();
       int q = StdIn.readInt();
       if (!uf.connected(p,q)){
         uf.union(p,q);
         StdOut.print("Now connected: " + p + " ");
         StdOut.print(q +"\n" );
       }
     }
     
    StdOut.println(Arrays.toString(uf.getId()));
   }
 }
