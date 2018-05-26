import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taming {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("taming.in"));
        int num = sc.nextInt();
        sc.nextLine();
        String ln = sc.nextLine();
        String elem[] = ln.split(" ");
        int days [] = new int[elem.length];
        for (int i = 0; i < days.length; i++) {
            days[i]=Integer.parseInt(elem[i]);
        }
        int min=0, max =0;
        for(int i= 0; i< num; i++){
            if(days[i]!= days[i-1]){

            }
        }
    }
}
