public class LLNode {
  public String item;
  public LLNode next;




  public static void main(String[] args) {
    LLNode ret = new LLNode();
    LLNode last = ret;
    LLNode next = new LLNode();

    last.next=next;

    last.item="A";
    last = last.next;
    last.item="B";
    LLMerge.print(ret);
    LLMerge.print(last);
  }
}
