import edu.princeton.cs.algs4.StdOut;

public class LLUtils {
  public static LLNode removeLast(LLNode first) {
  if (first == null){
    return null;
  }

  if (first.next==null){
    first = null;
    return null;
  }

  LLNode x;
  for (x=first; x.next.next !=null; x=x.next){}
    //thegar for lykkjan er buin tha er x naest sidasta stakid
    //999->1000
    LLNode sidast = x.next;
    x.next = null; //klippum a tengingu
  return first;
}

//Heimadaemi autograder
public static LLNode findLast(LLNode first, String st){
  LLNode last=null;
  //LLNode x;
  for(LLNode x=first ;x != null;x=x.next){
    if (x.item.equals(st)){
      last=x;
    }
  }
    return last;
}

private static void printList(LLNode first) {
    for (LLNode x = first; x != null; x = x.next) {
      StdOut.print(x.item);
      if (x.next != null) {
        StdOut.print(" --> ");
      }
    }
    StdOut.print("\n");
  }

  public static void main(String[] args) {
    LLNode n1 = new LLNode();
    LLNode n2 = new LLNode();
    LLNode n3 = new LLNode();
    n1.item = "1";

    n2.item = "2";
    n3.item = "3";


    n2.next = n3;
    n1.next = n2;




    System.out.println(n2.next.item);
    printList(n1);
    LLNode ret = removeLast(n1);
    printList(ret);
  }
}
