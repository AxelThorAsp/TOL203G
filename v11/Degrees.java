import edu.princeton.cs.algs4.*;

public class Degrees{
  private Digraph G;

  Degrees(Digraph G){
    this.G = G;
  }
  public int indegree(int v) {
    return G.indegree(v);
  }
  public int outdegree(int v) {
    return G.outdegree(v);
  }
  public Iterable<Integer> sources() {
    Bag<Integer> bg = new Bag<>();
    for (int i = 0;i < G.V() ;i++ ) {
      if (indegree(i) == 0) {
        bg.add(i);
      }
    }
    return bg;
  }

  public Iterable<Integer> sinks() {
    Bag<Integer> bg = new Bag<>();
    for (int i = 0;i < G.V() ;i++ ) {
      if (outdegree(i) == 0) {
        bg.add(i);
      }
    }
    return bg;
  }
  public boolean isMap() {
    for (int i = 0; i < G.V(); i++) {
      if (indegree(i) != 1) {
        return false;
      }
    }
    return true;
  }
}
