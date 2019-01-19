import java.util.Scanner;

public class MainTsp{
    public static void main(String[] args) {
        
        char abjad[] = {'A','B','C', 'D', 'E', 'F','G','H','I'};
        char start;
        int jumlahKota, kecil = 9999, terbaik = 0, tampung, mulai;

        System.out.println("Program TSP - BruteForce");
        Scanner mScanner = new Scanner(System.in);
        System.out.print("jumlah Kota: ");
        jumlahKota = mScanner.nextInt();

        int[][] dataArr = new int[jumlahKota][jumlahKota];
        FunctionTsp mTsp = new FunctionTsp();
        int[][] permutasiArray;
        permutasiArray = mTsp.permutasi(jumlahKota);

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
        }

        // print arrayKota
        for(int i=0; i<jumlahKota; i++){
            if(i<1){
                System.out.print("   "+abjad[i]);
            }
            else{
                System.out.print("\t"+abjad[i]);
            }
        }
        System.out.println("");
        for (int i = 0; i < jumlahKota; i++) {
            for (int j = 0; j < jumlahKota; j++) {
                if(j<1){
                    System.out.print(abjad[i]+"  "+dataArr[i][j]);
                }
                else{
                    System.out.print("\t"+dataArr[i][j]);
                }
            }
            System.out.println("");
        }

        System.out.println("\npermutasi");
        for (int i = 0; i < permutasiArray.length ; i++) {
            for (int j = 0; j <=jumlahKota; j++) {
                if(j<1){
                    System.out.print("  "+permutasiArray[i][j]);
                }
                else{
                    System.out.print("\t"+permutasiArray[i][j]);
                }
            }
            System.out.println("");
        }


       
        System.out.print("tentukan start Kota");
        start = mScanner.next().charAt(0);

        int factorial = mTsp.factorial(jumlahKota);
        for (int i = 0; i < factorial; i++) {
            tampung = 0;
            if(abjad[ permutasiArray[i][0] ] == start){
                mulai = permutasiArray[i][0];
                for(int j=0; j<jumlahKota; j++){
                    if(abjad[ permutasiArray[i][j] ] != start){
                        tampung =tampung+ dataArr[mulai][ permutasiArray[i][j] ];
                        mulai = permutasiArray[i][j];
                    }                    
                }
                if(tampung < kecil){
                    kecil = tampung;
                    terbaik = i;
                }
            }           
        }
        System.out.print("\nKombinasi Terbaik adalah: ");
        for(int i= 0; i < jumlahKota; i++){
            if(i == 0){
                System.out.print(abjad[ permutasiArray[terbaik][i]]);
            }
            else{
                System.out.print("->"+abjad[ permutasiArray[terbaik][i]]);
            }
        }
        System.out.println("\nTotal Jarak : "+kecil+"\n\n");
        mScanner.close();
    }
    
}