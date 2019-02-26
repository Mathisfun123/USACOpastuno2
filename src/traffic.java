import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class traffic {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("traffic.in"));
		PrintWriter out = new PrintWriter(new File("traffic.out"));
		int n = sc.nextInt(); sc.nextLine();
		Stack<String> changes = new Stack<>();
		int begmin=0, begmax=0, endmin=0, endmax=0;
		for(int i = 0; i< n; i++){
			if(i==0){
				sc.next();
				 begmin = sc.nextInt();
				 begmax = sc.nextInt();
			}else if(i==n-1){
				sc.next();
				endmin = sc.nextInt();
				endmax= sc.nextInt();
			}else{
				sc.next();
				changes.add(sc.nextInt()+" "+ sc.nextInt());
			}
		}
		while(changes.size()>1){
			String s1 = changes.pop();
			String s2 = changes.pop();
			int min = Math.max(Integer.parseInt(s1.substring(0,s1.indexOf(' '))),Integer.parseInt(s2.substring(0,s2.indexOf(' '))));
			int max = Math.min(Integer.parseInt(s1.substring(s1.indexOf(' ')+1)),Integer.parseInt(s2.substring(s2.indexOf(' ')+1)));
			changes.push(min+" "+ max);
		}

		String p = changes.pop();
		out.print((Integer.parseInt(p.substring(0,p.indexOf(' ')))- begmax)+ " ");
		out.println((Integer.parseInt(p.substring(p.indexOf(' ')+1))- begmin));
		out.print((Integer.parseInt(p.substring(0,p.indexOf(' ')))- endmax)+ " ");
		out.print((Integer.parseInt(p.substring(p.indexOf(' ')+1))- endmin));
		out.close();
		//time out case
	}
}
