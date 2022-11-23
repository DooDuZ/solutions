package leetCode;

import java.util.ArrayList;

public class Easy_1629 {
	/*
	  	A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.
	
		You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both arrays are 0-indexed.
		
		The 0th key was pressed at the time 0, and every subsequent key was pressed at the exact time the previous key was released.
	
		The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].
	
		Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key may not have had the same duration.
	
		Return the key of the keypress that had the longest duration. If there are multiple such keypresses, return the lexicographically largest key of the keypresses.
	
	 	번역 포기
	 	LeetCode 1629번 문제에서 예시 참고하여 푸셔요...
	 	
		 
		public char slowestKey(int[] releaseTimes, String keysPressed) {
	        // 여기에 답 작성
	    }
	 
	*/
	
	public static void main(String[] args) {
		Easy_1629 ea = new Easy_1629();
		
		int[] releaseTimes = {9,29,49,50};
		String keysPressed = "cbcd"; 

		
		System.out.println(ea.slowestKey(releaseTimes, keysPressed));
		
	}
	
	public char slowestKey(int[] releaseTimes, String keysPressed) { 
		int[] lengthOfIndex = new int[releaseTimes.length];
		int max = 0;
		for(int i = 0; i<releaseTimes.length ; i++) {
			if(i==0) {
				lengthOfIndex[i] = releaseTimes[i]-0;
				max = lengthOfIndex[i];
			}else {
				lengthOfIndex[i] = releaseTimes[i]-releaseTimes[i-1];
				if(lengthOfIndex[i] > max) {
					max = lengthOfIndex[i];
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		int count = 0 ;
		for(int i = 0 ; i<lengthOfIndex.length ;i++) {
			if(lengthOfIndex[i]==max) {
				count++;
				list.add(i);
			}
		}		
		if(count==1) {
			return keysPressed.charAt(list.get(0));
		}else {
			int largestChar = 0;
			for(int i = 0; i<count ; i++) {
				if(keysPressed.charAt(list.get(i))>(char) largestChar) {
					largestChar = keysPressed.charAt(list.get(i));
				}
			}
			return (char)largestChar;
		}
	}
}
