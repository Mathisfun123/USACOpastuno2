import java.util.HashMap;

public class RandomUsaco {
    public static void main(String[] args) {
        HashMap <Integer, Integer> items= new HashMap<>();
        items.put(5,5);
        items.put(6,5);
        System.out.println(items.put(2,7));
    }
}
