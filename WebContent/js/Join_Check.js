// 비밀번호 동일한지 체크하는 메소드
function pw_Check() {
	/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
	/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
	/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
	const password = document.getElementById('pw');					//비밀번호 
	const passwordConfirm = document.getElementById('pwCheck');	//비밀번호 확인 값
	const pwMsg = document.getElementById('pwMsg');				//확인 메세지
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(password.value == pwCheck.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
			pwCheckMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
			pwCheckMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
			return true;
		}else{
			pwCheckMsg.style.color = wrongColor;
			pwCheckMsg.innerHTML ="비밀번호 불일치";
		
		}
	}
//비밀번호 글자 수 체크
//비밀번호 정규식 체크 ^[a-zA-Z\\d`~!@#$%^&*()-_=+]{8,24}$
//비밀번호 안먹으니 나중에
function pw_Regular_Check(){

	const password =  document.getElementById("pw");
	const pwMsg = document.getElementById("pwMsg");
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
	  const  pattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/; // 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식 ( 3 가지 조합)
	  
	  if(pattern.test(password.value)){
		  pwMsg.style.color = correctColor;
		  pwMsg.innerHTML = "OK";
			return true;
		  
	  }
	  else{
		  pwMsg.style.color = wrongColor;
		  pwMsg.innerHTML = "특수문자, 숫자, 영어 포함 8-15자리 이내로 작성해주세요 .";	
	      
	}
	}
//아이디 5글자 이상인지 체크하는 메소드
function id_Check(){

	const id =  document.getElementById("userId");
	const idMsg = document.getElementById("idMsg");
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔

	  if(id.value.length < 5){
		  	idMsg.style.color = wrongColor;
			idMsg.innerHTML = "5글자 이상 입력바랍니다.";
			return false;
	  }else if (id.value.length > 12) {
		  	idMsg.style.color = wrongColor;
			idMsg.innerHTML = "12글자까지  입력바랍니다.";
			return false;
			
	  }else{
		  	idMsg.style.color = correctColor;
		  	idMsg.innerHTML = "OK";
		  	return true;
	  }
	}
//아이디 중복체크 누르면 id를 컨트롤러로 보내서 확인함
function id_overlap() {
	if (id_Check()) {
		const id =  document.getElementById("userId");
		document.location.href = "idCheck.join?id="+id.value;
		return true;
	}else {
		alert("아이디 글자수를 확인해주세요.");
	}
	
}
//닉네임 2글자 이상 확인
function nick_Check(){

	const nickName =  document.getElementById("nickName");
	const nickNameMsg = document.getElementById("nickNameMsg");
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔

	  if(nickName.value.length < 2){
		  nickNameMsg.style.color = wrongColor;
		  nickNameMsg.innerHTML = "2글자 이상 입력바랍니다.";
		  return false;
	  }else if (nickName.value.length > 12) {
		  nickNameMsg.style.color = wrongColor;
		  nickNameMsg.innerHTML = "12글자까지  입력바랍니다.";
		  return false;
			
	  }else {
		  nickNameMsg.style.color = correctColor;
		  nickNameMsg.innerHTML = "OK";
		  return true;
	  }
	}

function nickName_overlap() {
	if (nick_Check()) {
		const nickName =  document.getElementById("nickName");
		document.location.href = "nickNameCheck.join?nickName="+nickName.value;
		return true;
	}else {
		alert("닉네임 글자수를 확인해주세요.");
	}
}
//이메일 주소 정규식 
function eMail_Check() {
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
	const eMail = document.getElementById("eMail");
	const eMailMsg = document.getElementById("eMailMsg");
	const regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if (regExp.test(eMail.value)) {
		eMailMsg.style.color = correctColor;
		eMailMsg.innerHTML = "OK";
		return true;
	}else {
		eMailMsg.style.color = wrongColor;
		eMailMsg.innerHTML = "이메일을 확인해주세요.";
	}
}

//전화 번호 정규식
function tel_Check() {
	const correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	const wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
	const telNumber = document.getElementById("telNumber");
	const telMsg = document.getElementById("telMsg");
	const regExp = /^\d{3}-\d{3,4}-\d{4}$/;
	if (regExp.test(telNumber.value)) {
		telMsg.style.color = correctColor;
		telMsg.innerHTML = "OK";
		return true;
	}else {
		telMsg.style.color = wrongColor;
		telMsg.innerHTML = "전화번호 형식을 확인해주세요.";
	}
}

function final_Check() {
	
	if (pw_Check() && pw_Regular_Check() && id_Check() && nick_Check()
		&& eMail_Check() && tel_Check()) {
		alert("회원가입에 성공하였습니다.");
		document.getElementById('joinForm').submit();
	}else {
		alert("모든 항목을 입력해주세요");
	}
	
}