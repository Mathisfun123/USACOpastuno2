import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class measurement {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("3.in"));
        int num = sc.nextInt();
        int []date = new int[num]; int change[]= new int[num];
        String name[] = new String[num];
        sc.nextLine();
        for(int i = 0; i< num; i++){
            String ln = sc.nextLine();
            String elem[] = ln.split(" ");
            date[i]= Integer.parseInt(elem[0]);
            name[i] = elem[1];
            change[i]= elem[2].substring(0,1).equals("+")?Integer.parseInt(elem[2].substring(1)): -1* Integer.parseInt(elem[2].substring(1));
            System.out.println(date[i]+ name[i]+ change[i]);

        }
        long valBessie=7, valElse=7, valMildred=7;
        String last = ""; int numchange = 0;
        for(int i = 1; i<= 100; i++){
            for(int j = 0; j< date.length; j++){
                if(date[j]==i){
                    if(name[j].equals("Bessie")){
                        valBessie+=change[j];
                    }else if(name[j].equals("Mildred")){
                        valMildred+= change[j];
                    }else{
                        valElse+=change[j];
                    }
                    long max = Math.max(valBessie, Math.max(valElse,valMildred));
                    if(max==valBessie ){
                       if(!last.equals("Bessie")){
                            numchange++;
                            last = "Bessie";
                        }
                    }else if(max == valElse){
                        if(!last.equals("Elsie")){
                            numchange++;
                            last = "Elsie";
                        }
                    }else{
                        if(!last.equals("Mildred")){
                            numchange++;
                            last= "Mildred";
                        }
                    }
                }
            }
        }
        System.out.println(numchange);
    }
}
