import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		char abjad[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int jumlahBarang, tampungHarga, tampungBerat, beratMax, terbaik = 0, hargaSementara = 0, beratSementara = 0, index = 0;;
		int[][] p;
		
		System.out.println("Program Knapsack Metode Brurefoce\n");
		Scanner inputan = new Scanner(System.in);
		System.out.print("Tentukan jumlah barang yang akan diinput : ");
		jumlahBarang = inputan.nextInt();
		
		int[][] data = new int[jumlahBarang][3];
		
		for( int i = 0; i < jumlahBarang; i++ ){
			System.out.print("\nInput harga barang " + abjad[i] + " : ");
			data[i][0] = i;
			data[i][1] = inputan.nextInt();
			System.out.print("Input berat barang " + abjad[i] + " : ");
			data[i][2] = inputan.nextInt();
		}
			
		System.out.print("\nTentukan batas berat maksimum : ");
		beratMax = inputan.nextInt();
		
		Permutasi perm = new Permutasi();
		p = perm.permutasi(jumlahBarang);
		for( int i = 0; i < perm.faktorial(jumlahBarang); i++ ){
			tampungBerat = 0;
			tampungHarga = 0;
			for( int j = 0; j < jumlahBarang; j++ ){
				tampungBerat = tampungBerat + data[ p[i][j] ][2];
				tampungHarga = tampungHarga + data[ p[i][j] ][1];
				if( tampungBerat <= beratMax && tampungHarga >= hargaSementara){
					beratSementara = tampungBerat;
					hargaSementara = tampungHarga;
					index = j;
					terbaik = i;
				}
			}
		}
		
		System.out.println("\nKombinasi barang dengan total harga maksimal : \n");
		for( int i = 0; i <= index; i++ ){
			System.out.print( abjad[ p[terbaik][i] ]);
			if( i < index )
				System.out.print(" + ");
		}
		System.out.println("\n\nTotal Berat : " + beratSementara + "Kg");
		System.out.println("Total Harga : " + hargaSementara);
	}
}