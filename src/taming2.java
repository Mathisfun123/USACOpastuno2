import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taming2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("taming.in"));
		int n = sc.nextInt();
		int[] days = new int[n];
		sc.nextLine();
		for(int i =0; i< n; i++){
			days[i]= (sc.nextInt());
		}
		for (int i = 0; i < days.length; i++) {
			int day = days[i];
			System.out.println(day);
		}
	}
}
