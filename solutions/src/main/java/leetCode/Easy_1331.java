package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy_1331 {
	/*
		1331. Rank Transform of an Array
			  순위 변환		/	배열의 
		
		Given an array of integers arr, replace each element with its rank.
		정수배열 arr이 주어지면, 각 요소를 순위에 맞춰 재배치하세요.
		The rank represents how large the element is. The rank has the following rules:
		순위는 요소의 크기에 해당합니다. 순위는 아래의 규칙을 따릅니다.
		Rank is an integer starting from 1.
		순위는 정수이며 1부터 시작합니다.		
		The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
		더 큰 요소는 더 큰 숫자의 랭크를 가집니다. 만약 두개의 요소가 같다면, 그 요소들의 순위는 같습니다.
		Rank should be as small as possible.
		순위는 가능한 작아야합니다.  -->  예를들면 1위가 4개 있다고 5위부터 시작하지말고, 그 다음으로 작은 숫자에 2위를 부여하라는 얘기같습니다.
		
		Example 1:
		Input: arr = [40,10,20,30]
		Output: [4,1,2,3]
		Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
		
		Example 2:
		Input: arr = [100,100,100]
		Output: [1,1,1]
		Explanation: Same elements share the same rank.
		
		Example 3:		
		Input: arr = [37,12,28,9,100,56,80,5,12]
		Output: [5,3,4,2,8,6,7,1,3]
		
		Constraints:
			* 0 <= arr.length <= 10^5
			* -10^9 <= arr[i] <= 10^9
		
		public int[] arrayRankTransform(int[] arr) {
        	// 여기에 답 작성
    	}
	*/
	
	public static void main(String[] args) {
		Easy_1331 ea = new Easy_1331();
		int[] arr = {37,12,28,9,100,56,80,5,12};
		ea.arrayRankTransform(arr);
	}
	
	
	/*
		시간 복잡도는 혼자 해결하기가 어려울거라 생각해서 discuss 참고
		참고라기엔 한참 읽었으니 그냥 답지 배낀 수준입니다
		일단 기본적으로 배열 파라미터의 각 element마다 대응하는 rank를 만든다는 개념까진 같았습니다만
		결국 활용 방식에서 최적화 차이가 엄청나게 났습니다
		저는 익숙한 개념만 어느정도 사용할 뿐 응용에 정말 약하다는 걸 깨닫게된 문제였네요
		전 가망이 없으니 여러분이 잘해져서 저좀 끌어주십시오...
	*/
	public int[] arrayRankTransform(int[] arr) {
    	int length = arr.length;
    	// 시간복잡도가 높은 문제이다보니, 줄일 수 있는 건 줄여주겠습니다.
		// 배열의 길이를 메서드를 통해 계속 호출하지 않도록, 길이를 변수 하나에 담아줍니다.
		int[] answer = new int[length];	// 제출 배열
    	int[] arrsorted = new int [length];	// 정렬용 배열
    	
    	for(int i = 0 ; i<length ; i++) {
    		arrsorted[i] = arr[i];		// 정렬용 배열에 파라미터로 받은arr을 그대로 복사한 후
    	}
    	Arrays.sort(arrsorted);
    	// 정렬. arrays 클래스의 sort메서드는 경우에 따라 연산 속도가 달라지지만, 그래도 무난하게 사용하기 좋은 속도를 가졌습니다.
    	// (최악) n^2 ~ n log n 의 시간복잡도를 가지는 것으로 읽었었고, 아마도 최악의 경우는 적은 것보다 값이 적을 수 있습니다.(기억이 정확하지 않을 수 있다는 말입니다.)
    	if(length==0) {	//입력받은 배열이 null 이라면
    		return arr;	// 리턴
    	}
    	
    	int count = 1; // 1위부터 시작합니다.
    	
    	Map<Integer, Integer> map = new HashMap<>();	// 중복key를 허용하지 않는 HashMap 객체를 만들어 준 뒤
    	map.put(arrsorted[0], count);					// 첫번째 값을 push해 줍니다.
    													// 값 하나를 먼저 넣는 이유는, 아래 반복문에서 nullpointerException을 피하기 위함입니다.
    													// 배열 문제를 풀 때 outOfBoundException을 피하기 위한 식이나 코드를 정하는 것과 비슷한 이유입니다.
    	for(int i = 1; i<length ; i++) {				// arrsorted의 0번인덱스는 사용했으니 1부터
    		if(arrsorted[i]!=arrsorted[i-1]) {			// 이어지는 값이 앞의 값과 다르면
    			count++;								// count에 1을 더한 후
    			map.put(arrsorted[i], count);    		// 해당 값을 key로 사용하여, count를 value로 넣어줍니다.
    		}
    	}
    	// 이렇게 arr의 element를 식별키로 사용해서 특정key->값을 가진 map 객체를 만들었습니다.
    	// hashmap의 세팅이 끝나면
    	for(int i = 0; i<length ; i++) {
    		answer[i] = map.get(arr[i]);		// 제출 배열의 i번째 인덱스마다 map에서 arr[i]키에 대응하는 값을 넣어줍니다. 
    	}
    	return answer;		// 제출하니 40ms의 런타임이 나오네요.
	}
	
	/*
		[시간 초과 답안]
		leet에서 시간 초과라니.. 세상에...
		* 0 <= arr.length <= 10^5 --> n = length 이면
		* 시간복잡도가 10^10까지 올라갈 수 있는(심지어 여러번 써야함) for문을 이용한 인덱스 순회는 매우 비효율적...
		* 결국 컬렉션에 내장된 특정 기능들을 사용해야 할 것 같다
	
		public int[] arrayRankTransform(int[] arr) {
	    	int[] indexRank = new int[arr.length];
			ArrayList<Integer> list = new ArrayList<>();
	    	for(int i = 0 ; i<arr.length ; i++) {
	    		if(!list.contains(arr[i])) {
	    			list.add(arr[i]);
	    		}
	    	}
	    	ArrayList<Integer> listRank = new ArrayList<>();
	    	for(int i = 0 ; i<arr.length ; i++) {
	    		listRank.add(list.size());
	    	}
	    	for(int i = 0 ; i<list.size(); i++) {
	    		for(int j = 0 ; j<list.size() ; j++) {
	    			if(list.get(i)<list.get(j)) {
	    				listRank.set(i, listRank.get(i)-1);
	    			}
	    		}
	    	}
	    	for(int i = 0 ; i<list.size(); i++) {
	    		for(int j = 0 ; j<arr.length; j++) {
	    			if(list.get(i)==arr[j]) {
	    				indexRank[j] = listRank.get(i); 
	    			}
	    		}
	    	}
			return indexRank;
		}
	*/
}
