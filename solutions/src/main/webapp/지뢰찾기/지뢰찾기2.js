/**
 * 
 */
 
 let boardData = [];
 let countOpen = 0;
 
 let continueGame = true;
 
 
 function startGame(){
	
	let level = Number(prompt('1.easy 2.normal 3.hard'));
	
	let side_length ;
	if(level===1){
		side_length = 10;
	}else if(level===2){
		side_length = 15;
	}else if(level===3){
		side_length = 20;
	}else{
		alert("딴겜하쇼");
	}

	
	let gameboard = '';
	
	for(let i = 0 ; i < side_length; i++){
		gameboard += `<div id='col ${i}'>`
		for(let j = 0 ; j < side_length; j++){
			gameboard += `<button id='${i}_${j}' class='cell' onclick="onCellClick(${i}, ${j})">0</button>`	
		}
		gameboard+='</div>';
	}
	document.getElementById('setBoard').innerHTML = gameboard;
	
	inputMine(level, side_length);
	input_data(side_length);
	
}

startGame();

function inputMine(level, side_length){
	
	let mineCount = (Math.pow(side_length,2))*(level/10);
	
	for(let i = 1; i<= mineCount ; i++){
		let rand = Math.floor(Math.random()*side_length);
		let rand2 = Math.floor(Math.random()*side_length);		
		
		if(document.getElementById(`${rand}_${rand2}`).innerHTML==0){
			document.getElementById(`${rand}_${rand2}`).innerHTML = 'X';
		}else{
			i--;
		}
	}
}

function input_data(side_length){
	for(let i = 0 ; i< side_length ; i++) {
		for(let j = 0 ; j<side_length ; j++){
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i-1>=0 && j-1>=0 && document.getElementById(`${i-1}_${j-1}`).innerHTML !='X'){
					document.getElementById(`${i-1}_${j-1}`).innerHTML = Number(document.getElementById(`${i-1}_${j-1}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i-1>=0 && document.getElementById(`${i-1}_${j}`).innerHTML !='X'){
					document.getElementById(`${i-1}_${j}`).innerHTML = Number(document.getElementById(`${i-1}_${j}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i-1>=0 && j+1<side_length && document.getElementById(`${i-1}_${j+1}`).innerHTML !='X'){
					document.getElementById(`${i-1}_${j+1}`).innerHTML = Number(document.getElementById(`${i-1}_${j+1}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(j-1>=0 && document.getElementById(`${i}_${j-1}`).innerHTML !='X'){
					document.getElementById(`${i}_${j-1}`).innerHTML = Number(document.getElementById(`${i}_${j-1}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(j+1<side_length && document.getElementById(`${i}_${j+1}`).innerHTML !='X'){
					document.getElementById(`${i}_${j+1}`).innerHTML = Number(document.getElementById(`${i}_${j+1}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i+1<side_length && j-1>=0 && document.getElementById(`${i+1}_${j-1}`).innerHTML !='X'){
					document.getElementById(`${i+1}_${j-1}`).innerHTML = Number(document.getElementById(`${i+1}_${j-1}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i+1<side_length && document.getElementById(`${i+1}_${j}`).innerHTML !='X'){
					document.getElementById(`${i+1}_${j}`).innerHTML = Number(document.getElementById(`${i+1}_${j}`).innerHTML)+1 ;
				}
			}
			if(document.getElementById(`${i}_${j}`).innerHTML=='X'){
				if(i+1<side_length && j+1<side_length && document.getElementById(`${i+1}_${j+1}`).innerHTML !='X'){
					document.getElementById(`${i+1}_${j+1}`).innerHTML = Number(document.getElementById(`${i+1}_${j+1}`).innerHTML)+1 ;
				}
			}			
		}
	}
	
	for(let i = 0 ; i< side_length ; i++) {
		for(let j = 0 ; j<side_length ; j++){
			boardData.push(document.getElementById(`${i}_${j}`).innerHTML);
		}
	}
	
}



function onCellClick(i,j){
	
	if(boardData[i*Math.pow(boardData.length, 1/2) + (j)]=='open'){
		return;
	}
	
	if(!continueGame){
		alert('게임이 종료 되었습니다.');
		return;
	}
	check_win(i,j);
	
	if(document.getElementById(`${i}_${j}`).innerHTML!='X'){
		document.getElementById(`${i}_${j}`).style.backgroundColor = 'white';
		boardData[(i)*Math.pow(boardData.length, 1/2) + (j)] = 'open';
		countOpen++;
	}
	if(document.getElementById(`${i}_${j}`).innerHTML=="0"){
		if( i-1 >=0 && document.getElementById(`${i-1}_${j}`).innerHTML!='X' && boardData[(i-1)*Math.pow(boardData.length, 1/2) + (j)]!='open'){
			onCellClick(i-1,j);
		}
		if( i+1 < Math.pow(boardData.length, 1/2) && document.getElementById(`${i+1}_${j}`).innerHTML!='X'  && boardData[(i+1)*Math.pow(boardData.length, 1/2) + (j)]!='open'){
			onCellClick(i+1,j);
		}
		if( j-1 >=0 && document.getElementById(`${i}_${j-1}`).innerHTML!='X' && boardData[(i)*Math.pow(boardData.length, 1/2) + (j-1)]!='open'){
			onCellClick(i,j-1);
		}
		if( j+1 < Math.pow(boardData.length, 1/2) && document.getElementById(`${i}_${j+1}`).innerHTML!='X'  && boardData[(i)*Math.pow(boardData.length, 1/2) + (j+1)]!='open'){
			onCellClick(i,j+1);
		}
	}
}


function check_win(i,j){
	
	let count_mine = 0;
	
	if(boardData.length==100){
		count_mine = 10;
	}else if(boardData.length==225){
		count_mine = 45;
	}else if(boardData.length==400){
		count_mine = 120;
	}
	
	
	
	
	if(document.getElementById(`${i}_${j}`).innerHTML==='X'){
		for(let k=0; k<Math.pow(boardData.length, 1/2) ; k++){
			for(let l=0; l<Math.pow(boardData.length, 1/2) ; l++){
				if(document.getElementById(`${k}_${l}`).innerHTML=='X'){
					document.getElementById(`${k}_${l}`).style.backgroundColor = 'red';
				}
			}
		}
		alert('패배');
		continueGame = false;
	}else if(countOpen+1==(boardData.length-count_mine)){
		alert('승리')
		continueGame = false;
	}
	
	console.log(countOpen);
	console.log(boardData)
}
















