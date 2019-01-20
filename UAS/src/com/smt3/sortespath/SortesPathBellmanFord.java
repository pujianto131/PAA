package com.smt3.sortespath;

import java.util.Scanner;

public class SortesPathBellmanFord {

    private static final Scanner scan = new Scanner(System.in);
    private static int[] distance;
    private static int batas;
    private static final int MAX_VALUE = 999;
    private static final char[] kota = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

    public SortesPathBellmanFord(int batas) {
        this.batas = batas;
        distance = new int[batas + 1];
    }

    public static void main(String[] args) {
        System.out.println("PROGRAM SHORTES PATH\nBellman-Ford Algorithm!!!\n\n");
//        System.out.print("\nInputkan batas: ");
        int batas = 6;
//        int[][] data = new int[batas][batas];
//
//        for (int i = 0; i < batas; i++) {
//            for (int j = 0; j < batas; j++) {
//                if (i == j) {
//                    data[i][j] = 0;
//                } else if (data[i][j] == 0) {
//                    System.out.print("input jarak [" + i + "][" + j + "]: ");
//                    inputData(data, i, j, scan);
//                }
//            }
//        }


        int[][] data = {
                {0, 13, 4, 999, 9999, 9999},
                {13, 0, 2, 6, 9999, 9999},
                {4, 2, 0, 9999, -1, 9999},
                {9999, 6, 9999, 0, 5, 5},
                {9999, 9999, -1, 5, 0, 13},
                {9999, 9999, 9999, 5, 13, 0}};
        printMatrix2D(data, batas);
        System.out.print("\nInput Awal: ");
        char kotaAwal = scan.next().charAt(0);
        int awal = 0;
        for (int i = 0; i < kota.length; i++) {
            if (kotaAwal == kota[i]) {
                awal = i;
            }
        }
        SortesPathBellmanFord mBellman = new SortesPathBellmanFord(batas);
        mBellman.bellmanFord(data, awal);


    }

    public static void inputData(int[][] data, int i, int j, Scanner scan) {
        data[i][j] = scan.nextInt();
        if (data[i][j] == 0) {
            data[i][j] = 9999;
        }
        data[j][i] = data[i][j];
    }

    private static void printMatrix2D(int[][] data, int batas) {

        System.out.println("DATA JARAK ANTAR KOTA");
        System.out.print("\t  ");
        for (int i = 0; i < batas; i++) {
            System.out.printf("%-5c", SortesPathBellmanFord.kota[i]);
        }
        System.out.println("\n================================");
        for (int i = 0; i < batas; i++) {
            for (int j = 0; j < batas; j++) {
                if (j == 0) {
                    System.out.print("\t" + SortesPathBellmanFord.kota[i] + "|");
                    System.out.printf("%-5d", data[i][j]);
                } else {
                    System.out.printf("%-5d", data[i][j]);
                }

            }
            System.out.println(" ");
        }
    }


    private void bellmanFord(int[][] data, int awal) {
//        execute bellmanFord=================================================
        for (int i = 0; i < batas; i++) {
            distance[i] = MAX_VALUE;
        }
        distance[awal] = 0;
        for (int i = 0; i < batas - 1; i++) {//node
            for (int j = 0; j < batas; j++) {//sourceNode
                for (int k = 0; k < batas; k++) {//destinNode
                    if (data[j][k] != MAX_VALUE && distance[k] > distance[j] + data[j][k]) {
                        distance[k] = distance[j] + data[j][k];
                    }
                }
            }
        }

//        untuk menampilkan hasil jarak yang negatif=========================
        for (int i = 0; i < batas; i++) {//s
            for (int j = 0; j < batas; j++) {//d
                if (data[i][j] != MAX_VALUE && distance[j] > distance[i] + data[i][j]) {
                    System.out.println("The Graph contains negative egde cycle\n");
                }
            }
        }

        for (int i = 0; i < batas; i++) {
            System.out.println("distance of source " + kota[awal] + " to " + kota[i] + " is " + distance[i]);
        }
    }
}
