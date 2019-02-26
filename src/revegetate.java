import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		for(int i = 0; i< cows; i++){
			int s1 = sc.nextInt(); int s2 = sc.nextInt();
			pastures[s1-1].addConnection(s2); pastures[s2-1].addConnection(s1);
		}


		pastures[0].seednum=1; pastures[0].hasSeed=true;
		for(int i = 1; i< n; i++){
			if(!pastures[i].hasSeed){
				if(!pastures[0].items.contains(i+1)){
					pastures[i].seednum=1; pastures[i].hasSeed=true;
					pastures[0].items.addAll(pastures[i].items);
				}
			}
		}
		int spot2 = -1;
		for(int i = 1; i< n; i++) {
			if (!pastures[i].hasSeed){
				if(spot2==-1){
					spot2=i; pastures[i].hasSeed=true; pastures[i].seednum=2;
				}else{
					if(!pastures[i].items.contains(spot2+1)){
						pastures[i].hasSeed=true; pastures[i].seednum=2;
						pastures[spot2].items.addAll(pastures[i].items);

					}
				}
			}
		}
		int spot3 = -1;
		for(int i = 1; i< n; i++){
			if(!pastures[i].hasSeed){
				if(spot3==-1){
					spot3=i; pastures[i].hasSeed=true; pastures[i].seednum=3;
				}else{
					if(!pastures[i].items.contains(spot3+1)){
						pastures[i].hasSeed=true; pastures[i].seednum=3;
						pastures[spot3].items.addAll(pastures[i].items);

					}
				}
			}
		}
		int spot4 = -1;
		for(int i = 1; i< n; i++){
			if(!pastures[i].hasSeed){
				if(spot4==-1){
					spot4=i; pastures[i].hasSeed=true; pastures[i].seednum=4;
				}else{
					if(!pastures[i].items.contains(spot4+1)){
						pastures[i].hasSeed=true; pastures[i].seednum=4;
						pastures[spot4].items.addAll(pastures[i].items);

					}
				}
			}
		}
		for (int i = 0; i < pastures.length; i++) {
			Pasture pasture = pastures[i];
			out.print(pasture.seednum);
		}
		out.close();
	}
	public static class Pasture{
		public int id, seednum;
		boolean hasSeed= false;
		public TreeSet<Integer> items = new TreeSet<>();
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
}
