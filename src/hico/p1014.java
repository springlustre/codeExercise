package hico;
import java.util.*;
/**
 * Created by springlustre on 2017/5/2.
 */
public class p1014 {

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int m = Integer.parseInt(sc.nextLine());
    List<String> question = new ArrayList<String>();
    for(int i=0;i < m;i++){
      question.add(sc.nextLine());
    }
    int n = Integer.parseInt(sc.nextLine());
    List<String> answer = new ArrayList<String>();
    for(int j = 0; j < n; j++){
      answer.add(sc.nextLine());
    }

    List<Integer> res = new ArrayList<Integer>();
    TrieTree tree = new TrieTree();

    for(int j=0;j<question.size();j++){
      tree.insert(question.get(j));
    }

    for(int i=0;i<answer.size();i++){
      String ans = answer.get(i);
      int r = tree.findStartWith(ans);
      res.add(r);
    }
    for(int i=0;i<res.size();i++){
      System.out.println(res.get(i));
    }
  }
}

class TrieTree{
  private class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    char val;
    int prefixNum;
    public TrieNode(char val){
      this.val = val;
      this.isLeaf = false;
      this.prefixNum = 0;
    }
  }

  TrieNode root;
  public TrieTree(){
    root = new TrieNode(' ');
  }

  public void insert(String word){
    TrieNode cur = root;
    char[] data = word.toLowerCase().toCharArray();
    for(int i=0;i<data.length;i++){
      int index = data[i] - 'a';
      if(cur.children[index]==null){
        cur.children[index] = new TrieNode(data[i]);
      }
      cur = cur.children[index];
      cur.prefixNum++;
    }
    cur.isLeaf = true;
  }

  public int findStartWith(String s){
    TrieNode cur = root;
    char[] data = s.toLowerCase().toCharArray();
    for(int i = 0;i<data.length;i++){
      int index = data[i] - 'a';
      if(cur.children[index]==null){
        return 0;
      }
      cur = cur.children[index];
    }
    return cur.prefixNum;
  }

}