import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class teleport {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("teleport.in"));
        PrintWriter out=  new PrintWriter(new File("teleport.out"));
        String ln  = sc.nextLine();
        String []elems= ln.split(" ");
        int start = Integer.parseInt(elems[0]);
        int end = Integer.parseInt(elems[1]);
        int tel1 = Integer.parseInt(elems[2]);
        int tel2= Integer.parseInt(elems[3]);
        int max = end-start;
        int time = 0;
        if(end<start){
            int temp= end;
            end=start;
            start=temp;
        }
            if (tel1 < start && tel2 > start) {
                int dist = Math.abs(start-tel1)+ Math.abs(end-tel2);
                out.println(Math.min(dist,max));
            }else if(tel2< start && tel1>start){
                int dist= Math.abs(start-tel2)+ Math.abs(end-tel1);
                out.println(Math.min(dist,max));
            }else if(tel1> start && tel2> tel1){
                int dist = Math.abs((tel1-start))+ Math.abs(tel2-end);
              out.println(Math.min(dist,max));
            }else if(tel2> start && tel1>tel2){
                int dist= Math.abs((tel2)-start)+Math.abs(tel1-end);
               out.println(Math.min(dist,max));
            }else{
            out.println(max);
            }
            out.close();
    }
}
