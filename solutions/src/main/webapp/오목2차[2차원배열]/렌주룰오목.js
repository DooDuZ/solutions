/**
 * 
 */
 
 const board = document.querySelector('#board');
 	
 let gameboard = [];
 
 let turn = 0;
 let count = 0;
 
 function start_game(){
	gameboard = [];
	turn = 0;
	for(let y = 19 ; y>=1 ; y--){
		let board_cols = [];
		for(let x = 1; x<=19; x++){	
			board_cols.push('');
		}
		gameboard.push(board_cols);
	}
	
	let storage = ''; 
	
	for(let i = 0 ; i<19 ; i++){
		
		storage += '<div class="line">';
		
		for(let j = 0 ; j<19 ; j++){
			storage += '<div class=cell onclick=click_btn('+i+','+j+')>'+gameboard[i][j]+'</div>';		
		}
		storage += '</div>';
	}
	board.innerHTML = storage;	
}
start_game();

function click_btn(x,y){	
	if(turn==2){
		alert('게임을 다시 시작해주세요.')
		return;
	}
	
	if(gameboard[x][y]=='<img src="흑돌.png">' || gameboard[x][y]=='<img src="백돌.png">'){
		alert('이미 둔 자리입니다.')
		return;
	}
	
	if(turn==0){
		gameboard[x][y] = '<img src="흑돌.png">';
		turn++;
	}else if(turn==1){
		gameboard[x][y] = '<img src="백돌.png">';
		turn--;
	}
	
	let storage = ''; 
	for(let i = 0 ; i<19 ; i++){
		storage += '<div class="line">';
		for(let j = 0 ; j<19 ; j++){
			storage += '<div class=cell onclick=click_btn('+i+','+j+')>'+gameboard[i][j]+'</div>';
		}
		storage += '</div>';
	}
	board.innerHTML = storage;
	
	if(check_win(x,y)){
		if(turn==1){
			alert('흑돌 승리');
			turn=2;
			return;
		}else if(turn==0){
			alert('백돌 승리');
			turn=2;
			return;
		}
	}
	count++;
	if(count==361){
		turn=2;
		alert('무승부');
	}
}


function check_win(x,y){
	let win_count = 0;
	for(let i = 0 ; i<18 ; i++){
		if(gameboard[i][y]!=''&&gameboard[i][y]==gameboard[i+1][y]){
			win_count++;
			if(win_count==4){
				return true;
			}
		}else{
			win_count = 0;
		}
	}
	win_count = 0;
	for(let i = 0 ; i<18 ; i++){
		if(gameboard[x][i]!=''&&gameboard[x][i]==gameboard[x][i+1]){
			win_count++;
			if(win_count==4){
				return true;
			}
		}else{
				win_count = 0;
		}
	}
	win_count = 0;
	for(let i = -4 ; i < 4 ; i++){
		if(x+i<0 || y+i<0 || x+i>17 || y+i>17){
			continue;
		}else if(gameboard[x+i][y+i]!='' && gameboard[x+i][y+i]==gameboard[x+i+1][y+i+1]){
			win_count++
			if(win_count==4){
				return true;
			}
		}else{
			win_count = 0;
		}
	}win_count = 0;
	for(let i = -4 ; i < 4 ; i++){
		if(x+i<0 || y-i<1 || x+i>17 || y-i>18){
			continue;
		}else if(gameboard[x+i][y-i]!='' && gameboard[x+i][y-i]==gameboard[x+i+1][y-i-1]){
			win_count++
			if(win_count==4){
				return true;
			}
		}else{
			win_count = 0;
		}
	}
}




