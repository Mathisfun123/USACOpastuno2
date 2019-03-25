import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class traffic {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("traffic.in"));
		PrintWriter out = new PrintWriter(new File("traffic.out"));
		int n = sc.nextInt(); sc.nextLine();
		ArrayList<Step> order = new ArrayList<>();
			int startmin =  0; int startmax = 1100;
		//predict end result
		for(int i = 0; i< n; i++){
			String arr[ ]= sc.nextLine().split(" ");
			order.add(new Step(arr[0],arr[1],arr[2]));
			Step t = order.get(order.size()-1);
			if(t.action.equals("on")){
				startmin+= t.min; startmax+=t.max;
			}else if(t.action.equals("none")){
				startmin= Math.max(startmin,t.min); startmax= Math.min(startmax,t.max);
			}else{
				startmin-= t.max; startmax-= t.min; startmin = Math.max(0,startmin);
			}
		}
		//getting begining  - reverse order
		order = rever(order);

			int endmin = startmin>0? startmin : 0; int endmax = startmax>0?startmax : 0;
	//	System.out.println(startmin + " "+ startmax);
		for(int i = 0; i< n; i++){
			Step t = order.get(i);
			if(t.action.equals("on")){
				startmin-= t.max; startmax-= t.min; startmin = Math.max(0,startmin);
			}else if(t.action.equals("none")){
				startmin= Math.max(startmin,t.min); startmax= Math.min(startmax,t.max);
			}else{
				startmin+= t.min; startmax+=t.max;
			}
		}
		startmin= startmin> 0? startmin : 0; startmax = startmax >0 ? startmax: 0;
		out.println(startmin + " "+ startmax);
		out.println(endmin+ " "+ endmax);
		out.close();;
		//System.out.println(order);

	}
	public static class Step{
		public String action;
		public int min, max;
		public Step(String a, String m, String m2 ){
			action = a;
			min = Integer.parseInt(m);
			max =Integer.parseInt(m2);
		}

		@Override
		public String toString() {
			return action + " " + min + " " + max;
		}
	}
	public static ArrayList<Step> rever (ArrayList<Step> t){
		ArrayList<Step > newA = new ArrayList<>();
		for(int i = t.size()-1; i>=0; i--){
			newA.add(t.get(i));
		}
		return newA;
	}
//	if(arr[0].equals("none")){
//		if(order.size()>1 && order.get(order.size()-2).action.equals("none")){
//			Step s1 = order.remove(order.size()-1); Step s2 = order.remove(order.size()-1);
//			order.add(new Step("none",String.valueOf(Math.max(s1.min,s2.min)),String.valueOf(Math.min(s1.max,s2.max))));
//		}else if(order.size()>1 && order.get(order.size()-2).action.equals("on")){
//			Step s1 = order.remove(order.size()-1); Step s2 = order.remove(order.size()-1);
//			order.add(new Step("none",String.valueOf(s1.min - s2.max) , String.valueOf(s1.max-s2.min)));
//		}else if(order.size()>1 &&  order.get(order.size()-2).action.equals("off")){
//			Step s1 = order.remove(order.size()-1); Step s2 = order.remove(order.size()-1);
//			order.add(new Step("none",String.valueOf(s1.min + s2.min) , String.valueOf(s1.max+s2.max)));
//		}
//	}
}
