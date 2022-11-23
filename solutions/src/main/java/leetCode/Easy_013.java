package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Easy_013 {
	/*
	 	13. Roman to Integer
	 		Roman(로마숫자) to(->) Integer(정수)
	 		
	 	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	 	로마 숫자들은 일곱개의 다른 심볼을 보여줍니다.(represent -> 대표하다/대변하다 를 의역했습니다.)
	 	
	 	Symbol       Value
	 	
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		
		
		For example, 2 is written as II in Roman numeral, just two ones added together.
		예를 들면, 2는 로마 숫자로 II로 적을 수 있습니다.(, 뒤는 1을 두번 더해서... 이런 말) 
		12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
		12는 10에 해당하는 X와 2에 해당하는 II를 더해서 XII로 적습니다. 27은 XX(20)+V(5)+II(2)로 구성하여 XXVII로 적습니다.
		Roman numerals are usually written largest to smallest from left to right.
		로마 숫자는 보통 가장 큰 숫자부터 가장 작은 숫자로 왼쪽에서 오른쪽으로 적습니다.
		However, the numeral for four is not IIII. Instead, the number four is written as IV.
		그러나 4는 IIII로 적는 대신 IV로 적습니다.
		Because the one is before the five we subtract it making four.
		5에서 1을 뺄셈하면 4가 만들어지기 때문입니다.
		The same principle applies to the number nine, which is written as IX.
		동일한 규칙이 9에도 적용됩니다. (9는 IX로 적힙니다.)
		There are six instances where subtraction is used:
		6가지 경우의 뺄셈이 있습니다.
		I can be placed before V (5) and X (10) to make 4 and 9.
		1은 4나 9를 만들기 위해 5와 10 전에 위치합니다. 
		X can be placed before L (50) and C (100) to make 40 and 90.
		10은 40과 90을 만들기위해 50과 100 전에 위치합니다. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		C는 400과 900을 만들기 위해 500과 1000앞에 위치합니다.
		Given a roman numeral, convert it to an integer.
		로마 숫자가 주어지면, 정수로 변환하세요.
		
		Constraints:

		1 <= s.length <= 15
		s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
		It is guaranteed that s is a valid roman numeral in the range [1, 3999].
		
		public int romanToInt(String s) {
        	// 여기에 답 작성
    	}	 	
	*/
	
	public static void main(String[] args) {
		Easy_013 ea = new Easy_013();
		
		String s = "MDCXCV";
		System.out.println(ea.romanToInt(s));		
	}
	
	
	public int romanToInt(String s) {
    	int answer = 0;
    	int length = s.length();
    	char[] subtractor = {'I','X','C'};
    	char[] roman = {'I','V','X', 'L','C','D','M'};
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	int sum = 0;
    	boolean lastindex = true;
    	for(int i = 0 ; i<length ; i++) {
    		if(i==length-1 && !lastindex) {
    			break;
    		}else if(i==length-1){
    			sum += map.get(s.charAt(i));
    			break;
    		}
    		if(indexof(s.charAt(i), subtractor) !=-1) {
    			if( indexof(s.charAt(i+1), roman)-indexof(s.charAt(i), roman)==1 ||
    				indexof(s.charAt(i+1), roman)-indexof(s.charAt(i), roman)==2){
	    			
	    			sum += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
	    			if(i==length-2) {
	    				lastindex = false;
	    			}
	    			i++;
	    		}else {
	    			sum += map.get(s.charAt(i));
	    		}    			
    		}else {
    			sum += map.get(s.charAt(i));
    		}   				     		
    	}    	
    	answer = sum;
    	return answer;
	}
	int indexof(char a, char[] chars) {
		for(int i = 0 ; i<chars.length ; i++) {
			if(chars[i]==a) {
				return i;
			}
		}
		return -1;
	}
}
