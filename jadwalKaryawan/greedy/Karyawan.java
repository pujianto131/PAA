import java.util.*;

//import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Karyawan {

    public static void main(String[] args) {
        int p[][] = {{7,2,6,4},{8,7,3,5},{1,1,2,1},{4,5,3,2}};
        int batas = 4;
        String shiftKerja[] = {"P1", "P2", "P3", "P4"};
        String jamKerja[]  = {"W1", "W2", "W3", "W4"};

        roling(p, batas);

    }

    public static int roling (int p[][], int w) {

        
        //this.p = p;
        int hasil = 0;

        for (int i = 0 ; i < w; i++) {
            int temp = 9999;
            for (int j = 0; j < w; j++) {
                if (temp >  p[j][i]){
                    temp = p [j][i];
                    hasil = hasil + temp;
                    System.out.println(temp);
                }
            }
            //hasil = hasil + temp;
            
        }
        System.out.println("Hasilnya Adalah : " + hasil);
        return hasil;
    }


}