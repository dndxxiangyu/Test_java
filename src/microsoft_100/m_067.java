package microsoft_100;

import java.util.Arrays;
import java.util.Random;

public class m_067 {

	/**
	 * 67.俩个闲玩娱乐。 1.扑克牌的顺子 从扑克牌中随机抽5 张牌，判断是不是一个顺子，即这5 张牌是不是连续的。 2-10 为数字本身，A
	 * 为1，J 为11，Q 为12，K 为13，而大小王可以看成任意数字。
	 */
	public static void main(String[] args) {
		int[] table = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4,
				5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 0 };//0代表大小王
		int[] len = new int[5];
		//产生5个不同的下标
		for (int i = 0; i < 5; i++) {
			Random rand = new Random();
			len[i] = rand.nextInt(54);
			for (int j = 0; j < i; j++) {
				if (len[i] == len[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(len));
		int[] poke = new int[5];
		for (int i = 0; i < 5; i++) {
			poke[i] = table[len[i]];
//			poke[i] = i+1;
		}
		int[] poke1={0,1,2,3,5};
		System.out.println(Arrays.toString(poke));
		Arrays.sort(poke);
		System.out.println(Arrays.toString(poke));
		System.out.println(new m_067().isStraight(poke));
	}
	public boolean isStraight(int[] table){
		int sum=0;
		if(table[0]==0&&table[1]!=0){
			for(int i=1;i<4;i++){
				if(table[i+1]-table[i]==0)return false;
				sum += table[i+1]-table[i];
			}
			if(sum==4||sum==3)return true;
		}else if(table[0]==0&&table[1]==0){
			for(int i=2;i<4;i++){
				if(table[i+1]-table[i]==0)return false;
				sum += table[i+1]-table[i];
			}
			if(sum>=2&&sum<=4)return true;
		}else{
			for(int i=0;i<4;i++){
				if(table[i+1]-table[i]==0)return false;
				sum += table[i+1]-table[i];
			}
			if(sum==4)return true;
		}
		
		return false;
	}
}
