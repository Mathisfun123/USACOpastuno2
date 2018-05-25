import java.util.*;
import java.io.*;
//Good Position
public class paint {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("paint" + ".in"));
        PrintWriter out = new PrintWriter(new File("paint" + ".out"));
        boolean array[] = new boolean[101];
        int sum = 0;
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i=a;i <b;i++) {
            array[i]= true;
        }
        sc.nextLine();
         a = sc.nextInt();
         b = sc.nextInt();
        for (int i=a;i <b;i++) {
            array[i]= true;
        }
        for( int i = 0; i<101; i++){
            if(array[i]== true){
                sum+=1;
            }
        }
out.println(sum);
        out.close();
    }
}
