public class Nut extends NutBolt {
  public Nut(int v) {
    super(v);
  }

  public int compareTo(NutBolt o) {
    try {
      Bolt b = (Bolt) o;
      return b.value - value;
    } catch (Exception e) {
      throw new ClassCastException();
    }
  }
}
