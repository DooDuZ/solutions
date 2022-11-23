package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Easy_1002 {

	/*
		Given a string array words, return an array of all characters that show up in all strings within the words 
		(including duplicates).
		문자열 배열 words가 주어지면, words내의 모든 문자열에 표시되는 문자들을 반환하세요. ( 중복 포함 )
		You may return the answer in any order.
		반환하는 순서는 상관없습니다.
		
		Example 1:
		Input: words = ["bella","label","roller"]
		Output: ["e","l","l"]
		
		Example 2:		
		Input: words = ["cool","lock","cook"]
		Output: ["c","o"]
		

	    public List<String> commonChars(String[] words) {
	        // 여기에 답지 작성
	    }		
	*/
	
	public static void main(String[] args) {
		Easy_1002 ea = new Easy_1002();
		String[] words = {"cool","lock","cook"};
		
		for(String tmp : ea.commonChars(words)) {
			System.out.println(tmp);
		}
		
	}
	
	public List<String> commonChars(String[] words) {
		ArrayList<String> list = new ArrayList<>();
		boolean[] arr = new boolean[26];
		
		for(int i = 0 ; i<words[0].length() ; i++) {
			arr[words[0].charAt(i)-97] = true;
		}

		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i]) {
				for(int j = 0 ; j<words.length ; j++) {
					int count=0;
					for(int k = 0 ; k<words[j].length() ; k++) {
						if(words[j].charAt(k)==i+97) {
							count++;
						}
					}
					if(count==0){
						arr[i] = false;
					}
				}
			}
		}
		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i]) {
				int min = 101;
				for(int j = 0 ; j< words.length ; j++) {
					int count = 0;
					for(int k = 0 ; k<words[j].length() ; k++) {
						if(words[j].charAt(k)==i+97) {
							count++;
						}
					}
					if(min>count) {
						min = count;
					}		
				}
				char character = (char)(i+97);
				for(int k = 0 ; k<min ; k++) {
					list.add(String.valueOf(character));
				}
			}
		}		
		return list;
    }	
}
