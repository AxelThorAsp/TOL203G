import edu.princeton.cs.algs4.*;
import java.util.Scanner;
import java.io.*;

 @SuppressWarnings("unchecked")
public class TimeTest {

  public static void warTest(BST obj, String[] words){
    Stopwatch s = new Stopwatch();
    for (int i = 0 ;i < 10 ;i++ ) {
      for (String word : words) {
        obj.put(word,69);
      }
    }
    System.out.println("BST: " + s.elapsedTime());
  }
  public static void warTest(RedBlackBST obj, String[] words){
    Stopwatch s = new Stopwatch();
    for (int i = 0 ;i < 10 ;i++ ) {
      for (String word : words) {
        obj.put(word,69);
      }
    }
    System.out.println("RedBlackBST" + s.elapsedTime());
  }
  public static void warTest(SeparateChainingHashST obj, String[] words){
    Stopwatch s = new Stopwatch();
    for (int i = 0 ;i < 10 ;i++ ) {
      for (String word : words) {
        obj.put(word,69);
      }
    }
    System.out.println("SeparateChainingHashST" + s.elapsedTime());
  }
  public static void warTest(LinearProbingHashST obj, String[] words){
    Stopwatch s = new Stopwatch();
    for (int i = 0 ;i < 10 ;i++ ) {
      for (String word : words) {
        obj.put(word,69);
      }
    }
    System.out.println("LinearProbingHashST"  +s.elapsedTime());
  }

  public static void main(String[] args) {
    BST<String, Integer> bst = new BST();
    RedBlackBST<String, Integer> rbbst = new RedBlackBST();
    SeparateChainingHashST<String, Integer> schst = new SeparateChainingHashST();
    LinearProbingHashST<String, Integer> lphst = new LinearProbingHashST();
    try {
      File tale = new File("war+peace.txt");
      Scanner sc = new Scanner(tale);

      while (sc.hasNext()) {
        String word = sc.next();
        bst.put(word,69);
        rbbst.put(word,69);
        schst.put(word,69);
        lphst.put(word,69);
      }
      String[] allWords = StdIn.readAllStrings();
      warTest(bst, allWords);
      warTest(rbbst, allWords);
      warTest(schst, allWords);
      warTest(lphst, allWords);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
