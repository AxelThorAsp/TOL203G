import edu.princeton.cs.algs4.*;

public class Card extends Comparable <Card>{
  private int suit;
  private int rank;
  Card(int suit, int rank){
    this.suit=suit;
    this.rank=rank;
  }
  public int compareTo(Card c){
    if (suit<c.suit){
      return -1;
    }
    if (suit>c.suit){
      return 1;
    }
    if (suit==c.suit) {
      if (rank==1) {
        if (c.rank>1) {
          return -1;
        }
        else if (c.rank<1) {
          return 1;
        }
        else {
          return 0;
        }
      }
      if (rank<c.rank) {
          return 1;
      }
      else if (rank>c.rank) {
        return -1;
      }
        return 0;
      }
    return 0;}


  public static void main(String[] args) {
    //test
    Card c1 = new Card(2,2);
    Card c2 = new Card(1,1);

  }
}
