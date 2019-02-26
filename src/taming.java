import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taming {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("taming.in"));
        PrintWriter out = new PrintWriter(new File("taming.out"));
        int num = sc.nextInt();
        sc.nextLine();
        String ln = sc.nextLine();
        String elem[] = ln.split(" ");
        int days [] = new int[num];
        int poss[] = new int[num]; // -1 guaranteed 0 max min
        //initialize as all days possibilities
        for (int i = 0; i < poss.length; i++) {
            poss[i]= 1; //Start off as not being possibility
        }
        int lastval = 0; boolean ascen = true;
        for (int i = 0; i < num; i++) {
            days[i]=Integer.parseInt(elem[i]);
            if(days[i]==-1){
                poss[i]= 0; //Could be (Adds to max but not min)
            }
            if(days[i]==-1){
                lastval= 0;
            }else{
                if(days[i]<lastval){
                    ascen = false;
                    lastval= days[i];
                }else{
                    lastval=days[i];
                }
            }
        }
        if(!ascen){
            out.println(-1);
            out.close();
        }
        if(days[0]!=-1 && days[0]!=0){
            out.println(-1);
            out.close();
        }
        //Have days with numbers

        //sum represents total possibilities -> unfinished
        for(int i = 1; i< days.length; i++){
            if(days[i]>-1){
                poss[i-days[i]] = -1;
            }
        }
        poss[0]= -1;
        int min = 0; int max = 0;
        for (int i = 0; i < poss.length; i++) {
            int poss1 = poss[i];
            if(poss1==-1){
                min++; max++;
            }else if(poss1==0){
                max++;
            }
        }
        out.println(min+" "+max);
        out.close();

    }
}
