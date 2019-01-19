import java.util.*;

public class BubbleSort{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int batas;
        System.out.print("Masukkan Batas : ");
        batas = input .nextInt();
        int[] data = new int[batas];
        for(int i=0; i<batas; i++){
            System.out.print("Data index " + (i+1) + " = ");
            data[i] = input.nextInt();
        }
        System.out.println("\nData Sebelum di urutkan : ");
        for(int i=0; i<batas; i++){
            System.out.print(data[i] + ", ");
        }
        //Proses Bubble sort
        for(int i=0; i<batas; i++){
            System.out.println("\nIterasi ke - " + (i+1));
            for(int j=0; j<batas-1; j++){
                if(data[j] > data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
                if(j < batas-(i+1)){
                    for(int k=0; k<batas; k++){
                        System.out.print(data[k] + ", ");
                    }
                    System.out.println(" ");
                }
            }
            System.out.println(" ");
        }

        System.out.println("Data Setelah di sorting : ");
        for(int i=0; i<batas; i++){
            System.out.print(data[i] + ", ");
        }
    }

}