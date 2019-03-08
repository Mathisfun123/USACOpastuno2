import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class revegetate {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("revegetate.in"));
		PrintWriter out = new PrintWriter(new File("revegetate.out"));
		int n = sc.nextInt(); int cows = sc.nextInt();
		Pasture pastures[] = new Pasture[n];
		for(int i = 0; i< n; i++){
			pastures[i]= new Pasture(i+1);
		}
		int ans[]  = new int[n];
		for(int i = 0; i< cows; i++){
			int s1 = sc.nextInt(); int s2 = sc.nextInt();
			pastures[s1-1].addConnection(s2); pastures[s2-1].addConnection(s1);
		}
		for(int i = 0; i < n; i++){
			ArrayList<Integer> poss = new ArrayList<>();
			poss.add(1); poss.add(2); poss.add(3);poss.add(4);
			//System.out.println(pastures[i].items);
			for(int j = 0; j< pastures[i].items.size(); j++){
				if(ans[pastures[i].items.get(j)-1]!=0){
					poss.remove( new Integer(ans[pastures[i].items.get(j)-1]));
				}
			}
			ans[i] = poss.get(0);
			//printTime(ans);
		}
		StringBuilder outln = new StringBuilder();
		for (int i = 0; i < ans.length; i++) {
			int an = ans[i];
			outln.append(an);
		}
		out.println(outln.toString());
		out.close();
	}
	public static class Pasture{
		public int id, seednum;
		boolean hasSeed= false;
		public ArrayList<Integer> items = new ArrayList<>();
		public Pasture(int i){
			id=i;
		}
		public void addConnection(int num){
			items.add(num);
		}

		@Override
		public String toString() {
			return id+ " " + items + seednum;
		}
	}
	public static void printTime(int [] arr){
		for (int i = 0; i < arr.length; i++) {
			int i1 = arr[i];
			System.out.print(i1);
		}
		System.out.println();
	}
}
