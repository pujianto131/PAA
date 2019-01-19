package com.smt3.bublesort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int batas;

        // input batas
        System.out.print("Masukkan Batasan Input : ");
        batas = scan.nextInt();

        // inisiasi array
        int[] array = new int[batas];

        // input data array
        for (int i = 0; i < array.length; i++) {
            System.out.print("Masukkan Nilai Array " + i + " : ");
            array[i] = scan.nextInt();
        }

        long start,end;
        start = System.nanoTime();
        // cetak sebelum disortir
        System.out.println("\nSebelum Disortir");
        cetak(array);
        // proses sortir
        sortir(array);

        // cetak setelah disortir
        System.out.println("\nSetelah Disortir");
        cetak(array);
        end=System.nanoTime();
        System.out.println("\nTime execute: "+(end-start)/1000000000.0+" nano detik");
    }


    // fungsi sortir
    private static void sortir(int[] array) {
        int temp;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // fungsi cetak array
    private static void cetak(int[] array) {
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
    }

}