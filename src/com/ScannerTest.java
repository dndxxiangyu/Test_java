package com;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextInt();
		System.out.println(scanner.hasNextInt());
	}

}
