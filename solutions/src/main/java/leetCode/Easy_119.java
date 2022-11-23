package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Easy_119 {
	/*
		Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
		행의 index가 주어지면, 파스칼 삼각형의 해당 줄을 리턴하시오.
		In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
		어쩌구저쩌구~ 파스칼삼각형의 정의입니다.
		118번과 동일한 문제인데 이번에는 2차원 배열이 아니라 1차원 배열로 한줄만 리턴해달랍니다.
		118번은 같은 리포지터리의 자바스크립트 쪽에서 풀었습니다.
		
		public List<Integer> getRow(int rowIndex) {
        	// 여기에 답 작성
    	}
		
	*/
	
	public static void main(String[] args) {
		Easy_119 ea = new Easy_119();
		
		for(int tmp : ea.getRow(3)) {
			System.out.println(tmp);
		}
		
		
		
	}
	
	public List<Integer> getRow(int rowIndex) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    	for(int i = 0 ; i<rowIndex+1 ; i++) {	// 문제가 0번 행부터 시작하므로 +1추가
    		ArrayList<Integer> index = new ArrayList<>();
    		for(int j = 0; j<=i ; j++) {
    			if(i==0 || j==0 || j==i) {
    				index.add(1);
    			}else {
    				index.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
    			}
    		}
    		list.add(index);
    	}
    	return list.get(rowIndex);
	}
}
