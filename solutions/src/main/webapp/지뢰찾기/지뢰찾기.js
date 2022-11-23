/**
	[지뢰찾기]
	
		1. 입력받은 난이도에 맞는 판을 생성			
			[사이즈 선택]
				easy : 10*10 board
					-지뢰 : 10*10*0.1				
				normal : 15*15 board
					-지뢰 : 15*15*0.2
				hard : 20*20 board
					-지뢰 : 20*20*0.3
			[지뢰 입력]
			- Math.random 이용, 무작위 좌표에 입력
			[좌표 지정]
				1. 2차원 배열을 이용한 좌표 생성 및 HTML출력
				2. 각 셀에 display될 값 부여
					ㄴ셀의 값이 !지뢰 == (셀의값=셀의좌표로부터 8방향(x-1,y-1 ~ x+1, y+1)의 값을 탐색한 뒤 나온 지뢰의 개수)
					ㄴ0인경우 null or ''
				3. 각 셀에 open/close 상태 부여 -> how??
				4. 각 셀에 open->close 상태 변경 가능한 onclick 이벤트 부여 		
		2. 셀 event 발생 로직
			[셀의 closed->open]
				1. open 값이 null인 경우 -> 8방향 검사 후 !지뢰인 곳 open
					ㄴ open된 값들에서 계속 연달아 진행
				2. open 값이 !null인 경우 -> open
				3. open 값이 지뢰인 경우 -> 패배
		3. 승리판단
			전체 셀 - open cell = 지뢰 갯수 이면 승리
			open 값이 지뢰인 경우 패배
 */
 
 let gameboard = [];
 
 function start_game(){
	let level = Number(prompt('1.easy 2.normal 3.hard'))
	
	let side_length ;
	
	if(level==1){
		side_length = 10;
	}else if(level==2){
		side_length = 15;
	}else if(level==3){
		side_length = 20;
	}else{
		alert("딴겜하세요")
	}
	
	for(let i = 0; i<side_length ; i++){
		let column = [];
		for(let j = 0 ; j<side_length ; j++){
			column.push(0);
		}
		gameboard.push(column);
	}	
	
	input_mine(side_length, level);
	input_data();
	
	let print_board = '';
	for(let i = 0; i<side_length ; i++){
		print_board += '<div>'
		for(let j = 0; j<side_length ; j++){
			print_board += `<div id='${i}_${j}' class='column' onclick="click_btn(${i}, ${j})">${gameboard[i][j]}</div>`
		}
		print_board += '</div>'
	}
	document.getElementById('setBoard').innerHTML = print_board;
	
	const cells = document.querySelectorAll('.column')
	for(let i = 0 ; i<Math.pow(side_length, 2) ; i++){
		cells[i].style.backgroundColor = 'black';
	}
}

start_game();


function input_mine(side_length, level){
	
	let count_mine = Math.pow(side_length, 2)*(level/10);

	for(let i = 1 ; i<=count_mine ; i++){
		let rand_row = Math.floor(Math.random()*side_length);
		let rand_col = Math.floor(Math.random()*side_length);
		if(gameboard[rand_row][rand_col]==0){
			gameboard[rand_row][rand_col] ='X'
		}else{
			i--;
		}
	}
	// 주변 지뢰 숫자 표시
	
}


function input_data(){
	
	for(let i = 0 ; i<gameboard.length ; i++){
		for(let j = 0 ; j<gameboard.length ; j++){
			if(gameboard[i][j]=='X'){
				continue;
			}else{
				let count = 0;
				if(i-1 >= 0 && j-1 >= 0 && gameboard[i-1][j-1]=='X'){
					count++;
				}
				if(i-1 >= 0 && gameboard[i-1][j]=='X'){
					count++;
				}
				if(i-1 >= 0 && j+1 < gameboard.length && gameboard[i-1][j+1]=='X'){
					count++;
				}
				if(j-1 >= 0 && gameboard[i][j-1]=='X'){
					count++;
				}
				if(j+1 < gameboard.length && gameboard[i][j+1]=='X'){
					count++;
				}
				if(i+1 < gameboard.length && j-1 >= 0 && gameboard[i+1][j-1]=='X'){
					count++;
				}
				if(i+1 < gameboard.length && gameboard[i+1][j]=='X'){
					count++;
				}
				if(i+1 < gameboard.length && j+1 < gameboard.length && gameboard[i+1][j+1]=='X'){
					count++;
				}
				if(count!=0){
					gameboard[i][j] = count;
				}
				count = 0 ;
			}
		}
	}
}


function click_btn(i, j){
	console.log("메롱");
	
	document.getElementById(`${i}_${j}`).style.backgroundColor = 'white';
	
	//left
	/*
	while(true){
		console.log('메롱')
		if(gameboard[i][j]==0){
			i--;
			document.getElementById(`${i}_${j}`).style.backgroundColor = 'white';
			console.log(gameboard[i][j]);
			if(gameboard[i][j]!=0){
				break;
			}
		}
	}
	*/
	if(check_win(i,j)){
		alert('승리');
	}else{
		alert('패배');
	}
}




function check_win(i,j){
	let winCount = 0;
	let mineCount = 0;
	
	console.log(gameboard[i][j]);
	
	if(gameboard[i][j]==='X'){
		for(let x=0; x<gameboard.length ; x++){
			for(let y=0; y<gameboard.length ; y++){
				if(gameboard[x][y]==='X'){
					document.getElementById(`${x}_${y}`).style.backgroundColor = 'red';
				}
			}
		}
		return false;
	}	
	
	for(let x = 0; x<gameboard.length ; x++){
		for(let y = 0 ; y<gameboard.length ; y++){
			if(document.getElementById(`${x}_${y}`).style.backgroundColor == 'white'){
				winCount++;
			}else if(document.getElementById(`${x}_${y}`).innerHTML == 'X'){
				mineCount++;
			}
		}
	}
	if(winCount==(Math.pow(gameboard.length, 2)) - mineCount){
		return true;
	}
}


	/*
	if(gameboard[i][j]==0){	
		if(i-1>=0 && j-1>=0 && gameboard[i-1][j-1]!='X'){
			document.getElementById(`${i-1}_${j-1}`).style.backgroundColor = 'white';
		}
		if(i-1>=0 && gameboard[i-1][j]!='X'){		
			document.getElementById(`${i-1}_${j}`).style.backgroundColor = 'white';
		}
		if(i-1>=0 && j+1<gameboard.length && gameboard[i-1][j+1]!='X'){
			document.getElementById(`${i-1}_${j+1}`).style.backgroundColor = 'white';
		}
		if(j+1<gameboard.length && gameboard[i][j-1]!='X'){
			document.getElementById(`${i}_${j-1}`).style.backgroundColor = 'white';
		}
		if(j+1<gameboard.length && gameboard[i][j+1]!='X'){
			document.getElementById(`${i}_${j+1}`).style.backgroundColor = 'white';
		}
		if(i+1<gameboard.length && j-1>=0 && gameboard[i+1][j-1]!='X'){
			document.getElementById(`${i+1}_${j-1}`).style.backgroundColor = 'white';
		}
		if(i+1<gameboard.length && gameboard[i+1][j]!='X'){
			document.getElementById(`${i+1}_${j}`).style.backgroundColor = 'white';
		}
		if(i+1<gameboard.length && j+1<gameboard.length && gameboard[i+1][j+1]!='X'){
			document.getElementById(`${i+1}_${j+1}`).style.backgroundColor = 'white';
		}
	}
	*/

