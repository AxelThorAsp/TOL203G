import edu.princeton.cs.algs4.*;
import java.util.*;

public class Graph{

  public boolean hasEdge(int v, int w){
    Iterator itr = adj[v].iterator();
    while (itr.hasNext()) {
      if (itr.next() == w) {
        return true;
      }
    }
    return false;
  }
}
