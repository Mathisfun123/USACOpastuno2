import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class badmilk {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("badmilk" + ".in"));
        PrintWriter out = new PrintWriter(new File("badmilk" + ".out"));
        int N = sc.nextInt(); //Number of People
        int m = sc.nextInt(); //Number of MIlk
        int d = sc.nextInt(); //Line Reading drinks
        int s = sc.nextInt(); //Line Reading sicks
        sc.nextLine();
        Person people [] =new Person[N];
        ArrayList<Integer> possibleMilks = new ArrayList<>();
        for(int i = 0; i< d; i++){
            String [] lninfo = sc.nextLine().split(" ");
            if(people[Integer.parseInt(lninfo[0])-1] == null){
                people[Integer.parseInt(lninfo[0])-1]= new Person(Integer.parseInt(lninfo[0]), Integer.parseInt(lninfo[1]), Integer.parseInt(lninfo[2]));
            }else if(!(people[Integer.parseInt(lninfo[0])-1]==null)){
                people[Integer.parseInt(lninfo[0])-1].AddMilk(Integer.parseInt(lninfo[1]),Integer.parseInt(lninfo[2]));
            }
        }
        for(int i = 0; i< s; i++){
            int idOfSick= sc.nextInt(); int timeOfSick = sc.nextInt();
            if(i==0){
               possibleMilks=  people[idOfSick-1].milksPotetnial(timeOfSick);
            }else{
                ArrayList <Integer> milkcommontwo = people[idOfSick-1].milksPotetnial(timeOfSick);
                ArrayList<Integer> truecommon = new ArrayList<>();
                for (int j = 0; j < possibleMilks.size(); j++) {
                    if((milkcommontwo.contains(possibleMilks.get(j)))){
                        truecommon.add(possibleMilks.get(j));
                    }
                }
                possibleMilks= truecommon;
            }
        }
        //System.out.println(possibleMilks);  WORKS: Telling what milks are bad
        //Finish Putting People with milk drank
        //System.out.println(possibleMilks);
        int amt = 0;
        for (int i = 0; i < people.length; i++) {
            System.out.print(" ");
            Person person = people[i];
            if(person!=null && person.milkdrank.size()>0){
                boolean already =false;
                for(int j = 0; j< possibleMilks.size(); j++){
                    if(!already && person.milkdrank.contains(possibleMilks.get(j))){
                        already= true;
                    }
                }
                if(already){
                    amt++;
                }
                //System.out.print(person.milkdrank);
            }
        }
        //System.out.println(amt);
//        for(int i = 0; i< N; i++){
//            boolean cond = false;
//            for(int j = 0; j< possibleMilks.size(); j++){
//                if(!cond&& people[i] !=null && people[i].milkdrank!=null && people[i].milkdrank.contains(j)){
//                    amt++;
//                    cond=true;
//                    //Deal with break
//                }
//            }
//        }
        out.println(amt);
        out.close();
    }
    static class Person{
        int id;
        HashMap<Integer, Integer> milkDrankLeadTime;
        ArrayList<Integer> milkdrank;
        public Person(int i, int milknum, int timdrunk){
            id= i;
            milkDrankLeadTime= new HashMap<>();
            milkdrank= new ArrayList<>();
            milkDrankLeadTime.put(milknum,timdrunk);
            milkdrank.add(milknum);
        }
        public void AddMilk (int milk, int time){
            if(!milkDrankLeadTime.containsKey(milk)){
                milkDrankLeadTime.put(milk,time);
                if(!(milkdrank.contains(milk))){milkdrank.add(milk);}
            }
        }
        public ArrayList<Integer> milksPotetnial (int time){
            ArrayList<Integer> potentialToReturn = new ArrayList<>();
            for (Integer aMilkdrank : milkdrank) {
                if (milkDrankLeadTime.get(aMilkdrank) < time) {
                    potentialToReturn.add(aMilkdrank);
                }
            }
            return potentialToReturn;
        }
    }

}