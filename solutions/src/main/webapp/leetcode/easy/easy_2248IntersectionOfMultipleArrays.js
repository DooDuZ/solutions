/**
 * 
 */
 
let nums = [[46,25,24,22,35,36]];


function test(){
    let answer = [];
    if(nums.length>1){
        for(let i of nums[0]){
            for(let j of nums[1]){
                if(i==j){
                    answer.push(i)
                }
            }
        }
    }else{
        for(let i=0; i<nums[0].length ; i++){       
			for(let j = 0 ; j<nums[0].length ; j++){
	            if(nums[0][j]>nums[0][j+1]){
	                let tmp = nums[0][j]
	                nums[0][j] = nums[0][j+1]
	                nums[0][j+1] = tmp
	            }
            }
        }
        return nums[0];
    }
    for(let i = 0 ; i<nums.length ; i++){
        let el = answer.filter( (value) => nums[i].includes(value) );
        answer = el;
    }    
    for(let i = 0 ; i<answer.length ; i++){
		for(let j = 0; j<answer.length ; j++){
			if(answer[j]>answer[j+1]){
				let tmp = answer[j]
				answer[j] = answer[j+1]
				answer[j+1] = tmp
			}
		}
	}
    return answer;
}
test();
	/*
	 let nums = [ [1,2,3,4,5,6,7,8,9], [3,6,9,5,2,4], [5,15,12,20,7,3,1,2], [19,2,4,3,8,5,2]  ]
	function checkIndex(nums) {
		let answer = [];
		
		for(let i of nums[0]){
			for(let j of nums[1]){
				if(i==j){
					answer.push(i)
				}
			}
		}
		console.log("첫번째 answer : " + answer);
		
		for(let i = 0 ; i<nums.length ; i++){
			let el = answer.filter( (value) => nums[i].includes(value) );
			answer = el;
		}
		console.log("최종 : " + answer);
	};
	checkIndex(nums)

	function test(){
	    let answer = [];
	    if(nums.length>1){
	        for(let i of nums[0]){
	            for(let j of nums[1]){
	                if(i==j){
	                    answer.push(i)
	                }
	            }
	        }
	    }else{
	        for(let i = 0; i<nums[0].length ; i++){
	            let tmp;
	            if(nums[0][i]>nums[0][i+1]){	                
	            }	            
	        }	        
	        return nums[0];
	    }
	    for(let i = 0 ; i<nums.length ; i++){
	        let el = answer.filter( (value) => nums[i].includes(value) );
	        answer = el;
	    }
	    console.log(answer);
	    return answer;
	}
	test();*/