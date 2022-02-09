public class LLNode {
  public String item;
  public LLNode next;


  public static void main(String[] args) {
    LLNode n1 = new LLNode();
    LLNode n2 = new LLNode();
    LLNode n3 = new LLNode();

    LLNode ret = new LLNode();
    n1.item = "A";
    n2.item = "B";
    n3.item = "C";

    ret=n1;
    n1.next = n2;
    n2.next = n3;

    System.out.println(ret.next.item);
    System.out.println(n1.next.item);
  }
}
