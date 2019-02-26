import java.util.HashMap;

public class RandomUsaco {
    public static void main(String[] args) {
        double hi = 5.1223;
        int b = 100;
        System.out.println(convertPowBases(10,16,15));
    }
    public static String convertPowBases(int num1, int  num2convertto, int val){
        String p = Integer.toString(Integer.parseInt((Integer.toString(val,num1)),num2convertto));
        return p;
    }
}
