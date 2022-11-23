 let gameboard ; 

 function start_game(){
	gameboard = ''
	for(let y = 1 ; y<=19 ; y++){
		gameboard += `<tr>`
		for(let x = 1 ; x<=19 ; x++){
			gameboard += `<td></td>`
		}
		gameboard += `</tr>`
	}
	document.getElementById('board').innerHTML = gameboard
}

start_game()
