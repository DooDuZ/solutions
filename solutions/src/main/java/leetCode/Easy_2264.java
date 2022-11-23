package leetCode;

import java.util.ArrayList;

public class Easy_2264 {
	
	/*
		2264. Largest 3-Same-Digit Number in String
		
		You are given a string num representing a large integer. An integer is good if it meets the following conditions:
		당신에게 큰 정수로 이루어진 문자열이 주어집니다. 정수가 아래의 조건을 만족하면 good.. 이래요. 뭐래는겨 양놈들아...
		It is a substring of num with length 3.
		문자열num에서 3글자씩 substring합니다.
		It consists of only one unique digit.
		같은 숫자 3개로 이루어져 있습니다.
		Return the maximum good integer as a string or an empty string "" if no such integer exists.
		가장 큰 good상태의 정수를 리턴하거나, 그런 정수가 없다면 공백("")을 리턴하세요.
		
		Note:		
		A substring is a contiguous sequence of characters within a string.
		substring에 대한 설명. 문자열 내의 하위 문자열 어쩌고~ 여긴 신경 쓸 필요없습니다.
		There may be leading zeroes in num or a good integer.
		good Integer는 0으로 시작할 수 있다네요. 000도 리턴 대상이 된다는 뜻입니다.
		

	    public String largestGoodInteger(String num) {
	        // 여기에 답 작성
	    }

	*/
	public static void main(String[] args) {
		Easy_2264 ea = new Easy_2264();
		String num = "42352338";
		
		ea.largestGoodInteger(num);
	}
	
	
	public String largestGoodInteger(String num) {        
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        int index = 0;
        int max = 0;
        
        for(int i = 0 ; i<num.length()-2 ; i++) {
        	String tmp = num.substring(i, i+3); 
        	if ( tmp.charAt(0) == tmp.charAt(1) && tmp.charAt(1) == tmp.charAt(2) ) { 
        		list.add(tmp);
        		if(tmp.charAt(0)>max) {
        			max = tmp.charAt(0);
        			index = count;
        		}
        		count++;
        	}        	
        }
        if(count>0) {     
            return list.get(index);  
        }else {
        	return "";
        }        
    }

}
