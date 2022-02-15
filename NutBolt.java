public class NutBolt implements Comparable<NutBolt> {
    protected int value;
    protected NutBolt(int v) {
      this.value = v;
    }

    public int compareTo(NutBolt o) {
      throw new ClassCastException();
    }
}
