

let board = ''

let 게임상황 = []


let Oturn= []
let Xturn= []



function gamestart(){
	board = ''
	게임상황 = [];	Oturn= [] ; Xturn= [] ;
	
	for(let i = 0 ; i<9 ; i++){
		board += `<button id=${i} onclick="click_btn(${i})">${i}</button>` 
		if(i%3==2){
			board += '<br>'
		}
	}
	document.getElementById('gameboard').innerHTML = board	
}

function click_btn(i){
	//눌렀을 때 효과추가
	
	if(중복검사(i)){
		alert('이미 둔 자리입니다.')
		return
	}
	게임상황.push(i)
	Oturn.push(i)
	document.getElementById(i).innerHTML = 'O'
	승리판단(Oturn)
	
	//상대턴 실행
	let rand ;
	for(let i = 0 ; i<1 ; i++){
		rand = Math.floor(Math.random()*9)
		if(중복검사(rand)){
			i--
		}
	}	
	게임상황.push(rand)
	Xturn.push(rand)
	document.getElementById(rand).innerHTML = 'X'
	승리판단(Xturn)
}


function 중복검사(i){
	if(게임상황.indexOf(i)>=0){
		return true
	}
}

let winner ;

if(게임상황.length%2==0){
	winner = 'O'
}else{
	winner = 'X'
}


function 승리판단(x){
	let count = 0
	for(let i = 0 ; i<=6 ; i+=3){
		for(let j = i ; j<=i+2 ; j++){
			if(x.indexOf(j)>=0){
				count ++
			}
		}		
	}
	console.log(count)
	console.log(Oturn)	
	if(count==3){
		alert('승리 : ' + winner )
	}
	return
}













