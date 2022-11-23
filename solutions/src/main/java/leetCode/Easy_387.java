package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy_387 {
	
	
	/*
	 	387. First Unique Character in a String
	 	
	 	Given a string s, find the first non-repeating character in it and return its index.
	 	String s가 주어지면, 반복되지 않는 첫번째 문자를 찾아 그 문자의 인덱스를 리턴하세요.
	 	If it does not exist, return -1.
	 	만약 존재하지 않는 경우 -1을 리턴하세요.
	 	
	 	Example 1:
		Input: s = "leetcode"
		Output: 0
		
		Example 2:
		Input: s = "loveleetcode"
		Output: 2
		
		Example 3:
		Input: s = "aabb"
		Output: -1
		
		
		Constraints:
		1 <= s.length <= 10^5
			// 이거 보니 무지성 반복문 도배했다간 바로 시간초과 나올 것 같습니다. 
		s consists of only lowercase English letters.
		s는 소문자로만 구성되어 있습니다.		
	 	
	 	public int firstUniqChar(String s) {
        	// 여기에 답 작성
    	}
	*/
	
	public static void main(String[] args) {
		Easy_387 ea = new Easy_387();
		
		String s = "aabb";	// ll oo v eee t c d 
		
		System.out.println(ea.firstUniqChar(s));
	}
	
	
	public int firstUniqChar(String s) {
    	int answer = -1;
    	int length = s.length();
    	
    	char[] arr = new char[length];
    	for(int i = 0 ; i<length ; i++) {
    		arr[i] = s.charAt(i);
    	}
    	Arrays.sort(arr);    	
    	Map<Character, Integer> map = new HashMap<>();
    		// 해시맵을 사용하는 이유는 easy_1331에 있습니다. 이유라기보단 사용법이겠네요.
    	int count = 1;
    	for(int i = 0 ; i<length ; i++) {
    		if(i==length-1) {
    			// i번째와 i+1번째를 비교하고 있기 때문에, outofbounds예외를 피하기 위해 마지막 항의 검사 조건을 설정해 줍니다.
    			if(map.containsKey(arr[i])) {
    				continue;
    			}else {
    				map.put(arr[i], count);
    				continue;
    			}
    		}
    		if(arr[i]==arr[i+1]) {
    			count++;
    		}else {
    			map.put(arr[i], count);
    			count = 1;
    		}
    	}
    	for(int i = 0 ; i<length ; i++) {
    		if(map.get(s.charAt(i))==1) {
    			answer = i;
    			break;
    		}
    	}
		return answer;
	}
}
