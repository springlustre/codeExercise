package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by springlustre on 2017/4/8.
 */
public class wordNet {
  public static int getDistance(String s1,String s2,HashMap<String,
    ArrayList<String>> map, int distance,ArrayList<String> arr,int res){
    if(map.containsKey(s1)) { // 如果包含s1
      ArrayList list = map.get(s1); //s1的值list
      if (list.contains(s2)) {  //如果包含s2，则返回距离加一
        int d = distance+1;
        if (res > d || res == 0) {
          res = d;
        }
        return res;
      } else {
        arr.add(s1); //将遍历过的键保存
        for (int i = 0; i < list.size(); i++) {  //对s1的值list遍历
          String a = (String) list.get(i);
          if (!arr.contains(a)) {
            int d = getDistance(a, s2, map, (distance + 1), arr, res);
            if (res > d || res == 0) {
              res = d;
            }
          }
        }
        return res;
      }
    }else{
      return res;
    }
  }


  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    map.put("a",new ArrayList<String>(){{add("b");add("c");add("d");}});
    map.put("b",new ArrayList<String>(){{add("a");add("e");}});
    map.put("c",new ArrayList<String>(){{add("a");add("b");}});
    map.put("d",new ArrayList<String>(){{add("a");add("b");}});
    map.put("e",new ArrayList<String>(){{add("b");add("f");}});

    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      String s1 = sc.next();
      String s2 = sc.next();
      if(map.containsKey(s1)){
        int a = getDistance(s1,s2,map,0,new ArrayList<String>(),0);
        System.out.println(a);
      }else{
        System.out.println("not exist!");
      }
    }

  }

}
