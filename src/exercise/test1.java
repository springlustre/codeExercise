package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by springlustre on 2017/3/29.
 */
public class test1 {
  public static void main(String args[]){
//    Scanner sc = new Scanner(System.in);
//    while(sc.hasNext()){
//      int num = sc.nextInt();
//      List<Integer> list = new ArrayList<Integer>();
//      for(int i = 0; i < num; i++){
//        list.add(sc.nextInt());
//      }
//      int res = getRes(list);
//      System.out.println(res);
//    }

    Scanner s = new Scanner(System.in);
    while (true) {
      String line = s.nextLine();
      if (line.equals("exit")) break;
      System.out.println(">>>" + line);
    }

    while(s.hasNextLine()){
      String a = s.nextLine();
      String b = s.nextLine();
      String c = s.nextLine();
      System.out.println(a+b+c);
    }

  }
  public static int getRes(List<Integer>list){
    int i = 0;
    int total = list.size();
    int odd = 0;
    while(i >=0 && i < total){
      if((list.get(i) & 1)==1) odd++;
      i++;
    }
    return Math.abs(total-odd-odd);
  }
}
