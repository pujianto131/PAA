package com.tugasuas.tspbubleshort;

import java.util.Scanner;

public class TspBubleShort {

	private static char abjad[] = {'A','B','C', 'D', 'E', 'F','G','H','I'};
    public static void main(String[] args) {
        FunctionTsp mTsp = new FunctionTsp();

        Scanner inScan =  new Scanner(System.in);
        int jumlahKota;

        System.out.print("input jumlah kota: ");
        jumlahKota = inScan.nextInt();

        int[][] matrix= new int[jumlahKota][jumlahKota];
        int[][] permutasiArray;
        permutasiArray = mTsp.permutasi(jumlahKota);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i!=j && matrix[i][j]==0) {
                    System.out.print("input value ["+i+"]["+j+"] : ");
                    matrix[i][j] = inScan.nextInt();
                    if (matrix [i][j] == 0) {
                        matrix[i][j] = 9999;
                    }
                    matrix[j][i] = matrix[i][j];
                }
            }
        }

        printMatrix(matrix, abjad);
        int factKota = mTsp.factorial(jumlahKota);
        System.out.print("\ntentukan kota awal: ");
        char start=inScan.next().charAt(0);
        exeBubble(matrix, abjad, permutasiArray, factKota, start, jumlahKota);

    }

    public static void printMatrix(int[][] matrix, char[] abjad) {
        for (int i = 0; i < matrix.length; i++) {
            if (i==0) {
                System.out.print("\t | "+abjad[i]);
            }else {
                System.out.print("\t"+abjad[i]);
            }

        }
        System.out.println("\n\t----------------------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j==0) {
                    System.out.print("\t"+abjad[i]+"| "+matrix[i][j]);
                }
                else {
                    System.out.print("\t"+matrix[i][j]);
                }
            }
            System.out.println("");
        }
    }



    public static void exeBubble(int[][] matrix,char[] abjad,int[][] permutasiArray,int factKota, char start, int jumlahKota) {

        for (int i = 0; i < factKota; i++) {
            int tampung=0;
            if (abjad[permutasiArray[i][0]] == start) {
                for (int j = 0; j < jumlahKota; j++) {
                    System.out.print(i+": "+permutasiArray[i][j]+"\t");
                }
                System.out.println("");
            }
        }

    }
	
	
}
