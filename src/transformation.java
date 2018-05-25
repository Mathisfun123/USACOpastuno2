import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class transformation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("transformation.in"));
        int n = sc.nextInt();
        sc.nextLine();
        char intialmaze[][] = new char[n][n];
        char finalmaze [][] = new char[n][n];
        for(int i = 0; i< n; i++){
            String sg = sc.nextLine();
            int size = sg.length();
            for(int j= 0;j< size; j++){
                intialmaze[i][j] = sg.charAt(j);
            }
        }
        for(int i = 0; i< n; i++){
            String sg = sc.nextLine();
            int size = sg.length();
            for(int j= 0;j< size; j++){
                finalmaze[i][j] = sg.charAt(j);
            }
        }
        boolean transformation [] = new boolean[8];
        if(checkSameMaze(intialmaze, finalmaze)){
            transformation[6] = true;
        }
        char newmaze [][]  =returnRotateMaze(intialmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[1]= true;
        }
        newmaze = returnRotateMaze( newmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[2]= true;
        }
        newmaze = returnRotateMaze( newmaze);
        if(checkSameMaze(newmaze,finalmaze)){
            transformation[3]= true;
        }
        newmaze = returnRotateMaze(newmaze);
        if(n  % 2 ==0 ){
            int mid = n / 2;
            for(int i = 0; i< mid; i++){
                char [] t = intialmaze [i];
                char [] p = intialmaze [n-(mid+i )];
                for(int j = 0; j< n; j++){
                    newmaze[i][j] = p[j];
                }
                for(int j = n-(mid+i); j>= 0; j--){
                    newmaze[i][j] = t[j];
                }
            }
        }else{

        }

        boolean happend = false;
        for(int i =1 ; i< transformation.length; i++){
            if(!happend && transformation[i]){
                System.out.println(i);
                happend= true;
            }
        }
        if(!happend){
            System.out.println(7);
        }

    }
    public static char[][] returnRotateMaze(char [][] intialmaze2){
        char[][] check = new char[intialmaze2.length][intialmaze2.length];
        for(int i  = 0; i< intialmaze2[0].length;i++){
            for(int j = intialmaze2.length-1; j>=0;j-- ){
                check[i][j] = intialmaze2[intialmaze2.length- (j+1)][i];
            }
        }
        return check;
    }
    public static boolean checkSameMaze (char [][] item1, char item2[][]){
        for(int i = 0; i< item2.length; i++){
            for(int j = 0; j< item2[i].length; j++){
                if(item1[i][j]!=item2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
