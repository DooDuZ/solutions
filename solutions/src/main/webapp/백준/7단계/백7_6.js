/**
 * 
 */
 
 
 let array = [];

 for(let i = 0 ; i< 15 ; i++){
	let cols=[];
	for(let j = 0 ; j<14 ; j++){
		let sum = 0 ;
		if(i==0){
			sum = j+1 ;
			cols.push(sum);
		}else if(j==0){
			sum = 1;
			cols.push(sum);
		}else{
			sum = (array[i-1][j] + cols[j-1]);
			cols.push(sum);
		}
	}
	array.push(cols);
}
console.log(array);




/*
let x = Math.floor(Math.random()*14)+1;
let y = Math.floor(Math.random()*14)+1;

for(let i = 0 ; i<x ; i++ ){
	let cols=[];
	for(let j = 1 ; j<y ; j++){
		let sum = 0 ;
		if(i==0){
			sum = j+1 ;
			cols.push(sum);
		}else if(j==1){
			sum = 1;
			cols.push(sum);
		}else{
			sum = (array[i-1][j] + cols[j-1]);
			cols.push(sum);
		}
	}
}

console.log(x);
console.log(y);
console.log(array[x][y]);
*/
