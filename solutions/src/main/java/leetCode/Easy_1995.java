package leetCode;

public class Easy_1995 {
	/*
		Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
		정수 배열 nums가 주어지면,~~~ 아래 의역 참고
		nums[a] + nums[b] + nums[c] == nums[d], and a < b < c < d.
		
		//// 의역주의
		겹치지 않는 nums의 element 4개를 골라 더한 뒤, 그 값이 배열 내에 존재하는 경우의 수를 반환하라는 문제입니다.
		
		Example 1:

		Input: nums = [1,2,3,6]
		Output: 1
		Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.
		
		Example 2:
		
		Input: nums = [3,3,6,4,5]
		Output: 0
		Explanation: There are no such quadruplets in [3,3,6,4,5].
		
		Example 3:
		
		Input: nums = [1,1,1,3,5]
		Output: 4
		Explanation: The 4 quadruplets that satisfy the requirement are:
		- (0, 1, 2, 3): 1 + 1 + 1 == 3
		- (0, 1, 3, 4): 1 + 1 + 3 == 5
		- (0, 2, 3, 4): 1 + 1 + 3 == 5
		- (1, 2, 3, 4): 1 + 1 + 3 == 5
		
		문제 이해가 어려운 분들은... 물어보세요..! 설명하기 어렵습니다.
		
		public int countQuadruplets(int[] nums) {
        	//여기에 답 작성
    	}
		
	*/
	/* 
	오답이 거듭되고... 사실 틀린 경우에 leetcode는 해당 케이스의 데이터를 주기 때문에 그걸로도 비교를 해봤는데
	결론은 문제 이해 자체가 좀 잘못됐다로 결론이 났습니다. 
	제가 해석한 대로 구현하면 최초 제출 코드가 맞았고 몇가지 케이스에 맞춰 코드를 수정했습니다만,
	결국 leet에서 요구하는 output이 제가 이해한 문제의 결론과 다르더군요.
	문제 자체가 잘못된 건 아닌가 싶어서 discuss란에서 java를 검색했는데 풀이들이 나오고
	그 풀이들이 제 코드와 매우 유사한 걸 보면
	결론적으로 문제 해석에서 세부적인 부분에 오역이 있다는 말이기 떄문에...
	일단 이 문제는 넘어가겠습니다.
	경우의 수를 고민하고 그 데이터를 구현했다는 점에서 제출값이 통과되고 아니고를 떠나
	공부의 측면에서 유익하긴 했던 문제같습니다
	다만,
	풀지말고 걍 넘어가세요... 오역인데 구태여 달려들 필요 없겠습니다.
	푸시려면 글로 다시 작성하기 어려우니
	문제를 직접 해석하시거나, 제게 물어보시는 걸 권합니다.
	
	--오역 부분
		마지막으로 더한 인덱스의 뒷부분과만 비교하는 문제였나봅니다.
		
		 
*/
	
	public static void main(String[] args) {
		// main은 항상 test용도입니다.
		
		Easy_1995 lt = new Easy_1995();
		int[] nums = {28,8,49,85,37,90,20,8};
		System.out.println(lt.countQuadruplets(nums));
	}
	
	public int countQuadruplets(int[] nums) {
        int answer = 0 ;
		/*
			오역때문에 작성된 부분. 삭제...
			
			ArrayList<Integer> list = new ArrayList<>();
	        for(int i = 0 ; i<nums.length ; i++) {
	        	if(!list.contains(nums[i])) {
	        		list.add(nums[i]);
	        	}
	        }
        */
        for(int i = 0 ; i<nums.length-2; i++) {
        	for(int j = i+1; j<nums.length-1 ; j++) {
        		for(int k = j+1; k<nums.length ; k++) {
					/*
					 * 습관적으로 indexOf를 만들었기 때문에 아주 비생산적으로 작성된 부분
					 * if(indexOf(nums ,(nums[i]+nums[j]+nums[k]))>=0) {
					 * System.out.println(i+" "+j+" "+k);
					 * System.out.println(nums[i]+nums[j]+nums[k]); int count = 0; for(int x = k+1;
					 * x<nums.length ; x++) { if(nums[x] == nums[i]+nums[j]+nums[k]){ count++; } }
					 * answer += count; }
					 */
        			for(int l = k+1 ; l<nums.length ; l++) {
        				if(nums[i]+nums[j]+nums[k]==nums[l]) {
        					answer++;
        				}
        			}
        		}
        	}
        }
		return answer;
    }
	/*
		역시 문제 해결보다는, indexOf를 사용하는 익숙함에 작성한 메서드. 주석처리.
		int indexOf(int[] nums, int sum) {
			for(int i = 0 ; i<nums.length; i++) {
				if(nums[i]==sum) {
					return i;
				}
			}			
			return -1;
		}
	*/
}

