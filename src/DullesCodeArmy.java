import java.util.*;

public class DullesCodeArmy {
    public static void main(String[] args) {
        List <DullesCodeWarrior> Army;
        Army = new ArrayList<>();
        for(int i = 0; i< Integer.MAX_VALUE; i++){
            Army.add(new DullesCodeWarrior());
        }
    }

    static class DullesCodeWarrior {
        private int attack;       //Hacking ability
        private int defense;      //Sarcasm
        private int health;       //Pizza
        private int speed;        //Words per Minute
        private boolean supreme;  //USACO Platinum
        private long finese;      //CodeForces Rating
        public DullesCodeWarrior(){
            supreme = true;
            finese = Long.MAX_VALUE;
            attack = defense = health = speed = 9001;
        }
    }
}