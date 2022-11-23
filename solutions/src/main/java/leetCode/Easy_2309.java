package leetCode;

public class Easy_2309 {
	
	/*
		Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s.
		영문 문자열 s가 주어지면, s에 소문자와 대문자가 모두 존재하면서 가장 큰(알파벳 후순위)문자를 반환하세요.
		The returned letter should be in uppercase. If no such letter exists, return an empty string.
		반환된 문자는 대문자여야 합니다. 만약 그런 문자가 존재하지 않는다면, 공백을 반환하세요.
		An English letter b is greater than another letter a if b appears after a in the English alphabet.
		--> 크다의 정의에 대한 설명입니다.
		만약 어떤 문자b가 문자a보다 알파벳에서 뒤에 있다면, 문자b는 a보다 더 큽니다.	
		
		
	    public String greatestLetter(String s) {
			// 여기에 답 작성
	    }
	    
	
	*/
	
	
	public static void main(String[] args) {
		String s = "lEeTcOdE";
		
		Easy_2309 ea = new Easy_2309();
		System.out.println(ea.greatestLetter(s));		
	}
	
	// 지웅 풀이
	public String greatestLetter(String s) {
		
		char[] sIndex = new char[s.length()];
		char answer = '\u0000';
		
		String answer2 = "";
		
		for(int i = 0 ; i<s.length() ; i++) {
			sIndex[i] = s.charAt(i);
		}
		for( int i = 0 ; i<s.length() ; i++) {
			for(int j = 0 ; j<s.length() ; j++) {
				if(sIndex[i]+32 == sIndex[j]) {
					if(answer==0) {
						answer = sIndex[i];
					}else if(answer<sIndex[i]){
						answer = sIndex[i];
					}
				}
			}
		}
		
		if(answer!='\u0000') {
			answer2 += answer;
		}	
		return answer2;		
    }
	

	
	/*
		[다른 정답자 참고]
		https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/discuss/2168670/java-ASCII
		toString 컴파일 에러 문제로 일부 수정		
		
		public String greatestLetter(String s) {
		char[] letters = new char[123];
		String answer = "";
		
		for(int i = 0; i != s.length(); i++) {
			letters[(int)s.charAt(i)] = 1;
		}
		for(int i = 122; i != 96; i--) {
			if(letters[i] == 1 && letters[i-32] == 1) {
				char answerLetter = (char)(i-32);
				answer += answerLetter;
			}
		}		
		return answer;
	}
		
    */
}
