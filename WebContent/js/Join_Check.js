
function pw_Check() {
	/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
	/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
	/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
		var password = document.getElementById('pw');					//비밀번호 
		var passwordConfirm = document.getElementById('pwCheck');	//비밀번호 확인 값
		var pwMsg = document.getElementById('pwMsg');				//확인 메세지
		var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
		var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(password.value == pwCheck.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
			pwMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
			pwMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
		}else{
			pwMsg.style.color = wrongColor;
			pwMsg.innerHTML ="비밀번호 불일치";
		}
	}

function id_Check(){

	  var id =  document.getElementById("userId");
	  var idMsg = document.getElementById("idMsg");
	  var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	  var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔

	  if(id.value.length <= 4){
		  	idMsg.style.color = wrongColor;
			idMsg.innerHTML = "5글자 이상 입력바랍니다.";
	  }else {
		  idMsg.innerHTML = "";
	  }
	}
function id_overlap() {
	var id =  document.getElementById("userId");
	document.location.href = "idCheck.join?id="+id.value;

}