/**
 * 
 */
 
 
 const btn_box = document.querySelector('.btn_box')
 const select_numb = document.querySelector('.select_numb')
 const completed = document.querySelector('.completed')
 const winning_numb = document.querySelector('.winning_numb')
 const united_numb = document.querySelector('.united_numb')
 const ranking = document.querySelector('.ranking')
 
 
 let select_box = [];
 let completed_box = [];
 let draw_number = [];
 
 function print_btn(){							//번호판 만들기
	
	let btn_board = ''; 						//함수에서 곧바로 HTML로 출력하기보다 함수 내에서 선언한 변수에 담아서 출력하면 초기화할 때 편해요!
	for(let i = 1 ; i<=45 ; i++){				//45번 숫자 바꾸면서 칠거면 안써도 돼요. 물론 그러지 않을거라 믿어요...!
		btn_board += `<button id=${i} onclick="click_btn(${i})">${i}</button>`;	//선언한 변수에 숫자 버튼을 누적 더하기 해주기 												
												//처음엔 <button>${i}</button> 만 입력한 후 필요할 때마다 기능추가 해줄거에요.
	}											
												//;는 코드의 마침표라고 이해하기! 
												//JS는 ;를 입력하지 않아도 자동 처리 해주지만, 스스로 다는 습관을 들이면 오작동을 방지할 수 있다고 해요!
	btn_box.innerHTML = btn_board ; 			//버튼을 HTML에 출력해주기
}//function end

print_btn();									//함수를 만들었으니 호출해줬어요


/*
	버튼 클릭 기능 추가하기! 버튼에 기능추가를 할 생각이니 print_btn()에 있는 button들에 onclick효과를 추가할 거에요.
	파라미터(매개변수)가 필요하다면 어떤 방식으로 가져와서 컨트롤할지 고민하기! -> 파라미터의 필요 여부는 경험으로...판단해야 합니다. 왕도가 없어요ㅜㅜ
	전 id를 파라미터로 받을 생각이기 때문에 print_btn()의 button에 id까지 지정해줄 거에요! 
	굳이 파라미터라고 부르는 이유는 현업에서 변수, 매개변수보다 많이 쓰이는 것 같기 때문이에요. 저 영어 못해요...
	그러나 익숙해지기 위해서 파라미터라는 말을 주석에서도 자주 써줄거에요!
*/

function click_btn( i ){				
	const select_btn = btn_box.querySelectorAll('button');	//css를 컨트롤하기 위해서 btn_box안의 button요소들을 다시한번 불러줬어요.
															//style만 바꿀 게 아니라 눌려진 버튼값을 저장하기 위해 상단에 새로운 배열을 선언해요.
	if(select_box.indexOf(i)<0){							//배열명.indexOf(i) -> 배열안에 i라는 값의 인덱스값을 찾아줘요. 만약 배열내에 i가 없다면 -1이 나와요
															//배열명.indexOf(i) <0 -> 배열내에 i값이 없다면
		if(select_box.length==6){							//선택 숫자가 6개가 넘어가지 않도록 select_box의 lenngth값을 통해 제어해주기
		alert('숫자 선택완료');									//숫자 6개가 모두 선택되었더라도 선택했던 번호를 뺄때는 함수가 작동해야하기 때문에 if문 안에 위치시켰어요
		return;												//함수 탈출. 아래에 있는 코드 실행을 막아줬어요
		}
		select_btn[i-1].style.color = '#ffffff';			//눌렀을때 효과 추가
		select_btn[i-1].style.backgroundColor = '#f67a7a';
		select_box.push(i);									//선택된 숫자를 배열에 추가
	}else{													//배열 내에 i값이 있는경우
		select_btn[i-1].style.color = '#f67a7a';			//css를 원래대로 돌려주기
		select_btn[i-1].style.backgroundColor = '#ffffff';
		
		let del_numb = select_box.indexOf(i);				//i의 배열 내 위치를 찾아준 후
		select_box.splice(del_numb, 1);						//splice(시작인덱스, 삭제할 개수) 를 이용해 i값을 삭제해줘요
	}
	select_numb.textContent = select_box;					//선택한 번호를 HTML로 출력해줘요
}


let count = 0;	//선택완료 된 복권을 삭제할 때 식별값으로 쓸거에요!

