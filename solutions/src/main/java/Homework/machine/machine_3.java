package Homework.machine;

import java.util.Scanner;

public class machine_3 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Drink coke = new Drink("coke", 10, 400);
		Drink fanta = new Drink("fanta", 10, 400);
		Drink soda = new Drink("soda", 10, 400);
		
		int sel_coke = 0;
		int sel_fanta = 0;
		int sel_soda = 0;
		
		while(true) {
			System.out.println("======이제 맛 없어요...=======");
			System.out.println("콜라 재고 : " + coke.amount);
			System.out.println("환타 재고 : " + fanta.amount);
			System.out.println("사이다 재고 : " + soda.amount);
			System.out.println("1.콜라 2.환타 3.사이다 4.구매하기");
			
			int sel_numb = input.nextInt();
			
			if(sel_numb==1) {
				if(coke.amount==0) {
					System.out.println("재고가 없습니다.");
					continue;
				}
				coke.amount--;
				sel_coke++;
			}else if(sel_numb==2) {
				if(fanta.amount==0) {
					System.out.println("재고가 없습니다.");
					continue;
				}
				fanta.amount--;
				sel_fanta++;
			}else if(sel_numb==3) {
				if(soda.amount==0) {
					System.out.println("재고가 없습니다.");
					continue;
				}
				soda.amount--;
				sel_soda++;
			}else if(sel_numb==4) {
				int sum = coke.price*sel_coke + fanta.price*sel_fanta + soda.price*sel_soda;
				System.out.println("결제 금액 : " + sum);
				System.out.println("금액을 입력해주세요.");
				int money = input.nextInt();
				if(money>=sum) {
					System.out.println("구매 완료");
					System.out.println("거스름돈 : " + (money-sum));
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
				}else {
					coke.amount += sel_coke;
					fanta.amount += sel_fanta;
					soda.amount += sel_soda;
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
					System.out.println("금액이 부족합니다");
				}				
			}else {
				System.out.println("1-4사이의 번호를 입력해주세요.");
			}
			System.out.println("========장바구니========");
			System.out.println("콜라 : " + sel_coke);
			System.out.println("환타 : " + sel_fanta);
			System.out.println("사이다 : " + sel_soda);			
		}
	}
	
}
