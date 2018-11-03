import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		char abjad[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char startPoint;
		int jumlahNode, kecil = 9999, terbaik = 0, tampung, mulai;
		int[][] p;
		Permutasi perm = new Permutasi();
		
		System.out.println("Program TSP Metode Brurefoce\n");
		Scanner inputan = new Scanner(System.in);
		System.out.print("Tentukan jumlah node diinput : ");
		jumlahNode = inputan.nextInt();
		
		int[][] data = new int[jumlahNode][jumlahNode];
		p = perm.permutasi(jumlahNode);
		
		System.out.println("Tentukan jarak antar node : \n");
		
		for( int i = 0; i < jumlahNode; i++ ){
			for( int j = 0; j < jumlahNode; j++ ){
				if( i != j ){
					System.out.print("Jarak " + abjad[i] + " ke " + abjad[j] + " : ");
					data[i][j] = inputan.nextInt();
				}
			}
		}
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		System.out.println("Program TSP Metode Brurefoce\n");
		System.out.println("Data tersimpan : \n");
		
		for( int i = 0; i < jumlahNode; i++ ){
			if( i == 0 )
				System.out.print(" _| " + abjad[i]);
			else
				System.out.print(" | " +  abjad[i]);
		}	
		
		System.out.println("");
		
		for( int i = 0; i < jumlahNode; i++ ){
			for( int j = 0; j < jumlahNode; j++ ){
				if( j == 0 )
					System.out.print(" " + abjad[i] + "| " + data[i][j]);
				else
					System.out.print(" | " + data[i][j]);
			}
			System.out.println("");
		}
		
		System.out.print("\nTentukan start node : ");
		startPoint = inputan.next().charAt(0);
		
		for( int i = 0; i < perm.faktorial(jumlahNode); i++ ){
			tampung = 0;
			if( abjad[ p[i][0] ] == startPoint ){
				mulai = p[i][0];
				for( int j = 0; j < jumlahNode; j++ ){
					if( abjad[ p[i][j] ] != startPoint ){
						tampung = tampung + data[ mulai ][ p[i][j] ];
						mulai = p[i][j];
					}						
				}
				if( tampung < kecil ){
					kecil = tampung;
					terbaik = i;
				}
			}
		}
		
		System.out.print("\nKombinasi terbaik adalah : ");
		for( int i = 0; i < jumlahNode; i++ ){
			if( i == 0 )
				System.out.print( abjad[ p[terbaik][i] ] );
			else
				System.out.print( " -> " + abjad[ p[terbaik][i] ] );
		}
		System.out.println("\nTotal jarak : " + kecil + "\n");
	}
}