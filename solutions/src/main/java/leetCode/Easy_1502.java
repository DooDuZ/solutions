package leetCode;

import java.util.Arrays;

public class Easy_1502 {

	/*
		1502. Can Make Arithmetic Progression From Sequence
		
		
		A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
		만약 연속된 두 요소의 차가 같다면 우리는 그 시퀀스를 등차 수열이라고 부릅니다. 
		Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
		숫자 배열 arr이 주어지면, 만약 arr이 등차수열로 재정렬될 수 있다면 true를, 아니라면 false를 반환하세요.
		
		public boolean canMakeArithmeticProgression(int[] arr) {
        	// 여기에 답 작성
    	}
	*/
	public static void main(String[] args) {
		Easy_1502 ea = new Easy_1502();
		
		int[] arr = {3,5,1};
		
		System.out.println(ea.canMakeArithmeticProgression(arr));
		
	}
	
	
	public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        boolean check = true;
		for(int i = 0 ; i<arr.length-2 ; i++) {
        	if((arr[i]-arr[i+1])==(arr[i+1]-arr[i+2])) {
        		continue;
        	}else {
        		check = false;
        		break;
        	}
        }
		return check;
    }
	
}
