import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class FindTri{

    private boolean containsInt(Iterable<Integer> it, int i){
        Iterator<Integer> itr = it.iterator();
        while (itr.hasNext()) {
            if(itr.next() == i){
                return true;
            }
        }
        return false;
    }

    public int countTri(Digraph dg){
        int count = 0;

        for (int i = 0; i < dg.V(); i++) {
            for (int q = 0; i < dg.V(); q++) {
                for (int j = 0; i < dg.V(); j++) {
                    if(containsInt(dg.adj(i),q) && containsInt(dg.adj(q),j) && containsInt(dg.adj(j), i)) count++;
                }
            }
        }
        return count/3;
    }

    public static void main(String[] args) {
        //test
        FindTri ft = new FindTri();
        Digraph dg = new Digraph(4);
        dg.addEdge(0,2);
        dg.addEdge(2,1);
        dg.addEdge(1,3);
        dg.addEdge(1,0);
        dg.addEdge(3,2);

        System.out.println(ft.countTri(dg));
    }
}