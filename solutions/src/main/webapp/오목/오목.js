/*
 	[목표]
 	
 	1. 기존 틱텍토와 다른 방법으로 구현해보기 / 배열 사용x 
 	2. 실제 바둑판을 앞에 두고 두는 것과 가장 흡사하게 구현하고자 함 / 무르기 기능 X 
 	3. 세부 룰(3*3, 4*4 등에서 이어진 렌주룰) 구현 X / 돌이 5개가 연달아 놓이면 게임 종료 까지만 구현
 	4. 기능 구현 후 css까지 구현
 	
 	[개선점]
 	
 	-매우 나쁜 코드임. 세부 룰 추가하여 처음부터 다시 만들 예정. 	
 	
 	1. 배열을 사용하지 않았기 때문에 승리판단을 위해 매 착수마다 판 전체의 상황을 읽어야함(for 사용하여 1클릭 == 판 검사 361번). 매우 비효율적!!
 	2. 위의 방법으로 구현했기 때문에 click 이후의 상황과 이전의 상황을 구별할 방법이 없음 / 무르기 기능 구현 불가능
 	3. 배열을 이용하면 3*3금지 등의 룰을 부여할 때도 훨씬 편해질 것으로 생각됌.
 	4. 좌표 부여 시 ${x}_{y} 사용하였으나 js가 number를 읽을 때 number사이에 있는 _를 문자가 아니라 1,000 같은 단위로 인식하여 삭제하는 문제 발생.
 		ㄴ모든 ${x}_{y} 변수에 ''를 이용하여 문자열로 변환해줘서 해결. 그러나 아직 문법에 익숙하지 않은 우리에게 좋은 방법은 아닌듯 함.
 		ㄴ보다 효율적인 좌표 구현 방법 고민 필요
 	5. 바둑판 css 적용에 가상요소 사용하였으나 바둑판 내부와 외부, 4개의 꼭지점을 모두 나눠야 했어서 코드가 매우 길어짐. 보다 단순한 구조로 구현할 수 있도록 고민.
 	
 */
 
 
 let gameboard ; 
 let turn = 0

 function start_game(){
	gameboard = ''
	turn = 0
	for(let y = 1 ; y<=19 ; y++){
		gameboard += `<tr>`
		for(let x = 1 ; x<=19 ; x++){
			gameboard += `<td id='${x}_${y}' class='inner' onclick="click_btn('${x}_${y}')"></td>`
		}
		gameboard += `</tr>`
	}
	document.getElementById('board').innerHTML = gameboard
	outline_check()
}
start_game()
outline_check()


//가상요소로 바둑판 그리기
//안쪽 가상요소 css 모두 동일 inner와 outline(right, left, top, bottom) 클래스 구분
//x_y 문자열, 숫자 지정 오류가 잦은 관계로 querySelectorAll의 index로 컨트롤
function outline_check(){
	const board_box = document.querySelectorAll('td')
	
	for(let i = 0 ; i<19 ; i++){
		board_box[i].className = 'top_line'
		board_box[i+342].className = 'btm_line'
	}
	for(let i = 0 ; i<=342 ; i+=19){
		board_box[i].className = 'left_line'
		board_box[i+18].className = 'right_line'
	}
	board_box[0].className = 'left_top';
	board_box[18].className = 'right_top';
	board_box[342].className = 'left_btm';
	board_box[360].className = 'right_btm';
}


function click_btn(e){
	if(turn==2){
		alert('게임종료')
		return
	}
	
	if(click_test(e)){
		alert('이미 둔 자리입니다.')
		return
	}	
	if(turn==0){
		document.getElementById(e).innerHTML = '<img src="흑돌.png">'
		turn++
	}else{
		document.getElementById(e).innerHTML = '<img src="백돌.png">'
		turn--
	}
	if(check_winner()){
		if(turn==1){
			alert('흑돌 승리')
		}else{
			alert('백돌 승리')
		}
		turn = 2
	}
}



function click_test(e){
	if(document.getElementById(e).innerHTML=='<img src="흑돌.png">' || document.getElementById(e).innerHTML=='<img src="백돌.png">'){
		return true
	}	
}


function check_winner(){	
	for(let y = 1 ; y <=19 ; y ++){
		for(let x = 1 ; x <= 15 ; x++){
			let data_x = document.getElementById(x+'_'+y).innerHTML
			let data_x2 = document.getElementById(x+1+'_'+y).innerHTML
			let data_x3 = document.getElementById(x+2+'_'+y).innerHTML
			let data_x4 = document.getElementById(x+3+'_'+y).innerHTML
			let data_x5 = document.getElementById(x+4+'_'+y).innerHTML 
			if(data_x!=''&& data_x==data_x2 && data_x==data_x3 && data_x==data_x4 && data_x==data_x5){
				return true
			}
		}
	} //가로 조건 종료
	for(let y = 1 ; y<=15 ; y++){
		for(let x = 1 ; x<=19 ; x++){
			let data = document.getElementById(x+'_'+y).innerHTML
			let data2 = document.getElementById(x+'_'+(y+1)).innerHTML
			let data3 = document.getElementById(x+'_'+(y+2)).innerHTML
			let data4 = document.getElementById(x+'_'+(y+3)).innerHTML
			let data5 = document.getElementById(x+'_'+(y+4)).innerHTML
			if(data!=''&& data==data2 && data==data3 && data==data4 && data==data5){
				return true
			}
		}
	}//세로 종료
	for(let y = 1 ; y<=15 ; y++){
		for(let x=1 ; x<=15 ; x++){
			let data = document.getElementById(x+'_'+y).innerHTML
			let data2 = document.getElementById((x+1)+'_'+(y+1)).innerHTML
			let data3 = document.getElementById((x+2)+'_'+(y+2)).innerHTML
			let data4 = document.getElementById((x+3)+'_'+(y+3)).innerHTML
			let data5 = document.getElementById((x+4)+'_'+(y+4)).innerHTML
			if(data!=''&& data==data2 && data==data3 && data==data4 && data==data5){
				return true
			}
		}
	}//왼쪽->오른쪽 대각 종료
	for(let y = 1 ; y<=15 ; y++){
		for(let x=5 ; x<=19 ; x++){
			let data = document.getElementById(x+'_'+y).innerHTML
			let data2 = document.getElementById((x-1)+'_'+(y+1)).innerHTML
			let data3 = document.getElementById((x-2)+'_'+(y+2)).innerHTML
			let data4 = document.getElementById((x-3)+'_'+(y+3)).innerHTML
			let data5 = document.getElementById((x-4)+'_'+(y+4)).innerHTML
			if(data!=''&& data==data2 && data==data3 && data==data4 && data==data5){
				return true
			}
		}
	}//오른쪽->왼쪽 대각 종료
	let count;
	for(let y = 1 ; y<=19 ; y++){
		for(let x = 1 ; x<=19 ; x++){
			if(document.getElementById(x+'_'+y).innerHTML!=''){
				count++
			}
		}
	}if(count==361 && turn!=2){
		alert('승자 없음')
		turn=2
	}	
}