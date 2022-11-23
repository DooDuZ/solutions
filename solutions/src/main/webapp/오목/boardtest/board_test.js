/**
 * 
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
		document.getElementById(e).innerHTML = '<img src="../흑돌.png">'
		turn++
	}else{
		document.getElementById(e).innerHTML = '<img src="../백돌.png">'
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
	if(document.getElementById(e).innerHTML=='<img src="../흑돌.png">' || document.getElementById(e).innerHTML=='<img src="../백돌.png">'){
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







