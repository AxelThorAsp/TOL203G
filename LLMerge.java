import edu.princeton.cs.algs4.*;


public class LLMerge {
  public static LLNode merge(LLNode a, LLNode b) {
    print(a);
    print(b);

    LLNode ret = new LLNode();
    LLNode last = ret;
    if (a == null && b == null) {
        return null;
    }

    if (a == null) {
      return b;
    }
    if(b == null) {
      return a;
    }

    while (a !=null && b!=null) {
    if (a.item.compareTo(b.item)<=0) {
      //
      last.next=a;
      last = last.next; // hoppum afram
      a = a.next; // hoppum afram i a listanum

    }
    else {
      last.next=b;
      last = last.next;
      b = b.next;
    }
  }
    if (b==null && a!= null) {
      last.next = a;
    } else if (a==null && b!=null) {
      last.next=b;
    } else {
      last.next = null;
    }

    return ret.next;
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
    //"" -> C -> null
    //B -> null
    n1.item ="";
    n2.item ="C";
    n3.item ="B";
    n1.next = n2;

    // er ret ""-B-C
    print(merge(n1,n3));
  }
}
