package com.seu.beauty;

public class 将帅_1_2 {

	/**
	 * 找出将帅所有的合法位置，只能使用一个字节存储变量
	 * 用1-9分别代表田字格
	 * 1--2--3
	 * |  |  |
	 * 4--5--6
	 * |  |  |
	 * 7--8--9
	 */
	public static void main(String[] args) {
		byte  a=0;
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if(i%3==j%3){
					continue;
				}
				System.out.println("a="+i+",b="+j);
			}
		}

	}
	
}
