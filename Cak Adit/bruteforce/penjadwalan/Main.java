import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		int jumlahPdanW, tampung, terbaik = 0, kecil = 9999;
		int[][] p;
		
		System.out.println("Program Pernjadwalan Metode Brurefoce\n");
		Scanner inputan = new Scanner(System.in);
		System.out.print("Tentukan jumlah pekerjaan dan pekerja yang akan diinput : ");
		jumlahPdanW = inputan.nextInt();
		
		int[][] data = new int[jumlahPdanW][jumlahPdanW];
		
		for( int i = 0; i < jumlahPdanW; i++ ){
			System.out.println("\nInput waktu yang diperlukan oleh pekerja 1 (P" + (i + 1) + ") : \n");
			for( int j = 0; j < jumlahPdanW; j++ ){
				System.out.print("Pekerjaan ke - " + (j + 1) + " : ");
				data[j][i] = inputan.nextInt();
			}
		}
			
		inputan.close();
		Permutasi perm = new Permutasi();
		p = perm.permutasi(jumlahPdanW);
		for( int i = 0; i < perm.faktorial(jumlahPdanW); i++ ){
			tampung = 0;
			for( int j = 0; j < jumlahPdanW; j++ ){
				tampung = tampung + data[j][ p[i][j] ];
			}
			if( tampung < kecil ){
				kecil = tampung;
				terbaik = i;
			}
		}
		
		System.out.println("\nKombinasi pekerjaan yang dapat dikerjakan oleh pekerja dengan waktu tercepat : \n");
		for( int i = 0; i < jumlahPdanW; i++ ){
			System.out.println("P" + (i + 1) + " = W" + (p[terbaik][i] + 1) );
		}
		System.out.println("\n\nTotal waktu : " + kecil);
	}
}