package leetCode;

import java.util.Arrays;

public class Easy_1636Solution {
	
	
	
	// 푸는중
	
	/*
		Given an array of integers nums, sort the array in increasing order based on the frequency of the values. 
		정수 배열이 주어지면, 각 값들의 반복 빈도를 기준으로 내림차순으로 정렬 하세요.
		If multiple values have the same frequency, sort them in decreasing order.
		같은 빈도수를 가진 값이 있다면, 그 값의 크기에 따라 내림차순 정렬하세요.		
		Return the sorted array.
		정렬된 배열을 반환하세요.
	*/
	
	public static void main(String[] args) {
		Easy_1636Solution ea = new Easy_1636Solution();
		
		int[] nums = {-1,1,-6,4,5,-6,1,4,1};
		
		int[] answer = ea.frequencySort(nums);
		
		for(int tmp : answer) {
			System.out.print(tmp+" ");
		}
	}
		
	public int[] frequencySort(int[] nums) {
		int length = nums.length;
        int[] answer = new int[length];
        int[] checkCount = new int[length];
        int maxCount = 0;
        
        Arrays.sort(nums);        
        
        for(int i = 0; i<length ; i++) {
        	int count = 0;
        	for(int j = 0 ; j<length ; j++) {
        		if(nums[i]==nums[j]) {
        			count++;
        		}
        	}
        	checkCount[i] = count;
        	if(i==0) {
        		maxCount = count;
        	}else if(maxCount<count){
        		maxCount = count;
        	}
        }
        int count = length-1;
        while(true) {	        
	        for(int i = 0 ; i<length ; i++) {
	    		if(checkCount[i]==maxCount) {
	        		answer[count] = nums[i];
	        		checkCount[i] = 0;
	        		count--;
	        	}
	        }
	        maxCount = 0; 
	        for(int i = 0 ; i< length ; i++) {
	        	if(checkCount[i]>maxCount) {
	        		maxCount = checkCount[i];
	        	}
	        }
	        if(maxCount==0) {
	        	break;
	        }
        }
        return answer;
    }
}
