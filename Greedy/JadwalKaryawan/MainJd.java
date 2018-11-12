/**
 * created by pujianto131
 
 */


import java.util.List;
import java.util.Scanner;
import java.util.*;

public class MainJd{
    

    public static void main(String[] args) {
        int[][] dataArr= {
            {5,7,2,1},
            {3,4,4,2},
            {8,7,1,3},
            {5,1,2,6}
        };        

        for (int i = 0; i <dataArr.length; i++) {
            if(i<1){
                System.out.print("   P"+(i+1));
            }
            else{
                System.out.print("  P"+(i+1));
            }
        }
        System.out.println("");
        for (int i = 0; i < dataArr.length; i++) {
            for(int j=0; j<dataArr.length; j++){
                if (j <1) {
                    System.out.print("W"+(i+1)+" "+dataArr[i][j]);
                }
                else{
                    System.out.print("   "+dataArr[i][j]);
                }
               
            }
            System.out.println("");
            
        }
        System.out.println("\n");
        mJadwal(dataArr);
    }

    // method penjadwalan
    private static void mJadwal(int[][] arr) {
        int[] terbaik = new int[arr.length];
        int kecil, index=0, tampung=0;
        for (int i = 0; i <arr.length; i++) {
            kecil=9999;
            for (int j = 0; j <arr.length; j++) {
                if (arr[j][i] != 9999) {
                    if(arr[j][i] < kecil){
                        kecil = arr[j][i];
                        index = j;
                        terbaik[i]=j;                        
                    }                    
                }
            }
            tampung += kecil;
            for (int k = 0; k <arr.length; k++) {
                arr[index][k]= 9999;                
            }
        }
        for (int l = 0; l <arr.length; l++) {
            System.out.println("P"+(l+1)+" = W"+(terbaik[l]+1));
        }
        System.out.println("\nTotal Waktu: "+tampung);
        // return tampung;
        
    }
}
