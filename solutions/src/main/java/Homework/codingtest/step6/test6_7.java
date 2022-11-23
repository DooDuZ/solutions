package Homework.codingtest.step6;

import java.util.Scanner;

public class test6_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int first = input.nextInt();
		int second = input.nextInt();
		
		char[] arr = String.valueOf(first).toCharArray();
		String carr = "";
		char[] arr2 = String.valueOf(second).toCharArray();
		String carr2 = "";
		for(int i = 0 ; i < arr.length ; i++) {
			carr += arr[arr.length-(i+1)];
		}
		for(int i = 0 ; i < arr2.length ; i++) {
			carr2 += arr2[arr2.length-(i+1)];
		}		
		int answer;
		
		if(Integer.parseInt(carr)>=Integer.parseInt(carr2)) {
			answer = Integer.parseInt(carr);
		}else {
			answer = Integer.parseInt(carr2);
		}		
		System.out.println(answer);		
		input.close();
	}
}
