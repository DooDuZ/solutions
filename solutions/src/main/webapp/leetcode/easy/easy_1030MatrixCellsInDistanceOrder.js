


let rows = 2;
let cols = 2;
let rCenter = 0;
let cCenter = 1;

function logic(){
	let answer = [];
	
	for(let i = 0; i<rows ; i++){
		let distanceRow = 0;
		let distanceCol = 0;
		for(let j = 0 ; j<cols ; j++){
			distanceRow = rCenter-i;
			distanceCol = cCenter-j;
			if(distanceRow<0){
			distanceRow = (-1)*distanceRow;
			}
			if(distanceCol<0){
				distanceCol = (-1)*distanceCol;
			}
			let distance = distanceRow+distanceCol;
			let answerCol = [i, j, distance];
			answer.push(answerCol);
		}
	}
	console.log(JSON.parse(JSON.stringify(answer)))

	for(let i = 0 ; i<answer.length ; i++){
		for(let j= i ; j<answer.length ; j++){
			if(answer[i][2]>answer[j][2]){
				let tmp = answer[i];
				answer[i] = answer[j];
				answer[j] = tmp;
			}
		}
	}
	console.log(JSON.parse(JSON.stringify(answer)))
	
	for(let i = 0 ; i<answer.length ; i++){
		answer[i].splice(2, 1);
	}
	console.log(JSON.parse(JSON.stringify(answer)))
}
logic();


