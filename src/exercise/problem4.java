package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by springlustre on 2017/3/31.
 */
public class problem4 {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()) {
      String input = sc.nextLine();
      List<Integer> power = new ArrayList<Integer>();
      power.add(0);
      for (int i = 0; i < input.length(); i++) {
        String s = String.valueOf(input.charAt(i));
        if (s.equals("(")) {
          int pLast = power.get(power.size() - 1);
          if (pLast < 0) {
            power.add(1);
          } else {
            power.add(pLast + 1);
          }
        }

        if (s.equals(")")) {
          int pLast = power.get(power.size() - 1);
          power.add(pLast - 1);
        }
      }

      int pLast = power.get(power.size() - 1);
      boolean flag = false;
      if (pLast == 0) {
        System.out.print("0 0");
      } else if (pLast < 0) {
        flag = true;
      } else {
        flag = false;
      }

      int aim = 0;
      for (int j = 0; j < power.size(); j++) {
        int item = power.get(j);
        if (j == 0) {
          aim = item;
          continue;
        }

        if (item == 0) {
          aim = 0;
          continue;
        }

        if (flag && item < aim) {
          aim = item;
        } else if (!flag && item > aim) {
          aim = item;
        }

      }

      if (aim < 0) {
        aim = aim * -1;
      }

      int result = 1;

      for (int k = 1; k < aim + 1; k++) {
        result = result * k;
      }

      System.out.println(aim + " " + result);

    }
  }

}
