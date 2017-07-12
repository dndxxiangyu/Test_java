package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		String in = scanner.next();
		String[] ins = in.trim().split(" ");
		int len=ins.length;
		int[] a = new int[len];
		for(int i=0;i<len;i++){
			a[i] = Integer.parseInt(ins[i]);
		}
		Arrays.sort(a);
		if(a[0]>=60){
			System.out.println(60);
			return;
		}
		int out = a[4]/10*10;
		System.out.println(out);
	}
	//2895345323 298,345,23
	public static void get(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sb;
		try {
			sb = br.readLine();
		} catch (Exception e) {
			return;
		}
		int len = sb.length();
		ArrayList<String> al = new ArrayList<String>();
		int start = 0;
		int end = 0;
		for(int i=1; i<len; i++){
			if(sb.charAt(end)<sb.charAt(i)){
				end++;
			}else if(end-start>=1){
				al.add(sb.substring(start, end+1));
				start = end+1;
				end = start;
			}else if(end-start==0){
				start++;
				end++;
			}
			if(i==len-1&&end-start>=1){
				al.add(sb.substring(start, end+1));
			}
		}
		if(al.size()==0){
			return;
		}
		System.out.println(al);
		Collections.sort(al,Collections.reverseOrder());
		System.out.println(al.get(0));
	}
}
