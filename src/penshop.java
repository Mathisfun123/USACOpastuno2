import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class penshop {
	public static void main(String[] args) throws FileNotFoundException {
		// Start Data input - Scanner with file
		Scanner sc =new Scanner( new File("penshop.in"));
		int n = sc.nextInt();sc.nextLine();
		//Takes n as the number of lines - > skips lines because Int() normally goes for space
		HashSet<Integer> price2= new HashSet<>();
		HashSet<String> brands2= new HashSet<>();
		//We will utilize the power of Set, which only allows one of each entry to exist in the set
		for(int i = 0; i< n; i++){
			String brand = sc.next();
			int price = Integer.parseInt(sc.next());
			price2.add(price);
			//Adding price to price hash set -> if items of the same price are added they will not change the size of the HashSet
			brands2.add(brand);
			//Same logic as the price hash set
		}
		//If the hashset size is not equal to the number of lines, then there were duplicates
		if(brands2.size()!= n || price2.size()!=n){
			System.out.println("No");
		}else{
			System.out.println("Yes");
		}

		//This problem utilized the power of Sets, other approaches could include
		// having a static class of pens (with a price and brand)and comparing each element with the ones following it (0: [1->n-1], 1: [2->n-1), 2: [3-> n-1] ...)
		    //Would be O(n(n-1)/2) ~ O(n^2) (works for many bronze problems)

	}
}
