package microsoft_100;

public class m_035求一个矩阵中最大的二维矩阵 {

	/**
	 * 35.
	 * 求一个矩阵中最大的二维矩阵(元素和最大)
	 */
	public static void main(String[] args) {
		int[][] matrix=new int[][]{{1,2,3,4},{1,2,3,-10}};
		System.out.println(new m_035求一个矩阵中最大的二维矩阵().getBigMatrix(matrix));
		
	}
	public int getBigMatrix(int[][] matrix){
		int row = matrix.length;//row
		int column = matrix[0].length;
		System.out.println(row+":"+column);
		int sum = Integer.MIN_VALUE;
		for(int i=0;i<row;i++){
			int[] b=new int[column];
			for(int j=i;j<row;j++){
				for(int k=0;k<column;k++){
					b[k] += matrix[j][k];
				}
				int a = getBigArray(b);
				System.out.println("a:"+a);
				if(a>sum)sum = a;
			}
		}
		return sum;
	}
	public int getBigArray(int[] array){
		int sum = Integer.MIN_VALUE;
		int b=0;
		for(int i=0; i<array.length;i++){
			if(b<=0){
				b = array[i];
			}else{
				b += array[i];
			}
			if(sum<b)sum=b;
		}
		return sum;
	}
}
