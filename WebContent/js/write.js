function writeCheck() {
	
	const category = document.getElementById('category');					//비밀번호 
	const title = document.getElementById('title');	//비밀번호 확인 값
	const content = document.getElementById('content');				//확인 메세지)
	
	if(title.value.length >50){
		alert("제목은 50자 안으로 입력해주세요")
		return false;
	}else if (content.value.length >= 1000) {
		alert("본문은 1000자 이내로 입력해주세요")
		return false;
	}else {
		document.location.href =""
		document.getElementById('writeForm').submit();
	}
}