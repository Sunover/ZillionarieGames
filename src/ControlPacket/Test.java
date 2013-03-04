package ControlPacket;

public class Test {
	public static void main(String[] args){
		int[][] array = new int[2][3];
		int k = 1;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 3; j++)
				{array[i][j] = k;k++;}
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 3; j++)
				{System.out.print(array[i][j]);}
			System.out.println();
		}
		
		int[] a = new int[6];
		k = 0;
		for(int i = 0; i < 2; i++){
    		for(int j = 0; j < 3; j++){
    				a[k] = array[i][j];
    			k++;
    		}
    	}
		
		for(int i = 0; i < 6; i++)
			System.out.print(a[i]);
		System.out.println();
		
		for(int i = 0; i < 6; i++){
			if(i != 0 && i % 3 == 0)
				System.out.println();
			System.out.print(a[i]);
		}
		
		System.out.println();
		int b = 2;
		char c = String.valueOf(b).charAt(0);
		System.out.println(c);
			
	}
}
