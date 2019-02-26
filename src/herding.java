
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class herding {


	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("herding.in"));
		PrintWriter out = new PrintWriter(new File("herding.out"));
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min;
		int c = sc.nextInt();
		if(a+1==b && b== c-1){
			out.println(0);
			out.println(0);
			out.close();
		}else{
			if(b-a==2|| c-b==2){
				min= 1;
			}else{
				min= 2;
			}
			int maxdiff = Math.max(b-a, c-b);
			int max = maxdiff-1;


			out.println(min);
			out.println(max);
			out.close();
		}

	}
	public static class Group{
		int a, b,  c, n;
		public  Group(int x1, int x2, int x3, int v){
			a= x1; b = x2; c=x3; n=v;
		}
	}
//	public static void loops ( int min, int mid, int max, int count){
//
//			for (int i = mid+1; i<max;i++ ){
//				loops(mid,i,max,count+1);
//			}
//
//			for(int i= min +1; i<mid; i++){
//				loops(min,i, mid,count+1);
//			}
//
//		if(min+1 ==mid && mid==max-1){
//			if(count<abmin){
//				abmin= count;
//			}
//			if(count>abmax){
//				abmax= count;
//			}
//
//		}
//
//	}
}
