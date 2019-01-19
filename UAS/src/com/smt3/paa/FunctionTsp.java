package com.smt3.paa;

public class FunctionTsp {
    private static int x;
    String[] data = new String[x];
    private static int index = -1;


    static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    private String[] execute( String[] str, int awal, int akhir){
        if(awal == akhir){
            index++;
            data[index] = str[0];
        }
        else{
            for(int i=awal; i <=akhir; i++){
                str = swap(str, awal, i);
                execute(str, awal+1, akhir);
                str = swap(str, awal, i);
            }
        }
        return data;
    }

    public static String[] swap(String[] a, int i, int j){
        char tmp;
        char[] charArray = a[0].toCharArray();
        tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        a[0] = String.valueOf(charArray);
        return a;
    }

    public static  int[][] permutasi(int jumlah){
        String[] arr={""};
        x = factorial(jumlah);
        int[][] data = new int[x][jumlah];

        for(int i = 0; i < jumlah; i++){
            arr[0]=arr[0] + String.valueOf(i);
        }

        FunctionTsp mFunctionTsp = new FunctionTsp();
        arr = mFunctionTsp.execute(arr, 0, jumlah-1);
        char[] charArray;

        for(int i = 0; i < x; i++){
            charArray = arr[i].toCharArray();
            for(int j = 0; j < jumlah; j++){
                data[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }
        return data;
    }
}
