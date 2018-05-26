import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class hoofball {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("hoofball.in"));
        int n = sc.nextInt(); sc.nextLine();
        String ln []= sc.nextLine().split(" ");
        int idcow[] = new int[ln.length];
        for (int i = 0; i < idcow.length; i++) {
            idcow[i] = Integer.parseInt(ln[i]);
        }
        Arrays.sort(idcow);
        int numballs= 1;
        for(int i = 2; i<idcow.length-1; i++ ){
            if(idcow[i]-idcow[i-1]< idcow[i+1]-idcow[i]){
                numballs++;
                for(int j = idcow.length-1; i>-1; i--){

                }
            }
        }
    }
}
