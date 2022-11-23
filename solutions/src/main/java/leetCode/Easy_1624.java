package leetCode;

public class Easy_1624 {
	
	
	/*
	 	Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
	 	문자열s가 주어지면, 같은 두 문자 사이에서 두 문자를 제외한 길이중 가장 깃 길이를 리턴하시오. 
	 	If there is no such substring return -1.
		만약 분할될 구간이 없다면 -1을 리턴하시오 (같은 문자가 없으면)
		A substring is a contiguous sequence of characters within a string.
		하위 문자열은 문자열 내의 연속된 문자 시퀀스입니다. -> 먼 개소린지 모르겠음. 또 무슨 정의를 내려주는 것 같습니다.
		Example 1:

		Input: s = "aa"
		Output: 0
		Explanation: The optimal substring here is an empty substring between the two 'a's.
		Example 2:
		
		Input: s = "abca"
		Output: 2
		Explanation: The optimal substring here is "bc".
		Example 3:
		
		Input: s = "cbzxy"
		Output: -1
		Explanation: There are no characters that appear twice in s.
		
		public int maxLengthBetweenEqualCharacters(String s) {
        	// 여기에 답 작성
    	}
	
	*/
	public static void main(String[] args) {
		Easy_1624 ea = new Easy_1624();
		String s ="mgntdygtxrvxjnwksqhxuxtrv";
		System.out.println(ea.maxLengthBetweenEqualCharacters(s));
		
	}
	
	public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1 ;
        int[] arr = new int[s.length()];
        boolean check = false;
        for(int i=0; i<s.length() ; i++) {
        	boolean icheck = false;
        	int imax = 0;
        	for(int j = i+1 ; j<s.length() ; j++) {
        		if(s.charAt(i)==s.charAt(j)) {
        			check = true;
        			icheck = true;
        			if(j-i>imax) {
        				imax = j-i-1;
        			}
        		}
        	}
        	if(icheck) {
    			arr[i] = imax;
    		}
        }
        for(int i = 0 ; i<s.length() ; i++) {
        	if(arr[i]>max) {
        		max = arr[i];
        	}
        }
        if(check) {
        	return max;
        }else {
        	return -1;
        }
    }
}
