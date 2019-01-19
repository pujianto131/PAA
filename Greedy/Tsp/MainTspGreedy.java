 import java.util.*;

public class MainTspGreedy{
    public static void main(String[] args) {
        char abjad[] = {'A','B','C', 'D', 'E', 'F','G','H','I'};
        int jumlahKota;

        System.out.println("\nProgram TSP - Greedy");
        Scanner mScanner = new Scanner(System.in);
        System.out.print("jumlah Kota: ");
        jumlahKota = mScanner.nextInt();

        int[][] dataArr = new int[jumlahKota][jumlahKota];

        // inputArray
        System.out.println("input jarak antar kota\n");
        for (int i = 0; i < jumlahKota; i++) {
            for (int j = 0; j < jumlahKota; j++) {
                if (i != j && dataArr[i][j] == 0) {
                    System.out.print("jarak" + abjad[i]+"-"+abjad[j]+" : ");
                    dataArr[i][j] = mScanner.nextInt();
                    dataArr[j][i] = dataArr[i][j];
                }
            }
            System.out.println("");
        }
        // print arrayKota
        for(int i=0; i<jumlahKota; i++){
            if(i<1){
                System.out.print("\t"+abjad[i]);
            }
            else{
                System.out.print("\t"+abjad[i]);
            }
        }
        System.out.println("\n");
        for (int i = 0; i < jumlahKota; i++) {
            for (int j = 0; j < jumlahKota; j++) {
                if(j<1){
                    System.out.print(abjad[i]+"\t"+dataArr[i][j]);
                }
                else{
                    System.out.print("\t"+dataArr[i][j]);
                }
            }
            System.out.println("");
        }
        // proses TSP greedy
        char startKota;
        System.out.print("\ntentukan nilai start: ");
        startKota = mScanner.next().charAt(0);

        boolean jalan =false;
        int lokasiStart=0,locNow=0, hapus=0, tmpStart=0;
        int jarakKota = 0, count=0;
        int[] indexStart =new int [abjad.length];
        
        for (int i = 0; i <jumlahKota; i++) {
            if (startKota == abjad[i]) {
                jalan = true;
                tmpStart=i;
                lokasiStart=i;
            }
        }
        if (jalan == true) {
            while (count < jumlahKota-1) {
                int kecil = 9999;
                hapus = lokasiStart;
                for (int i = 0; i <jumlahKota ; i++) {
                    if (dataArr[lokasiStart][i] != 0 ) {
                        if (kecil > dataArr[lokasiStart][i]) {
                            kecil = dataArr[lokasiStart][i];
                            locNow =i;
                        }
                    }
                }
                jarakKota +=kecil;
                indexStart[count] = locNow;
                lokasiStart = locNow;
                for(int j=0; j<jumlahKota; j++){
                    dataArr[hapus][j]=0;
                    dataArr[j][hapus]=0;
                }
                count++;     
            } 
        }
        System.out.print("lokasi yg ditempuh: "+abjad[tmpStart]);
        for (int i = 0; i < count; i++) {
            System.out.print("->"+ abjad[ indexStart[i] ]);
        }
        System.out.println("->"+abjad[tmpStart]);
        System.out.println("\nJarak yg ditempuh: "+jarakKota+"\n\n");
    }
}