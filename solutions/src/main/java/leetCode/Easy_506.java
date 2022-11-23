package leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Easy_506 {
	/*
			506. Relative Ranks
				
			You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
			길이가 n인 정수배열 score가 주어지면, score[i]는 경기에서 i번째 운동 선수의 점수입니다.
			All the scores are guaranteed to be unique.
			스코어 배열 내의 모든 값은 중복되지 않습니다.
			The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on.
			선수들은 그들의 점수에 따라 위치하는데(순위 매긴다는 뜻), 1등은 가장 높은 점수가, 2등은 두번째로 높은 점수가 주어지며 뒤로 이어집니다. ( 의역입니다 )
			The placement of each athlete determines their rank:
			위치 / 각 운동선수의 / 결정하다 / 그들의 순위 ---> 대충 순위에 따른 위치는 아래와 같이 결정된다. 인듯 합니다.
			The 1st place athlete's rank is "Gold Medal".
			----1등은 금메달
			The 2nd place athlete's rank is "Silver Medal".
			----2등은 은메달
			The 3rd place athlete's rank is "Bronze Medal".
			----3등은 동메달
			For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
			4등부터는 그들의 순위 위치의 숫자입니다. ( 또 의역입니다. 괄호안에선 x위 선수의 순위는 x이다 요지랄 하고있습니다.)
			Return an array answer of size n where answer[i] is the rank of the ith athlete.
			크기가 n인 answer배열을 반환하세요. ( where~~~ 부터는 answer[i]는 각 운동선수의 순위입니다. 라는 뜻 같아요.)
			
			결국은 선수를 순위별로 정렬하고, 1,2,3등에는 gold silver bronze 표시하라는 것 같습니다. 문자열 써야겠네요...
			
			Example 1:

			Input: score = [5,4,3,2,1]
			Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
			Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
			
			Example 2:
			
			Input: score = [10,3,8,9,4]
			Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
			Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
			
			
			public String[] findRelativeRanks(int[] score) {
        		// 여기에 답 작성
    		}
	*/
	
	public static void main(String[] args) {
		Easy_506 ea = new Easy_506();
		
		
		int[] score = {10,3,8,9,4};
		
		ea.findRelativeRanks(score);
	}
	
	
	public String[] findRelativeRanks(int[] score) {
		int length = score.length;
		String[] answer = new String[length];
		Map<Integer, String> map = new HashMap<>();
		int[] array = new int[length];
		
		for(int i = 0 ; i<length;i++) {
			array[i] = score[i];
		}
		Arrays.sort(array);
		
		int[] array2 = new int[length];
		for(int i = 0 ; i<length ; i++) {
			array2[length-(i+1)] = array[i];
		}
		
		for(int i = 0 ; i<length ; i++) {
			map.put(array2[i], String.valueOf(i+1));
		}		
		
		for(int i = 0 ; i<length ; i++) {
			if(map.get(score[i]).equals("1")) {
				answer[i] = "Gold Medal";
			}else if(map.get(score[i]).equals("2")){
				answer[i] = "Silver Medal";
			}else if(map.get(score[i]).equals("3")) {
				answer[i] = "Bronze Medal";
			}else {
				answer[i] = map.get(score[i]);
			}
		}
		return answer;
	}
}
