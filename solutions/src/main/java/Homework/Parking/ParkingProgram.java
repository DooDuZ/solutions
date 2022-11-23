package Homework.Parking;

import java.util.Date;
import java.util.Scanner;

/*
	차량 번호판 입력은 input = 센서가 처리해준다 ---> 그러나 난 센서 그딴거 없으니 손으로 입력하자 ...라고 생각하고 했음니다.
 
 	1. 안내 문구 출력
 		* 프로그램 내용 출력 ex) =========주차장==========
 		* 사용자가 안내 받아야 할 내용 출력
 			* 주차 가능한 자리 시각화 [ boolean 값 4개 ]
 			* 만석인 경우 안내 문구 후 종료
 	2. 사용자 정보 입력 받기
 		* scanner 사용. 코테도 아니고 버퍼리더 귀찮음니다...
 		* 각 boolean 값마다 대응 하는 사용자 정보 변수 선언 (String or int)
		* 
 	3. 입력 받은 정보 처리 가능 판단
  		* 사용자 선택한 int값과 대응하는 boolean 값 논리 검사
  		* true인 경우 대응하는 int 변수에 차량 정보 저장 및 안내문구 출력 후 continue ( 주차해도 주차장 기능은 돌아가니까 )
 		* false인 경우 안내문구 출력 후 continue ( 재선택 해야하므로 )
 		* 처리 값 따라 출력되는 주차장 시각 정보 변경
 	4. 출차 기능 추가
 		* 출차하는 차량의 정보 입력 받기 [ int로 입력 받아 boolean 값 및 대응하는 차량 번호 판단 ]
 		* 주차 시간에 따른 주차 요금 정산 기능 추가 [ new date로 주차시 정보 저장 / 출차 시간과 비교 ]
 		* 정산 요금 입력 반기 [ next.int() ]
 		* 정산 완료 시 거스름돈 출력 or 요금 부족 출력
 		* 출차 후 boolean 값 및 차량 정보 데이터 변경
 */

public class ParkingProgram {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean section = true;
		String section_info = null;
		Date sec_enter = null;
		boolean section2 = true;
		String section2_info = null;
		Date sec2_enter = null;
		boolean section3 = true;
		String section3_info = null;
		Date sec3_enter = null;
		boolean section4 = true;
		String section4_info = null;
		Date sec4_enter = null;
		
		int sales = 0;
		String ID = "admin";
		String PW = "1234";
		
