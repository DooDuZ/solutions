package leetCode;

public class Easy_1758 {
	/*
		1758. Minimum Changes To Make Alternating Binary String
				교차 이진 문자열을 만들기 위한 최소 교환
		
		You are given a string s consisting only of the characters '0' and '1'.
		0과 1로만 이루어진 문자열 s가 주어집니다.
		In one operation, you can change any '0' to '1' or vice versa.
		한번의 작업에서, 당신은 0과 1이나, 그 반대(1과 0)을 바꿀 수 있습니다.
		The string is called alternating if no two adjacent characters are equal.
		만약 두 인접한 문자가 같지 않다면, 그 문자열은 alternating이라고 부를 수 있습니다.
		For example, the string "010" is alternating, while the string "0100" is not.
		예를들면 010은 alternating이지만, 0100은 그렇지 않습니다.
		Return the minimum number of operations needed to make s alternating.
		s를 alternating으로 만들기 위한 최소값을 반환하세요.
		
		
		Example 1:
		Input: s = "0100"
		Output: 1
		Explanation: If you change the last character to '1', s will be "0101", which is alternating.
		
		Example 2:		
		Input: s = "10"
		Output: 0
		Explanation: s is already alternating.
		
		Example 3:		
		Input: s = "1111"
		Output: 2
		Explanation: You need two operations to reach "0101" or "1010".
		
		Constraints:		
		1 <= s.length <= 10^4
		s[i] is either '0' or '1'.
		
		public int minOperations(String s) {
        	// 여기에 답 작성
    	}
	*/
	
	public static void main(String[] args) {
		Easy_1758 ea = new Easy_1758();
		
		String s= "10";
		System.out.println(ea.minOperations(s));
	}
	
	
	public int minOperations(String s) {
		int answer;
		int length = s.length();		
		int startZero = 0;
		int startOne = 0;	
		
		for(int i = 0 ; i<length ; i++) {
			if( (i%2==0 && s.charAt(i)=='0') || (i%2==1 && s.charAt(i)=='1') ) {
				startOne++;
			}else if( (i%2==1 && s.charAt(i)=='0') || (i%2==0 && s.charAt(i)=='1')){
				startZero++;
			}
		}		
		if(startZero>startOne) {
			answer = startOne;
		}else {
			answer = startZero;
		}
		return answer;
	}
	
}
