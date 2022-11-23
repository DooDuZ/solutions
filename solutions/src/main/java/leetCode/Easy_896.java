package leetCode;

public class Easy_896 {
	/*
	
		896. Monotonic Array
		
		
		An array is monotonic if it is either monotone increasing or monotone decreasing.
		단순하게 증가, 감소 배열은 monotonic합니다. ( 단순하다는 뜻인데, monotonic 이라는 어떤 상태를 정의한다고 보는게 맞을 것같습니다.)  
		An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
		만약 i가 j보다 크고, nums[i]가 nums[j]보다 크면 nums배열은 단순 증가 상태입니다.
		An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
		만약 i가 j보다 크고, nums[i]가 nums[j]보다 작으면 nums배열은 단순 감소 상태입니다.
		Given an integer array nums, return true if the given array is monotonic, or false otherwise.
		정수배열 nums가 주어졌을 때, 배열이 monotonic상태이면 true를, 아니면 false를 반환하세요.
		
		Example 1:	
		Input: nums = [1,2,2,3]
		Output: true
		
		Example 2:		
		Input: nums = [6,5,4,4]
		Output: true
		
		Example 3:		
		Input: nums = [1,3,2]
		Output: false	
		
		Constraints:

		1 <= nums.length <= 10^5
		-10^5 <= nums[i] <= 10^5
		
		public boolean isMonotonic(int[] nums) {
        	// 여기에 답 작성
    	}
	*/
	
	public static void main(String[] args) {
		Easy_896 ea = new Easy_896();
		
		int[] nums = {1,1,0};
		System.out.println(ea.isMonotonic(nums));
	}
	
	
	public boolean isMonotonic(int[] nums) {
		boolean answer = true;
		int startNo=0;
		for(int i = 0; i<nums.length-1 ; i++) {
			if(nums[i]!=nums[i+1]) {
				startNo = i;
			}
		}
		if(startNo+1>=nums.length) {
			return true;
		}
			
		if(nums[startNo]<nums[startNo+1]) {
			for(int i = 0 ; i<nums.length-1; i++) {
				if(nums[i]>nums[i+1]) {
					answer = false;
				}
			}
		}else {
			for(int i = 0 ; i<nums.length-1; i++) {
				if(nums[i]<nums[i+1]) {
					answer = false;
				}
			}
		}	
		return answer;
	}
}
