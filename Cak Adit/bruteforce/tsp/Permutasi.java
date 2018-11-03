class Permutasi{
	public static int x;
	String[] data = new String[x];
	int index = -1;
	
	static int faktorial(int n){ 
		if (n == 0){
			return 1; 
		}else{
			return n*faktorial(n-1);
		}
	} 
	
	private String[] eksekusi(String[] str, int awal, int akhir) { 
		
		if (awal == akhir){
			index++;
			data[index] = str[0];
		}else{ 
			for (int i = awal; i <= akhir; i++) { 
				str = swap(str,awal,i); 
				eksekusi(str, awal+1, akhir); 
				str = swap(str,awal,i); 
			}
		}	
	return data;
	} 

	public static String[] swap(String[] a, int i, int j){ 
		char temp; 
		char[] charArray = a[0].toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		a[0] = String.valueOf(charArray);
		return a; 
	} 
	
	public static int[][] permutasi(int jumlah){
		String[] arr = {""};
		x = faktorial(jumlah);
		int[][] data = new int[x][jumlah];
		
		for(int i = 0; i < jumlah; i++){
			arr[0] = arr[0] + String.valueOf(i);
		}
		
		Permutasi permutasi = new Permutasi();
		arr = permutasi.eksekusi(arr, 0, jumlah-1);
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