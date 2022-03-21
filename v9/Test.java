import edu.princeton.cs.algs4.*;
import java.util.*;

public class Test{
  public static void main(String[] args) {
  Bag<Integer> bag = new Bag<>();
  bag.add(4);
  bag.add(2);
  bag.add(3);
  Iterator<Integer> itr = bag.iterator();
  while(itr.hasNext()){
    System.out.println(itr.next());
  }
  for (Integer i : bag ) {
    System.out.println(i);
  }
  }
}
