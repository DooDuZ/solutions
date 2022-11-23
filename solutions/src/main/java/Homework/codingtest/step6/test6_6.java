package Homework.codingtest.step6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test6_6 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s, " ");
		
		System.out.println(st.countTokens());
	}	
}


/*
	왜 오답처리하는지 모르겠음
	백준 병신아...
	
	Scanner input = new Scanner(System.in);
	String s = input.nextLine();		
	int count = 0;
	for(int i = 0 ; i<s.length() ; i++) {
		if(s.charAt(i)==' ') {
			if(i==0 || i==s.length()-1) {
				continue;
			}
			count++;
		}
	}
	System.out.println(count+1);

*/