function select_complete(){									//6개의 번호를 고른 뒤 구매를 확정하는 함수를 만들어요. 역시 6개의 수를 계속해서 저장하기 위해 새 배열을 선언해요
	if(select_box.length<6){
		alert('번호를 모두 선택해주세요.')
		return
	}
	completed_box.push(select_box);							//선택된 번호를 완료 배열에 저장하기
	completed.innerHTML += `<div onclick="del_com(${count})">${completed_box[count]}</div>`
	count++;
	//선택 완료된 번호를 HTML에 추가해주기. div에도 onclick 적용이 가능해요. 완료된 번호에도 삭제 기능을 추가해줄 생각이에요.
	console.log(completed)
	console.log(count)
	//click_btn에서 컨트롤했던 css를 초기화시켜야 해요! 
	//버튼이 생성되기 전에 호출하면 오류가 나기때문에 함수 안에서만 선언해서 활용해요. click_btn함수에서 생성된 객체는 함수를 벗아나면서 사라져요.
	const select_btn = btn_box.querySelectorAll('button');	
	for(let i = 0; i<6 ; i++){											//0~5까지로 설정하긴 했지만 사실 select_box의 길이만큼 실행해 줬어요.
		select_btn[select_box[i]-1].style.color = '#f67a7a';			//class와 index를 같은 규칙으로 맞춰두었기 때문에 이런식으로 활용이 가능해요.
		select_btn[select_box[i]-1].style.backgroundColor = '#ffffff';	//인덱스와 지정한 값이 다르기떄문에 -1로 보정해줘요.
	}	
	
	select_box = [];										//선택번호 배열 초기화! 이렇게해야 계속해서 복권을 구매할 수 있어요
	select_numb.textContent = '';							//HTML에 출력된 숫자들 역시 스스로 없어지지 않으니 지워줘요 
}

function del_com( p ){									//선택 완료된 복권 삭제하기. select_complete에서 생성한 div에서 파라미터를 받아왔어요	
	if(confirm("이 번호 버려...?")){						
		completed_box.splice(p, 1);						//역시 splice를 이용해서 제거할 거에요.
		count--;										//count는 html의 div를 컨트롤하기 위한 변수이기 때문에, div가 하나 줄어든다면 --해줘야해요
		let board_reset = '';							//completed_box의 값을 다시 입력하기 위해 새로운 변수를 지정해주고
		for(let i = 0; i<count ;i++){					//for문을 이용해 completed_box의 인덱스마다 새로운 onclick 파라미터를 지정해주기
			board_reset += `<div onclick="del_com(${i})">${completed_box[i]}</div>`		//그리고 누적 더하기 !!!
		}												//전 여기서 위에서의 오타와 겹쳐서... 엄청난 방황을 했어요.  +=와 =도 여러번 바꿨어요
														//제 설명이 부족해서 이해하기어렵더라도... 포기 ㄴㄴ!!!! 
		completed.innerHTML = board_reset;				//변경된 변수를 HTML에 출력
	}
}



function draw_numb(){										//1등해서 학원 때랴칠라믄... 번호 추첨을 해야겠쬬? 상단에 정보를 저장할 배열을 함께 선언해줘요.
	
	while(true){											//번호 6개까지 반복시키기. 저는 while에 익숙하지 않아서 일부러 while을 썼어요. 개인적으론 for문을 통한 반복을 선호해요.
		let rand = Math.floor(Math.random()*45+1);			//무작위 번호 추첨을 위해 1~45까지의 난수를 선언해 줬어요
		if(draw_number.indexOf(rand)<0){					//추첨번호 배열 내에 생성된 난수값이 없다면 
			draw_number.push(rand);							//배열에 생성된 변수를 push해줘요
		}
		if(draw_number.length==6){							//배열에 6개의 숫자가 모두 들어갔다면 break. 그 전엔 계속해서 난수가 생성될 거에요
			break;
		}
	}
	winning_numb.textContent = draw_number;
	check_united();
}

let united_array = [];										//매치된 번호를 배열에 저장. 사실 지금 피곤해서 배열에 때려박구있음니다. 별로 좋은 방법은 아닌거같아요. 변수로해도 충분할듯!

function check_united(){									//일치번호 찾기 및 등수 체크. 졸려서 주석없음...
	
	for(let t = 0 ; t<completed_box.length ; t++){			//뒤늦게 추가한 반복문이어서 변수가 t입니다.. 
		let united_arr =[];									//배열을 선언하구
		for(let i = 0 ; i<6 ; i++){							//일치번호 찾기 반복문 돌리기
			for(let j = 0 ; j<6 ; j++){
				if(completed_box[t][i]==draw_number[j]){	//번호가 일치하면
					united_arr.push(completed_box[t][i]);	//임시로 선언한 배열에 푸시한 후
				}
			}
		}united_array.push(united_arr);						//그 배열을 다시 맞춘 번호 배열에 푸시 해줍니다! 
	}														//번호를 최대 6개씩 저장하려구 이렇게 했어요
	console.log(united_array);
	for(let i =0 ; i<united_array.length ; i++){			//아래는 단순 길이체크니 생략할게용
		if(united_array[i]==0){								//이케 끝났습니다!
			united_numb.innerHTML += '일치번호 없음 <br>'
		}else{
		united_numb.innerHTML += `<div>${united_array[i]}</div>`;
		}
		if(united_array[i].lenght==6){
			ranking.innerHTML += i+'회차 : 1 등 당 첨 <br>'
		}else if(united_array[i].lenght==5){
			ranking.innerHTML += i+ '회차 : 2 등 당 첨 <br>'
		}else if(united_array[i].lenght==4){
			ranking.innerHTML += i+'회차 : 3 등 당 첨 <br>'
		}else if(united_array[i].lenght==3){
			ranking.innerHTML += i+'회차 : 4 등 당 첨 <br>'
		}else{
			ranking.innerHTML += i+'회차 : 꽝 <br>'
		}
	}
}
