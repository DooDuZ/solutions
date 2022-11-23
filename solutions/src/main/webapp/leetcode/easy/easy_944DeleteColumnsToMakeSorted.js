

let strs = ["abcd", "abce", "dark"]

console.log(strs[0].length);

function answer(strs) {
    let alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
    
    let count = 0 ;
    
    let judgement = true;
    for(let i = 0; i<strs[0].length ; i++){
        for(let j = 0 ; j<strs.length-1 ; j++){
            if(alpha.indexOf(strs[j][i])>alpha.indexOf(strs[j+1][i])){
                judgement = false;
            }
        }
        if(judgement){
            count++;
        }else{
            judgement = true;
        }
    }
    console.log(strs[0].length-count);
    return (strs[0].length-count);    
};

answer(strs);