import java.util.Scanner;

public class SortestPath {
    public static void main(String[] args) {
        char vertex[] = {'A','B','C','D'};
        Scanner tulis  = new Scanner(System.in);
        int n = vertex.length;
        int nilai[][] = new int[n][n];
        int start = 0, end = 0, ulang = 0, hapus, lokasi = 0, tempuh = 0, urut[], lstart = 0;
        Boolean sstart = false, send = false;
        char input1, input2;
        System.out.println("\nGreedy-SortestPath\n");
        inputNilai(nilai, n, vertex, tulis);
        cetakArray(nilai, vertex, n);

        System.out.print("Masukkan Tujuan Awal \t: ");
        input1 = tulis.next().charAt(0);
        for (int i = 0; i < n; i++) {
            if (vertex[i] == input1) {
                sstart = true;
                start = i;
                lstart = i;
                System.out.println(start);
            }
        }
        System.out.print("Masukkan Tujuan Akhir \t: ");
        input2 = tulis.next().charAt(0);
        for (int i = 0; i < n; i++) {
            if (vertex[i] == input2) {
                send = true;
                end = i;
                System.out.println(end);
            }
        }
        urut = new int [30];
        if (sstart == true && send == true) {
            while (start != end) {
                hapus = start;
                int temp = 9999;
                for (int i = 0; i < n; i++) {
                    if (nilai[start][i] != 0) {
                        if (temp > nilai[start][i]) {
                            temp = nilai[start][i];
                            lokasi = i;
                        }
                    }
                }
                tempuh += temp;
                urut[ulang] = lokasi;
                start = lokasi;
                for (int i = 0; i < n; i++) {
                    nilai[hapus][i] = 0;
                    nilai[i][hapus] = 0;
                }
                ulang++;
            }
            System.out.print("\n");
            System.out.print("Lokasi yang ditempuh : " + vertex[lstart]);
            for (int i = 0; i <nilai.length-1; i++) {
                System.out.print(" -> " + vertex[urut[i]]);
            }
            System.out.println("\nLokasi yang ditempuh adalah : " + tempuh + "\n");
        }
        else {
            System.out.println("Lokasi Start dan End Tidak ketemu");
        }
    }
    public static void cetakArray (int nilai[][], char vertex[],int n) {
        System.out.println("---------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + vertex[i]);
        }
        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            System.out.print(vertex[i] + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("---------------------------");
    }
    public static void inputNilai (int nilai[][], int n, char vertex[], Scanner tulis) {
        System.out.println("Tentakan Jarak Antar Kota");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && nilai[i][j] == 0) {
                    System.out.print("jarak" + vertex[i]+"-"+vertex[j]+" : ");
                    nilai[i][j] = tulis.nextInt();
                    nilai[j][i] = nilai[i][j];
                }
                // System.out.print("Masukkan Nilai " + vertex[i] + " " + vertex[j] + " : ");
                // nilai[i][j] = tulis.nextInt();
            }
            System.out.println("");
        }
    }      
}