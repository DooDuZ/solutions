package leetCode;

public class Easy_1437 {
	
	/*
		1437. Check If All 1's Are at Least Length K Places Away
		
		
		Given an binary array nums and an integer k, 
		이진 배열 nums와 정수 k가 주어지면
		return true if all 1's are at least k places away from each other, otherwise return false.
		모든 1이 서로 최소 k만큼 떨어져있다면 true, 아니라면 false를 리턴하시오
		
		public boolean kLengthApart(int[] nums, int k) {
        	// 여기에 답 작성
    	}
	*/
	public static void main(String[] args) {
		Easy_1437 ea = new Easy_1437();
		
		int[] nums = {1,0,0,1,0,1};
		int k = 2;
		System.out.println(ea.kLengthApart(nums,k));
		
		
	}
	
	
	public boolean kLengthApart(int[] nums, int k) {
		
		boolean check = true;
		boolean findFirst = false;
		int count = 0;
		
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i]==1 && findFirst==false) {
				findFirst = true;
				continue;
			}
			if(findFirst && nums[i]==0) {
				count++;
			}
			if(nums[i]==1) {
				if(count<k) {
					check = false;
					break;
				}
				count = 0;
			}
		}
		return check;
    }	
}
