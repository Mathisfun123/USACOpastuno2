import java.util.*;
import java.io.*;

public class speeding {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("speeding" + ".in"));
        PrintWriter out = new PrintWriter(new File("speeding" + ".out"));
        int origsize = sc.nextInt();
        int newsize = sc.nextInt();
        sc.nextLine();
        //create potential
        int[] origsizevals = new int[101];
        int[] newsizevals  = new int[101];
        //have final array = newsize- origsize
        int currorig = 1;
        for(int i = 0; i< origsize; i++){
            int distance = sc.nextInt();
            int speed  = sc.nextInt();
            sc.nextLine();
            int maxdis = currorig+distance;
            for(int j = currorig; j< maxdis; j++){
                origsizevals[j] = speed;
            }
            currorig += distance;
        }
        int currnew = 1;
        for(int i = 0; i<newsize; i++){
            int distance= sc.nextInt();
            int speed = sc.nextInt();
            if(i!=newsize-1){sc.nextLine();}
            int maxdis = currnew+distance;
            for(int j = currnew; j< maxdis; j++){
                newsizevals[j] = speed;
            }
            currnew += distance;
        } 
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<origsizevals.length; i++){
            max = Math.max(max, newsizevals[i]-origsizevals[i]);
        }
        out.println(max);
        out.close();
    }
}
