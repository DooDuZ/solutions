package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Easy_412 {
	/*
	 	Given an integer n, return a string array answer (1-indexed) where:
		정수 n이 주어지면, 아래 항목에 맞는 문자열 배열 answer를 반환하시오.
		answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
		answer[i]가 3과 5의 공배수이면 "FizzBuzz"		
		
		answer[i] == "Fizz" if i is divisible by 3.
		answer[i]가 3의 배수이면 "Fizz"
		
		answer[i] == "Buzz" if i is divisible by 5.
		answer[i]가 5의 배수이면 "Buzz"
		
		answer[i] == i (as a string) if none of the above conditions are true.
		answer[i]가 위의 조건에 해당하지 않으면 숫자 i(문자열 타입 변환)
		
		Example 3 : // 더 많은 예시는 leetcode 참조

		Input: n = 15
		Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
		
		// 제출 폼
		
		public List<String> fizzBuzz(int n) {
        	// 여기에 답 작성
        	// 반환 타입이 array가 아니라 List<String> 입니다. 주의하세요!!
    	}
	*/
	
	public List<String> fizzBuzz(int n) {
    	ArrayList<String> answer = new ArrayList<>();	// 어떤 이유에서인지 List 객체를 생성할 때 컴파일 에러가 발생하여 ArrayList<String> 사용
    													// 상속 개념일 거라 생각했습니다만, ctrl 클릭으로 확인해보니 ArrayList가 List인터페이스의 구현 클래스네요. 
    													// 인터페이스의 구현 클래스와 구현클래스의 자식클래스는 인터페이스 타입으로 자동 형변환이 가능합니다.
    	for(int i = 1 ; i<=n ; i++) {	//ArrayList 타입은 인덱스 관리를 자동으로 해주기 때문에, 0번부터 시작할 필요가 없습니다.
    		if(i%3==0 && i%5==0) {
    			answer.add("FizzBuzz");
    		}else if(i%3==0){
    			answer.add("Fizz");
    		}else if(i%5==0){
    			answer.add("Buzz");
    		}else {
    			answer.add(Integer.toString(i));
    		}
    	}    	
    	return answer;
	}	
}


















