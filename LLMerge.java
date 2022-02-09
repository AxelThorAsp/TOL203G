import edu.princeton.cs.algs4.*;

public class LLMerge {
  public static LLNode merge(LLNode a, LLNode b) {
    LLNode ret = new LLNode();
    LLNode last = ret;

    if (a==null) {
      return b;
    }
    else if(b==null) {
      return a;
    }

    while (a !=null && b!=null) {
    if (a.item.compareTo(b.item)<=0) {
      //
      last.next=a;
      last = last.next; // hoppum afram
      a = a.next; // hoppum afram i a listanum
      last.next=null;
    }
    else {
      b = b.next;

    }
  }
    return ret;
  }
  public static void print(LLNode a) {
    while (a!=null) {
      StdOut.print(a.item + " -> ");
      a = a.next;
    }
    StdOut.println("");
  }

  public static void main(String[] args) {
    LLNode n1 = new LLNode();
    LLNode n2 = new LLNode();
    LLNode n3 = new LLNode();
    LLNode sus = new LLNode();
    //A -> C -> null
    //B -> null
    n1.item ="A";
    n2.item ="C";
    n3.item ="B";
    n1.next = n2;

    sus=n1;
    sus=sus.next;
    sus.next=null;

    print(sus);
    // er ret A-B-C

  }
}