		while(true) {
			System.out.println("=========주차장 입장==========");
			System.out.println("====주차 가능 자리====");
			if(section) {
				System.out.print("[ ]");
			}else {
				System.out.print("[X]");
			}
			if(section2) {
				System.out.print("[ ]");
			}else {
				System.out.print("[X]");
			}
			if(section3) {
				System.out.print("[ ]");
			}else {
				System.out.print("[X]");
			}
			if(section4) {
				System.out.println("[ ]");
			}else {
				System.out.println("[X]");
			}
			
			System.out.println("1. 입차\t2. 출차\t 3. 관리자모드");
			int enterExit = input.nextInt();
			
			if(enterExit==1) {
				if(!section && !section2 && !section3 && !section4) {
					System.err.println("주차 가능한 자리가 없습니다.");
					continue;
				}
				System.out.println("차량 번호를 입력해주세요");
				String car_info = input.next();
				if(car_info.equals(section_info) || car_info.equals(section2_info) || car_info.equals(section3_info) || car_info.equals(section4_info)) {
					System.err.println("[관리자 문의] 이미 주차된 번호");
					continue;
				}
				System.out.println("주차를 원하는 자리를 입력해 주세요.");
				int sel_section = input.nextInt();
				if(sel_section==1) {
					if(section) {
						section_info = car_info;
						section = false;
						sec_enter = new Date();
						System.out.println("주차 완료");
						System.out.println("주차 시작 시간 : " + sec_enter);
					}else {
						System.err.println("[주차 불가] 빈 자리를 선택해 주세요.");
						continue;
					}
				}else if(sel_section==2) {
					if(section2) {
						section2_info = car_info;
						section2 = false;
						sec2_enter = new Date();
						System.out.println("주차 완료");
						System.out.println("주차 시작 시간 : " + sec2_enter);
					}else {
						System.err.println("[주차 불가] 빈 자리를 선택해 주세요.");
						continue;
					}
				}else if(sel_section==3) {
					if(section3) {
						section3_info = car_info;
						section3 = false;
						sec3_enter = new Date();
						System.out.println("주차 완료");
						System.out.println("주차 시작 시간 : " + sec3_enter);
					}else {
						System.err.println("[주차 불가] 빈 자리를 선택해 주세요.");
						continue;
					}
				}else if(sel_section==4) {
					if(section4) {
						section4_info = car_info;
						section4 = false;
						sec4_enter = new Date();
						System.out.println("주차 완료");
						System.out.println("주차 시작 시간 : " + sec4_enter);
					}else {
						System.err.println("[주차 불가] 빈 자리를 선택해 주세요.");
						continue;
					}
				}else {
					System.out.println("유효한 번호가 아닙니다.");
					continue;
				}
			}else if(enterExit==2) {
				System.out.println("차량 번호를 입력해 주세요");
				String car_info = input.next();
				if(car_info.equals(section_info)) {
					System.out.println("1번 구역 출차 확인");
					Date pay = new Date();
					int payHours = pay.getHours();
					int enterHours = sec_enter.getHours();

					int payMinutes = pay.getMinutes();
					int enterMinutes = sec_enter.getMinutes();

					int price = ((payHours*60+payMinutes) - (enterHours*60+enterMinutes)) * 60;
					if(price<1500) {
						price = 1500 ;
					}
					System.out.println("결제 금액 : " + price + "원");
					System.out.println("금액을 투입해 주세요 : ");
					int payment = input.nextInt();
					
					if(price>payment) {
						System.err.println("금액 부족");
						continue;
					}else if(price<=payment) {
						System.out.println("[결제 완료] 거스름돈 : " + (payment-price) +"원");
						sales += payment;
						System.out.println("[Door Open] 안녕히 가세요 \n");
						section = true;
						section_info = null;
						sec_enter = null;
					}					
				}else if(car_info.equals(section2_info)) {
					System.out.println("2번 구역 출차 확인");
					Date pay = new Date();
					int payHours = pay.getHours();
					int enterHours = sec2_enter.getHours();

					int payMinutes = pay.getMinutes();
					int enterMinutes = sec2_enter.getMinutes();

					int price = ((payHours*60+payMinutes) - (enterHours*60+enterMinutes)) * 60;
					if(price<1500) {
						price = 1500 ;
					}
					System.out.println("결제 금액 : " + price + "원");
					System.out.println("금액을 투입해 주세요 : ");
					int payment = input.nextInt();
					
					if(price>payment) {
						System.err.println("금액 부족");
						continue;
					}else if(price<=payment) {
						System.out.println("[결제 완료] 거스름돈 : " + (payment-price) +"원");
						sales += payment;
						System.out.println("[Door Open] 안녕히 가세요 \n");
						section2 = true;
						section2_info = null;
						sec2_enter = null;
					}					
				}else if(car_info.equals(section3_info)) {
					System.out.println("3번 구역 출차 확인");
					Date pay = new Date();
					int payHours = pay.getHours();
					int enterHours = sec3_enter.getHours();

					int payMinutes = pay.getMinutes();
					int enterMinutes = sec3_enter.getMinutes();

					int price = ((payHours*60+payMinutes) - (enterHours*60+enterMinutes)) * 60;
					if(price<1500) {
						price = 1500 ;
					}
					System.out.println("결제 금액 : " + price + "원");
					System.out.println("금액을 투입해 주세요 : ");
					int payment = input.nextInt();
					
					if(price>payment) {
						System.err.println("금액 부족");
						continue;
					}else if(price<=payment) {
						System.out.println("[결제 완료] 거스름돈 : " + (payment-price) +"원");
						sales += payment;
						System.out.println("[Door Open] 안녕히 가세요 \n");
						section3 = true;
						section3_info = null;
						sec3_enter = null;
					}					
				}else if(car_info.equals(section4_info)) {
					System.out.println("4번 구역 출차 확인");
					Date pay = new Date();
					int payHours = pay.getHours();
					int enterHours = sec4_enter.getHours();

					int payMinutes = pay.getMinutes();
					int enterMinutes = sec4_enter.getMinutes();

					int price = ((payHours*60+payMinutes) - (enterHours*60+enterMinutes)) * 60;
					if(price<1500) {
						price = 1500 ;
					}
					System.out.println("결제 금액 : " + price + "원");
					System.out.println("금액을 투입해 주세요 : ");
					int payment = input.nextInt();
					
					if(price>payment) {
						System.err.println("금액 부족");
						continue;
					}else if(price<=payment) {
						System.out.println("[결제 완료] 거스름돈 : " + (payment-price) +"원");
						sales += payment;
						System.out.println("[Door Open] 안녕히 가세요 \n");
						section4 = true;
						section4_info = null;
						sec4_enter = null;
					}					
				}else {
					System.out.println("해당 주차장에 없는 차량 입니다.");
					continue;
				}
			}else if(enterExit==3){
				System.out.println("ID입력 : ");
				String inputID = input.next();
				System.out.println("비밀번호 입력 : ");
				String inputPW = input.next();
				
				if(inputID.equals(ID) && inputPW.equals(PW)) {
					System.out.println("금일 매출 : " + sales);
					System.out.println("1.출금하기 2.돌아가기");
					int sel_numb = input.nextInt();
					if(sel_numb==1) {
						System.out.println("출금액 : "+sales);
						sales = 0;
						System.out.println("출금 완료");
					}
				}else {
					System.err.println("[계정 정보 불일치]");
				}				
			}else{
				System.err.println("[경고]알 수 없는 번호");
				continue;
			}
		}		
	}
}
