import edu.princeton.cs.algs4.*;
public class GraphArithmetic{


  //daemi
  //inn: calculate(dg,vv);

  //thar sem:
  //String[] values = {"+","3","2","1"};
  //Digraph dg = new Digraph(4);
  //dg.addEdge(0,1);
  //dg.addEdge(0,2);
  //dg.addEdge(0,3);

  //ut: 6.0

    public static boolean isNumeric(String strNum) {
      if (strNum == null) {
        return false;
      }
      try {
        double d = Double.parseDouble(strNum);
      }
      catch (NumberFormatException nfe) {
        return false;
      }
      return true;
    }

    private static double DFS(int vertex, String[] ops, Digraph dg){
      if (isNumeric(ops[vertex])) {
        return Double.parseDouble(ops[vertex]);
      }
      double result = Double.MAX_VALUE;

      for(int child : dg.adj(vertex)){
        switch (ops[vertex]) {
          case "*":
              if (result == Double.MAX_VALUE) {
                result = 1;
              }
              result *= DFS(child, ops, dg);
              break;
          case "+":
              if (result == Double.MAX_VALUE) {
                result = 0;
              }
              result += DFS(child, ops, dg);
              break;
          case "/":
              if (result == Double.MAX_VALUE) {
                result = DFS(child, ops, dg);
              }
              else{
                result /= DFS(child, ops, dg);
              }
              break;
          case "-":
              if (result == Double.MAX_VALUE) {
                result = DFS(child, ops, dg);
              }
              else{
                result -= DFS(child, ops, dg);
              }
              break;
          default:
              throw new IllegalArgumentException("No such operator " + ops[vertex]);
        }
      }
      ops[vertex] = String.valueOf(result);
      return result;
    }

    public static double calculate(Digraph dg, String[] vertexValues){
      DirectedCycle dc = new DirectedCycle(dg);
      if (dc.hasCycle()) {
        return -1;
      }
      int in = -1;

      for (int i = 0; i < dg.V(); i++ ) {
        if (dg.indegree(i) == 0) {
          in = i;
          break;
        }
      }
      return DFS(in,vertexValues, dg);
    }


    public static void main(String[] args) {
      String[] ops = {"+","+","/","*","2","3","4","5"};
      Digraph dg = new Digraph(8);
      dg.addEdge(0,1);
      dg.addEdge(0,2);
      dg.addEdge(1,4);
      dg.addEdge(1,3);
      dg.addEdge(3,5);
      dg.addEdge(3,6);
      dg.addEdge(2,7);
      dg.addEdge(2,3);

      System.out.println(calculate(dg,ops));


    }


}
