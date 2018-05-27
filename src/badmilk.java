import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class badmilk {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("badmilk" + ".in"));
        PrintWriter out = new PrintWriter(new File("badmilk" + ".out"));
        int N = sc.nextInt();
        ArrayList <Person> peoplee = new ArrayList<>();
        HashMap<Integer,Person> idtoPerson = new HashMap<>();
        int M = sc.nextInt();
        int nummilks [] = new int[M];
        int d = sc.nextInt();
        int s = sc.nextInt();
        sc.nextInt();
        for(int i = 1; i< N+1; i++){
            Person p = new Person(i);
            peoplee.add(p);
            idtoPerson.put(i,p);
        }
        for (int i = 0; i < d-1; i++) {
            int idperson = sc.nextInt();
            int milkid = sc.nextInt();
            int timedrank = sc.nextInt();
            sc.nextLine();
            //System.out.println(idperson);
            idtoPerson.get(idperson).addMilkandTime(milkid,timedrank);
        }
        ArrayList <Person> peopleSick = new ArrayList<>();
        for(int i = 0; i< s; i++){
            int idperson = sc.nextInt();
            peopleSick.add(idtoPerson.get(idperson));
            idtoPerson.get(idperson).sick= true;
            int time= sc.nextInt();
            if(idtoPerson.get(idperson).earlySick>time){
                idtoPerson.get(idperson).earlySick= time;
            }
        }
        ArrayList<Integer> potentialMIlks = new ArrayList<>();
        potentialMIlks= peopleSick.get(0).milksBeforeSick();
        for (int i = 1; i < peopleSick.size(); i++) {
            Person person =  peopleSick.get(i);
            potentialMIlks= intersect(potentialMIlks,person.milksBeforeSick());
        }
        System.out.println(potentialMIlks);
        out.close();
    }
    public static ArrayList<Integer> intersect(ArrayList <Integer> first, ArrayList <Integer> Second){
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            if(Second.contains(first.get(i))){
                p.add(first.get(i));
            }
            
        }
        return p;
    }
    static class Person{
        public int id;
        public  HashMap<Integer, Integer>  timeDrinkBasedOnMilk = new HashMap();
        public  ArrayList<Integer> MilkDrank = new ArrayList<>();
        public boolean sick;
        public int earlySick = Integer.MAX_VALUE;
        public Person(int idn){
        id = idn;
        }
        public void addMilkandTime ( int milkid, int time){
            if(!MilkDrank.contains(milkid) || timeDrinkBasedOnMilk.get(milkid)>time){
                if(!MilkDrank.contains(milkid)){MilkDrank.add(milkid);}
                timeDrinkBasedOnMilk.put(milkid,time);
            }
        }
        public ArrayList <Integer> milksBeforeSick(){
            ArrayList<Integer> retun = new ArrayList<>();
            for (int i = 0; i < MilkDrank.size(); i++) {
                Integer integer =  MilkDrank.get(i);
                if(timeDrinkBasedOnMilk.get(integer)< earlySick){
                    retun.add(integer);
                }
            }
            return retun;
        }
    }
}
