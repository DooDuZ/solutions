package Homework.machine;

import java.util.Scanner;

public class machine_2 {
	//2차원 배열
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[][] machine = new String[3][3];
		
		machine[0][0] = "coke";
		machine[0][1] = "10";
		machine[0][2] = "400";
		machine[1][0] = "fanta";
		machine[1][1] = "10";
		machine[1][2] = "300";
		machine[2][0] = "soda";
		machine[2][1] = "10";
		machine[2][2] = "200";
		
		int sel_coke = 0;
		int sel_fanta = 0;
		int sel_soda = 0;		
		
		while(true) {
			System.out.println("=====마싯서요=====");
			System.out.print("콜라 재고 : " + machine[0][1] +"\t");
			System.out.print("환타 재고 : "+ machine[1][1] +"\t");
			System.out.println("사이다 재고 : "+ machine[2][1]);			
			System.out.println("1.콜라 2.환타 3.사이다 4.구매");
			int sel_numb = input.nextInt();
				 
				
			if(sel_numb==1) {
				if(Integer.parseInt(machine[0][1])==0) {
					System.err.println("재고가 없습니다.");
					continue;
				}				
				int storage = Integer.parseInt(machine[0][1])-1;
				machine[0][1] = Integer.toString(storage);
				sel_coke++;
			}else if(sel_numb==2) {
				if(Integer.parseInt(machine[1][1])==0) {
					System.err.println("재고가 없습니다.");
					continue;
				}
				int storage = Integer.parseInt(machine[1][1])-1;
				machine[1][1] = Integer.toString(storage);
				sel_fanta++;
			}else if(sel_numb==3) {
				if(Integer.parseInt(machine[2][1])==0) {
					System.err.println("재고가 없습니다.");
					continue;
				}
				int storage = Integer.parseInt(machine[2][1])-1;
				machine[2][1] = Integer.toString(storage);
				sel_soda++;
			}else if(sel_numb==4) {
				int sum = sel_coke*Integer.parseInt(machine[0][2])
						+ sel_fanta*Integer.parseInt(machine[1][2])
						+ sel_soda*Integer.parseInt(machine[2][2]);
						   
				System.out.println("결제 금액 : " + sum);
				System.out.println("금액을 투입해 주세요.");
				int money = input.nextInt();
				if(money>=sum) {
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
					System.out.println("거스름돈 : "+ (money-sum));
					System.out.println("결제완료");
				}else {
					int plus_coke = sel_coke + Integer.parseInt(machine[0][1]);
					int plus_fanta = sel_fanta + Integer.parseInt(machine[1][1]);
					int plus_soda = sel_soda + Integer.parseInt(machine[2][1]);
					machine[0][1] = Integer.toString(plus_coke);
					machine[1][1] = Integer.toString(plus_fanta);
					machine[2][1] = Integer.toString(plus_soda);
					
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
					System.err.println("금액이 부족합니다.");
				}				
			}
			System.out.println("=====장바구니=====");
			System.out.println("콜라 : " + sel_coke + "개\t");
			System.out.println("환타 : " + sel_fanta + "개\t");
			System.out.println("사이다 : " + sel_soda + "개");
			System.out.println("=================");
		}
	}
}
