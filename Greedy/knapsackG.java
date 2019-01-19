import java.util.Scanner;
 
/** Class Knapsack **/
public class knapsackG {
    public void solve(int[] berat, int[] nilai, int W, int N) {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;       
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
 
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY; 
                if (j >= berat[i]) {
                    m2 = m[i - 1][j - berat[i]] + nilai[i];
                }
                /** pilihan max dari m1, m2 **/
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }        
        /** Buat Daftar dari Semua Item Pilihan **/
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w] != 0) {
                selected[n] = 1;
                w = w - berat[n];
            } else {
                selected[n] = 0;
            }
        }
        // int[] select = new int[W + 1];
        // for (int n = N, w = W; w > 0; w--) {
        //     if (sol[w][n] != 0) {
        //         select[w] = 1;
        //         n = n - nilai[w];
        //     } else {
        //         select[w] = 0;
        //     }
        // }
        /** Cetak item pilihan **/
        System.out.println("\nPilihan Item : ");
        for (int i = 1; i < N + 1; i++) {
            if (selected[i] == 1) {
                System.out.print(i +" ");
                System.out.println();
            }
        }
    }
    /** Main function **/
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Knapsack Algorithm Test\n");
        /** Buat sebuah objek class knapsack greedy **/
        knapsackG ks = new knapsackG();
 
        System.out.println("Masukkan Jumlah Element ");
        int n = scan.nextInt();
 
        int[] berat = new int[n + 1];
        int[] nilai = new int[n + 1];
 
        System.out.println("\nMasukkan Berat Untuk "+ n +" Element");
        for (int i = 1; i <= n; i++)
            berat[i] = scan.nextInt();
        System.out.println("\nMasukkan Nilai Untuk "+ n +" Element");
        for (int i = 1; i <= n; i++)
            nilai[i] = scan.nextInt();
 
        System.out.println("\nMasukkan Berat Maks Knapsack ");
        int W = scan.nextInt();
 
        ks.solve(berat, nilai, W, n);
    }
}
