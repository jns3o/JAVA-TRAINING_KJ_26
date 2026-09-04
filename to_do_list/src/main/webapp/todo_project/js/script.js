const buttonAdd = document.getElementById('add_btn');
const list = document.querySelector("#myList");
const inputList = document.getElementById('insertList');
const dltAll = document.getElementById('delete');
let total = 0; // to do list 등록된 내용 개수

// 추가 버튼을 눌렀을 경우 발생하는 이벤트
buttonAdd.addEventListener('click', () => {	
	//input요소의 값을 담은 inputList라는 변수의 값을 inputText라는 const 변수에 공백을 제거(trim())하고 담음
	const inputText = inputList.value.trim();
	// 만약 inputText의 값이 아무것도 없는 상태에서 추가버튼을 눌렀다면 notice함수를 실행하고 return, 즉 처음으로 되돌아가게함
	if (!inputText){
		notice();
		return;
	}
	//각각의 li요소가 생성될때 마다 list_ 1,2,3...늘어나게 하기 위해 추가이벤트가 반복될때 마다 total이 1씩 증가
	total++;
	// listItem이라는 let으로 선언한 변수에 클릭 이벤트가 발생할때마다 li라는 태그를 붙여서 생성하고 넣어줌
	let listItem = document.createElement('li'); //<li></li>
	listItem.id = 'list_' + total; // 그 listItem변수의 id값을 list_와 매번 늘어나는 total값을 붙여서 추가해줌
	
	// 사용자가 할 일목록(input요소)에 작성한 값을 inputList에 담았는데 그걸 위에서 inputText 변수에 넣었으므로 <li list_ 'total'> </li> 사이에
	// textContent라는 함수를 이용해 텍스트값을 넣어줌
	let chkBox = document.createElement('input'); // <input>
		chkBox.setAttribute('type', 'checkbox'); // <input type="checkbox">
		chkBox.setAttribute('id', 'chk' + total); // <input type="checkbox" id="chk1">
		chkBox.className = 'toggle-input';
		
		let chkLabel = document.createElement('label');
		chkLabel.setAttribute('for', 'chk' + total);
		chkLabel.className = 'toggle-label';
		
		let textSpan = document.createElement('span');
		textSpan.textContent = inputText;
		
		listItem.appendChild(chkBox);
		listItem.appendChild(chkLabel);
		listItem.appendChild(textSpan);// 텍스트만 따로 span태그로 감싸서 체크박스 활성화 시 텍스트에만 줄이 그이게 하는 요소
		//<li><input type="checkbox" id="chk1"><label for="chk1"></label><span>공부하기~</span></li>
	
	let deleteBtn = document.createElement('button');//<button></button>
	deleteBtn.id = 'dlt_btn';
	deleteBtn.textContent = '삭제';//<button>삭제</button>
	deleteBtn.style.color = '#FFFFFF';
	listItem.appendChild(deleteBtn);
	
	if (list.firstElementChild && list.firstElementChild.textContent === "아직 할 일이 없습니다"){
		list.innerHTML = '';
	}

	list.appendChild(listItem);
	
	inputList.value = '';
	document.querySelector('.notice-box').innerHTML = '';
});
// HTML에서 '일괄삭제' 버튼을 눌렀을때 할 일 목록의 li 요소가 전부 삭제되게 하는 이벤트 기능
document.querySelector("#delete").addEventListener("click", function() {
    document.querySelector("#myList").innerHTML = "";
	if (list.children.length === 0){
				list.innerHTML = '<li>아직 할 일이 없습니다</li>'; // 일괄삭제 됐을때도 할 일이 없다는 문구를 띄워주기 위해 사용
			}
});

// Enter를 눌렀을때도 출력이 되게 하기 위함 
inputList.addEventListener('keyup', event => {
	if(event.key === 'Enter'){
		buttonAdd.click();
	}
});
// ul요소안에서 클릭을 한 타겟이 삭제 버튼일 경우 해당 li의 부모요소를 찾아가 삭제시켜버린다
list.addEventListener("click", event => {
	if (event.target.id === 'dlt_btn'){
		const liItem = event.target.closest('li');
		liItem.remove();
		// list변수의 자식요소의 길이가 0이 됐다는건 할일목록이 없다는 뜻이므로 li태그를 만들고 그 안에 '아직 할 일이 없습니다'라는 문구도 추가해서
		// html요소로 추가함!
		if (list.children.length === 0){
			list.innerHTML = '<li>아직 할 일이 없습니다</li>';
		}
	}
	// 만약 ul요소안에서 클릭을 한 타겟이 체크박스일 경우 체크박스가 체크될 경우 검정과 흰색일직선을 그리고 해제하면 다시 검정을 칠하고 선을 없애는 if문
	if (event.target.type === 'checkbox') {
		    const liItem = event.target.closest('li'); 
		    const targetSpan = liItem.querySelector('span'); // li 안에 있는 span(글자 캡슐)을 찾음
		    
		    if (event.target.checked) {
		        targetSpan.style.color = '#FFFFFF';
		        targetSpan.style.textDecoration = 'line-through';
		        targetSpan.style.textDecorationColor = 'black';
		    } else {
		        targetSpan.style.color = 'black';
		        targetSpan.style.textDecoration = 'none';
		    }
		}
	});
// 만약 html에서 input창에 아무것도 적지않고 'enter' 또는 'click'을 하였을때 경고문구 띄우는 함수!
function notice(){
	let say = '';
	let setSay = '<div class="notice">[!] 할 일은 필수 입력입니다</div>';
	say = setSay;
	document.querySelector('.notice-box').innerHTML = say;
}