/* 
 * 
 * 

	// 문제 해석 잘못햇음.. 중복값이고 뭐고 인덱스만 쓰면댐
	 * 아래는 그냥 nCr참고용

[조합]           
nCr 경우의 수 필요
주어진 배열이 [1,1,2,3,4,5,6,10]이라면
문제에서 중복되지 않는 값들을 더하도록 요구했으므로
1+1+2 는 제외해야한다.
그럼 실제 도출 가능한 경우의 수를 뽑아보자면
대상이 되는 숫자의 배열은 [1,2,3,4,5,6,10] --> ArrayList로 구현 [최초 값에서 중복 값이 몇개일지 알 수 없으므로]
여기서 가능한 조합의 경우의 수는
-- 1로 시작하는 모든 경우의 수 --> 15개
[1,2,3] [1,2,4] [1,2,5] [1,2,6] [1,2,10] --> 1,2로 시작하는 모든 경우의 수
[1,3,4] [1,3,5] [1,3,6] [1,3,10]			--> 1,3으로 시작하는 모든 경우의 수
[1,4,5] [1,4,6] [1,4,10]					--> 1,4로 시작하는 모든 경우의 수
[1,5,6] [1,5,10]							--> 1,5로 시작ㅎ가는 모든 경우의 수
[1,6,10]									--> 1,6으로 시작하는 모든 경우의 수

7개에서 3개를 뽑는 경우, 최초 인덱스로 시작하는 모든 경우의 수는 15개

일반화를 위해 다른 예시를 확인해보자
주어진 배열 [1,2,3,4,5] 에서 3개의 숫자를 조합하는 경우의 수는
-- 1로 시작하는 모든 경우의 수 --> 6개
[1,2,3] [1,2,4] [1,2,5]					--> 1,2로 시작하는 모든 경우의 수
[1,3,4] [1,3,5]							--> 1,3으로 시작하는 모든 경우의 수
[1,4,5]									--> 1,4로 시작하는 모든 경우의 수
5개에서 3개를 뽑는 경우, 최초 인덱스로 시작하는 모든 경우의 수는 6개

위의 두 경우를 들어 식을 만들어보면
int A = 주어진숫자의 수(여기서는 배열의 길이) - (선택해야하는 숫자의 수-1);  
		// 선택해야하는숫자 -1 개만큼 정해두고 마지막 숫자만 바꾸면 다른 조합이므로
int sum = 0; // 최초 인덱스를 기준으로 발생하는 모든 경우의 수, 초기값 0부터 시작           
for(int i = A ; i>=1 ; i--){
		sum += i
}
sum이 더해지는 과정을 보면
    A+(A-1)+(A-2)+...+2+1
      (A-1)+(A-2)+...+2+1
      	   (A-2)+...+2+1
와 진자 능지 이슈... 일반화를 못시키는중
손으로 적으면 하나씩 세서 적는 거기 때문에
nCr의 공식 증명은 후에 반드시 할 것!
---> 모든 경우의 수 nPr을 구한 뒤 중복값을 제거하는 식으로 접근해야 일반화가 쉬울 것
---> 공통의 중복값들이 생길테니, 곱으로 구한다면 그만큼만 나눠주면 된다.

여튼 여기선 만들어진 식을 쓰자
경우의 수 자체는 목적이 아니다
경우의 수에 맞는 값을 뽑아서 모두 더한 뒤 특정 조건에 부합하는 boolean값을 도출하는 것이 목적이다. 
P(n,r)/r! = n!/(n-r)!r!

배열의 길이 5, 조합하는 요소의 수가 3이라면
5!/2!*3! = 1*2*3*4*5/1*2*1*2*3
--> 2*5 = 10

좀 더 단순하게 생각하면
5개에서 3개 뽑기

첫번째 뽑을 수 있는 경우의 수 5
두번째 뽑을 수 있는 경우의 수 4
세번째 뽑을 수 있는 경우의 수 3
5*4*3 - 중복되는 경우의 수 혹은
[1로 시작] 1,2,3 / 1,3,2
[2로 시작] 2,1,3 / 2,3,1
[3으로 시작] 3,1,2 / 3,2,1 이 모두 같은 경우의 수이고, 모든 조합들에 공통적으로 발생될 것이므로
5*4*3 / (2*3) = 5*2 = 10 이 나온다.

여튼... 이번 문제는 위의 경우 중 나온 조합의 합이 nums의 element인 경우를 카운트 하는 문제다
그리고 나는... 경우의 수를 구하는 게 아니라
그 경우의 수에 해당하는 값을 뽑는 과정에서 헤메다가
이런 뻘주석이나 달고 있는것이다...

Arrays.sort를 사용하든 ---> ArrayList를 사용했기 때문에 해당 프레임워크에서 제공하는 메서드를 써야겠지만
어떤 방법이든 정렬을 먼저 한 뒤에
최초 3개의 인덱스를 더해서, 그 값이 해당 배열의 max값보다 크다면 0을 리턴... 그담은?
*/

/*
	list.get(0)+list.get(1)+list.get(2)
	list.get(0+list.get(1)+list.get(3)
	list.get(0)+list.get(1)+list.get(4)
	하고
	list.get(0)+list.get(2)+list.get(3)
	list.get(0)+list.get(2)+list.get(4)
	하고
	list.get(0)+list.get(3)+list.get(4)
	하면 list의 0번째 인덱스를 사용한 모든 합은 끝
	
	
*/