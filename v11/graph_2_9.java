import edu.princeton.cs.algs4.*;
public class graph_2_9{
//Write a method that checks whether or not a given permutation of a DAG’s vertices
//is a topological order of that DAG.
    private static boolean contains(Integer[] arr, int index, int elem) {
      for (int i = index;i < arr.length ;i++ ) {
        if (arr[i]==elem) {
          return true;
        }
      }
      return false;
    }
    public static boolean checkOrder(Digraph dg, Integer[] topologicalOrder){
      DirectedCycle dc = new DirectedCycle(dg);
      if (dc.hasCycle()) {
        return false;
      }

      //if (dg.V() != topologicalOrder.length) {
        //return false;
      //}
      int len = topologicalOrder.length;
      for (int i = 0;i < len ;i++ ) {
        if (dg.outdegree(topologicalOrder[i]) > 0 ) {
          for (int v : dg.adj(topologicalOrder[i])) {
            if (!contains(topologicalOrder,i,v)) {
              return false;
            }
          }
        }
      }
        return true;
    }

    public static void main(String[] args) {
      In in = new In(args[0]);
      Digraph dg = new Digraph(in);
      System.out.println(dg.toString());
      Integer[] arr = {5,4,3,2,1,0};
      System.out.println(checkOrder(dg,arr));
    }
}
