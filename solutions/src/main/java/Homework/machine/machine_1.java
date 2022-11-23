package Homework.machine;

import java.util.Scanner;

public class machine_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int coke = 10; int fanta = 10; int soda = 10; 
		int sel_coke = 0; int sel_fanta = 0; int sel_soda = 0; 
		while(true) {
			System.out.println("======마싯서요=======");
			System.out.println("콜라(400) 재고 : " + coke);
			System.out.println("환타(300) 재고 : " + fanta);
			System.out.println("사이다(200) 재고 : " + soda);
			System.out.println("======마싯서요=======");
			System.out.println("음료를 선택해주세요");
			System.out.println("1.콜라 2.환타 3.사이다 4.구매");
			int sel_numb = input.nextInt();
			
			if(sel_numb==1) {
				if(coke==0) {
					System.err.println("재고가 없습니다.");
					continue;
				}
				coke--; sel_coke++;
			}else if(sel_numb==2) {
				fanta--; sel_fanta++;
			}else if(sel_numb==3) {
				soda--; sel_soda++;
			}else if(sel_numb==4){
				int sum = sel_coke*400 + sel_fanta*300 + sel_soda*200;
				System.out.println("결제 금액 : " + (sel_coke*400 + sel_fanta*300 + sel_soda*200));
				System.out.println("1.결제 2.취소");
				int buy_numb = input.nextInt();
				if(buy_numb==1) {
					System.out.println("금액을 투입해 주세요");
					int money = input.nextInt();
					if(money>=sum) {
						System.out.println("구매가 완료되었습니다.");
						System.out.println("거스름돈 : "+(money-sum));
						sel_coke = 0;
						sel_fanta = 0;
						sel_soda = 0;
					}else {
						System.err.println("금액이 부족합니다.");
						coke += sel_coke;
						fanta += sel_fanta;
						soda += sel_soda;
						sel_coke = 0;
						sel_fanta = 0;
						sel_soda = 0;
					}
				}else if(buy_numb==2) {
					coke += sel_coke;
					fanta += sel_fanta;
					soda += sel_soda;
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
				}else {
					coke += sel_coke;
					fanta += sel_fanta;
					soda += sel_soda;
					sel_coke = 0;
					sel_fanta = 0;
					sel_soda = 0;
					System.err.println("없는 번호입니다.");
				}
			}else {			
				System.err.println("없는 번호입니다.");
				continue;
			}
			System.out.println("=======장바구니========");
			System.out.print("콜라 : " + sel_coke +"\t");
			System.out.print("환타 : " + sel_fanta +"\t");
			System.out.println("사이다 : " + sel_soda);
			System.out.println("==================");
		}
	}

}
