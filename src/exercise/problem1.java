package exercise;

import java.util.Scanner;

/**
 * Created by springlustre on 2017/3/31.
 */
public class problem1 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int p0 = in.nextInt();
    int q0 = in.nextInt();
    int target = in.nextInt();
    double p = (double)p0/100;
    double q = (double)q0/100;
    System.out.println(dg(p,q,target,0,0,p,1.0));
  }

  public static double dg(double p, double q, int target,int now,int path,double nowP,double pathP) {
    double a,b;
    if(now==target){
      System.out.println(now*pathP);
      return path*pathP;
    }else{
      if(nowP==1.0){
        a=dg(p,q,target,now+1,path+1,getnext(p,now+1),pathP*nowP);
        return a;
      }else{
        a=dg(p,q,target,now+1,path+1,getnext(p,now+1),pathP*nowP);
        b=dg(p,q,target,now,path+1,deleteFlow(nowP+q),pathP*(1-nowP));
        return a+b;
      }
    }
  }
  public static double getnext(double p,int x){
    double a = p*100;
    for(int i = 0;i<x;i++){
      a=a/2;
    }
    int b = (int)a;
    return ((double)b)/100;
  }
  public static double deleteFlow(double a){
    return a>1.0?1.0:a;
  }


}
