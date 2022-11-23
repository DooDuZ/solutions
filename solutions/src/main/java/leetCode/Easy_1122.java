package leetCode;

import java.util.Arrays;

public class Easy_1122 {
	
	/*
		Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
		두 배열 arr1과 arr2가 주어지면, arr2의 모든 요소들은 구분되며(중복값이 없다), arr2의 모든 요소는 arr1에 존재합니다.
		Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
		(의역 많음) arr1에 있는 arr2의 요소들이 같은 순서를 가지도록 정렬하세요. 
		Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
		arr2에 존재하지 않는 요소들은 arr1의 마지막에 오름차순으로 정렬하세요.
		
		Example 1:
		Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
		Output: [2,2,2,1,4,3,3,9,6,7,19]
		
		Example 2:
		Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
		Output: [22,28,8,6,17,44]
		
		public int[] relativeSortArray(int[] arr1, int[] arr2) {
        	//여기에 답 작성
    	}
		
	*/
	
	

	public static void main(String[] args) {
		Easy_1122 ea = new Easy_1122();
		int [] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
		int[] arr2 = {2,42,38,0,43,21};
		ea.relativeSortArray(arr1, arr2);	
	}
	
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] answer = new int[arr1.length];		
		int[] tmp = new int[arr1.length];		
		int count = 0;
		
		for(int i = 0 ; i<arr1.length ; i++) {
			if(indexOf(arr2, arr1[i])!=-1) {
				tmp[count] = arr1[i];
				count++;
			}
		}		
		int[] rest = new int[arr1.length-count];
		for(int i = count ; i<tmp.length ; i++) {
			if(tmp[i]==0) {
				tmp[i] = -1;
			}
		}		
		count = 0;		
		for(int i = 0 ; i<arr1.length ; i++) {
			if(indexOf(arr2, arr1[i])==-1) {
				rest[count] = arr1[i];
				count++;
			}
		}
		Arrays.sort(rest);
		count = 0;
		for(int i = 0; i<arr2.length ; i++) {
			for(int j = 0 ; j<tmp.length ;j++) {
				if(arr2[i]==tmp[j]) {
					answer[count] = tmp[j];
					count++;
				}
			}
		}		
		for(int i = 0; i<rest.length ; i++) {
			answer[count] = rest[i];
			count++;
		}
		return answer;
	}	
	public int indexOf(int[] arr, int nums) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]==nums) {
				return arr[i];
			}
		}
		return -1;
	}
}














