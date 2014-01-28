package matrix;

public class Multiplier {
	
	public static int SIZE_OF_MATRIX = 3;
	
	public static int[][] multiply() {
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		int e = 1;
		int f = 1;
		int g = 1;
		int h = 1;
		int i = 1;
		
		int j = 1;
		int k = 1;
		int l = 1;
		int m = 1;
		int n = 1;
		int o = 1;
		int p = 1;
		int q = 1;
		int r = 1;
		
		
//		int[][] matrix_a = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
		int[][] matrix_a = {{a, b, c},
							{d, e, f},
							{g, h, i}};

		int[][] matrix_b ={{j, k, l},
		         			{m, n, o},
		         			{p, q, r}};

		int[] product_array = new int[SIZE_OF_MATRIX];

		int[][] result = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];

		int[] max_matrix = new int[SIZE_OF_MATRIX];

		//fill max matrix

		for (int ind = 0; ind < SIZE_OF_MATRIX; ind++) {
		   max_matrix[ind] = Math.max(matrix_b[i]);
		}

		// fill resulting matrix row by row

		for (int y = 0; y < SIZE_OF_MATRIX; y++) {

		   // go from 0 to 2 inside one row

		   for (int x = 0; x < SIZE_OF_MATRIX; x++) {

		       //take this row, multiply by every element - 9 multiplications squeezed into 3

		       int res = 0;

		       for (int j = 0; j <= max_matrix[x]; j++) {

		           // if we get to j, k, l, extract

		           for (int m = 0; m < SIZE_OF_MATRIX; m++) {

		               if (j == matrix_b[x][m]) {

		                   product_array[x][m] = res;

		               }

		           }

		           res += matrix_a[y][x];

		       }

		   }

		   // calculate 3 members of result from 9 element product_array; add the cols

		   for (int i = 0; i < SIZE_OF_MATRIX; i++) {

		       int res = 0;

		       for (int j = 0; j < SIZE_OF_MATRIX; j++) {

		           res+= product_array[j][i];

		       }

		       result[y][i] = res;

		   }

		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
