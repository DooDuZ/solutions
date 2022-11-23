package leetCode;

import java.util.ArrayList;

public class Easy_1848 {
	/*
		1848. Minimum Distance to the Target Element
		
		Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target and abs(i - start) is minimized. 
		정수배열 nums와 두 정수 target과 start가 주어지면, nums[i]==target인 인덱스 i와 가장작은 abs(i-start)를 찾으세요.
		Note that abs(x) is the absolute value of x.
		abs(x)는 절대값입니다. 
		Return abs(i - start).
		abs(i-start)를 반환하세요.		
		It is guaranteed that target exists in nums.
		모든 타겟은 nums안에 존재합니다.
		
		정수 배열 nums , int target, int start를 줄테니
		nums안에서 target의 인덱스를 찾은 후, |index-start|가 가장 작아지는 값을 찾으라는 문제같습니다.
		말만 배배 꼬아놓은 정말 거지같은 문제네요 ㅎㅎ...
		
		Example 1:
		Input: nums = [1,2,3,4,5], target = 5, start = 3
		Output: 1
		Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
		
		Example 2:		
		Input: nums = [1], target = 1, start = 0
		Output: 0
		Explanation: nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.
		
		Example 3:		
		Input: nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
		Output: 0
		Explanation: Every value of nums is 1, but nums[0] minimizes abs(i - start), which is abs(0 - 0) = 0.
		
		public int getMinDistance(int[] nums, int target, int start) {
        	// 여기에 답 작성
    	}
 
    	Constraints:
			1 <= nums.length <= 1000
			1 <= nums[i] <= 104
			0 <= start < nums.length
			target is in nums.
    	
	*/
	
	public static void main(String[] args) {
		Easy_1848 ea = new Easy_1848();
		int[] nums = {1,1,1,1,1,1,1,1,1,1};
		int target = 1;
		int start = 0;		
		System.out.println(ea.getMinDistance(nums, target, start));		
	}
	
	
	public int getMinDistance(int[] nums, int target, int start) {
		int answer;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i<nums.length ; i++) {
			if(nums[i]==target) {
				list.add(i);
			}
		}
		
		int min = 1000;
		
		for(int i = 0 ; i<list.size(); i++) {
			int x = list.get(i)-start;
			if(x<0) {
				x *= -1;
			}
			if(min>x) {
				min = x;
			}
		}
		
		answer = min;
		return answer;
	}	
}
