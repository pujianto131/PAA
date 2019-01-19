 import java.util.*;

public class Selection{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int batas;
        System.out.print("Masukkan Batas : ");
        batas=input.nextInt();

        int[] data = new int[batas];
                                                                                                  
        for(int i=0; i<batas; i++){
            System.out.print("Input data indeks " + (i+1) + " : ");
            data[i] = input.nextInt();
        }

        System.out.println("\nData sebelum di sorting ");

        for(int i=0; i<batas; i++){
            System.out.print(data[i] + ", ");
        }

        System.out.println("\n Proses Selection Sort");
        for(int i=0; i<batas; i++){
            System.out.println("\nIterasi ke " + (i+1));
            boolean tukar = false;
            int index = 0;
            int min = data[i];
            for(int j=i+1; j<batas; j++){
                if(min > data[j]){
                    tukar = true;
                    index = j;
                    min = data[j];
                }
            }
                if(tukar == true){
                    int tmp = data[i];
                    data[i] = data[index];
                    data[index]=tmp;
                }
                for(int k=0; k<batas; k++){
                    System.out.print(data[k] + ", ");
                }
            System.out.println();
        }

        System.out.println("Data setelah di sort");
        for(int i=0; i<batas; i++){
            System.out.print(data[i] + ", ");
        }
    }
}


