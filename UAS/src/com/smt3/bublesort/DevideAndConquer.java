package com.smt3.bublesort;

import java.util.Scanner;

public class DevideAndConquer {
    
    private void gabung(int[] array, int kiri, int tengah, int kanan) {

        //Menemukan ukuran 2 sub array yang akan digabungkan
        int pembagi1 = tengah - kiri + 1; 
        int pembagi2 = kanan - tengah; 

        // Membuat temp Array
        int[] Kiri = new int[pembagi1];
        int[] Kanan = new int[pembagi2];

        //menyalin data Array ke Temp
        for (int i=0; i<pembagi1; ++i)
            Kiri[i]= array[kiri + i];
        for (int j=0; j<pembagi2; ++j) 
            Kanan[j] = array[tengah + 1+ j]; 
        

        //penggabungan temp array

        //inisial index pertama sub array
        int i = 0, j = 0;

        // inisial index penggabungan array
        int temp = kiri;
        while (i < pembagi1 && j < pembagi2) 
        { 
            if (Kiri[i] <= Kanan[j]) 
            { 
                array[temp] = Kiri[i]; 
                i++; 
            } 
            else
            { 
                array[temp] = Kanan[j]; 
                j++; 
            } 
            temp++; 
        } 

        // menyalin sisa isi sub array Kiri[]
        while (i < pembagi1) {
            array[temp] = Kiri[i];
            i++;
            temp++;
        }

        // menyalin sisa isi sub array Kanan[]
        while (j < pembagi2) {
            array[temp] = Kanan[j];
            j++;
            temp++;
        }
    }

    // Fungsi Sorting 
    private void menata(int[] array, int kiri, int kanan) {
        if ( kiri < kanan) {
            // mencari titik tengah
            int tengah =  (kiri+kanan)/2;

            // menata baris pertama dan kedua
            menata(array, kiri, tengah);
            menata(array, tengah+1, kanan);

            // menggabungkan kedua sub array
            gabung(array, kiri, tengah, kanan);
        }
    }

    // fungsi mencetak isi array
    private static void cetak(int[] array) {
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int batas;
        long start, end;
        char ulang;

        // Pengulangan proses Devide and Qonquer
        do {
            // Input batas array
            System.out.print("Masukkan Batas Input : ");
            batas = scan.nextInt();

            // instalasi array
            int[] array = new int[batas];
            // int array[] = {12, 11, 13, 5, 6, 7};

            // input data array
            for (int i = 0; i < batas; i++) {
                System.out.print("Masukkan Nilai Array " + i + " : ");
                array[i] = scan.nextInt();
            }

            // cetak array sebelum disorting
            start = System.nanoTime();
            System.out.println("Sebelum disorting : ");
            cetak(array);

            // inisiasi kiri, kanan
            // int kiri = 0, kanan = array.length;

            // proses sorting
            DevideAndConquer tata = new DevideAndConquer();
            tata.menata(array, 0, array.length-1);

            // cetak array setelah disorting
            System.out.println();
            System.out.println("Setelah disorting : ");
            cetak(array);
            end=System.nanoTime();
            System.out.println("Time execution: "+(end-start)/1000000000.0+" nano detik");

            // trigger untuk pengulangan
            System.out.print("apakah anda mau mengulang : ");
            ulang = scan.next().charAt(0);
        } while (ulang == 'y' || ulang == 'Y');
    }
}