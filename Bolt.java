public class Bolt extends NutBolt {
  public Bolt(int v) {
    super(v);
  }
  
  public int compareTo(NutBolt o) {
    try {
      Nut n = (Nut) o;
      return value - n.value;
    } catch (Exception e) {
      throw new ClassCastException();
    }
  }
}
