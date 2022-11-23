package leetCode;

public class Easy_2022 {
	
	
	
	/*
		2022. Convert 1D Array Into 2D Array
		
		You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. 
		1차원 원본 배열과 두개의 정수가 m, n이 주어집니다.  
		You are tasked with creating a 2-dimensional (2D) array with m rows and n columns using all the elements from original.
		당신은 원본 배열의 모든 element를 사용해 m개의 행과 n개의 열로 이루어진 2차원 배열을 만들어야 합니다.
		The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
		// 파파고 번역 ) 원래 인덱스 0에서 n - 1(포함)까지의 요소는 생성된 2D 배열의 첫 번째 행을 형성해야 하며 인덱스 n에서 2 * n - 1(포함)까지의 요소는 생성된 2D 배열의 두 번째 행을 형성해야 합니다.
		Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
		위의 절차에 따라 m * n의 2차원 배열을 리턴하고, 불가능한 경우 텅빈 2차원 배열을 리턴하세요.
		
		그냥 1차원 배열 짤라서 2차원 배열로 만들라는 문제입니다.
		웬일로 문제가 쉽습니다.
		사실 제가 요즘 잘 안풀려서 쉬운거 찾아서 골랐습니다 ㅎ...
		
		어렵지 않은 문제이므로 example이나 contains는 생략
		
		public int[][] construct2DArray(int[] original, int m, int n) {
        	// 여기에 답 작성
    	}
    	
    	
    	******** 주의 빈 배열은 [] 형태로 return되어야 합니다. null이나 기본값 0 채워진거 오답처리 됩니다.
	*/
	
	public static void main(String[] args) {
		// test용 메인
		
		Easy_2022 ea = new Easy_2022();
		
		int[] original = {1,2,3,4,5};
		
		int[][] answer = ea.construct2DArray(original, 2, 3);
		
		for(int i = 0 ; i<2; i++) {
			for(int j = 0 ; j<3; j++) {
				System.out.println(answer[i][j]);
			}
		}
	}
	
	
	public int[][] construct2DArray(int[] original, int m, int n) {
		int[][] answer = new int[m][n];
		if(m==1 && n==1 && original.length!=1) {
            answer = new int[0][0];
			return answer;
		}
		
		if(original.length != m*n) {
            answer = new int[0][0];
			return answer;
		}		
		
		for(int i = 0 ; i<m ;i++) {
			for(int j = 0 ; j<n ; j++) {
				answer[i][j] = original[i*n+j];
			}
		}		
		return answer;
	}	
}
