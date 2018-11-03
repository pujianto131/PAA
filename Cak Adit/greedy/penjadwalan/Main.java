import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		int jumlahPdanW, tampung = 0, index = 0, kecil;
		
		System.out.println("Program Pernjadwalan Metode Greedy\n");
		Scanner inputan = new Scanner(System.in);
		// System.out.print("Tentukan jumlah pekerjaan dan pekerja yang akan diinput : ");
		// jumlahPdanW = inputan.nextInt();
		
		// int[][] data = new int[jumlahPdanW][jumlahPdanW];
		// int[] terbaik = new int[jumlahPdanW];
		
		// for( int i = 0; i < jumlahPdanW; i++ ){
		// 	System.out.println("\nInput waktu yang diperlukan oleh pekerja 1 (P" + (i + 1) + ") : \n");
		// 	for( int j = 0; j < jumlahPdanW; j++ ){
		// 		System.out.print("Pekerjaan ke - " + (j + 1) + " : ");
		// 		data[j][i] = inputan.nextInt();
		// 	}
		// }
			
		// inputan.close();
		int[][] data= {
            {5,7,2,1},
            {3,4,4,2},
            {8,7,1,3},
            {5,1,2,6}
		};        
		int[] terbaik = new int[data.length];
		
		for( int i = 0; i <data.length; i++ ){
			kecil = 9999;
			for( int j = 0; j <data.length; j++ ){
				if( data[j][i] != 9999 ){
					if( data[j][i] < kecil ){
						kecil = data[j][i];
						index = j;
						terbaik[i] = j;
					}
				}
			}
			tampung = tampung + kecil;
			for(int k = 0; k < data.length; k++){
				data[index][k] = 9999;
			}
		}
		
		System.out.println("\nKombinasi pekerjaan yang dapat dikerjakan oleh pekerja dengan waktu tercepat : \n");
		for( int i = 0; i <data.length; i++ ){
			System.out.println("P" + (i + 1) + " = W" + (terbaik[i] + 1) );
		}
		System.out.println("\n\nTotal waktu : " + tampung);
	}
}