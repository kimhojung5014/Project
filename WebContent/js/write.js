function writeCheck() {
	
	const category = document.getElementById('category');					 
	const title = document.getElementById('title');	
	const content = document.getElementById('content');				
	
	if(title.value.length >50){
		alert("제목은 50자 안으로 입력해주세요")
	
	}else if (content.value.length >= 1000) {
		alert("본문은 1000자 이내로 입력해주세요")
		
	}else {
		document.getElementById('writeForm').submit();
	}
}
function editCheck() {
	
	const category = document.getElementById('category');					 
	const title = document.getElementById('title');	
	const content = document.getElementById('content');				
	
	if(title.value.length >50){
		alert("제목은 50자 안으로 입력해주세요")
	
	}else if (content.value.length >= 1000) {
		alert("본문은 1000자 이내로 입력해주세요")
		
	}else {
		document.getElementById('writeForm').submit();
	}
}
function replyInsert() {
	const replyContent = document.getElementById("replyContent").value;						

	if(replyContent.length > 1000){
		alert("댓글은 1000자 안으로 입력해주세요")
	
	}else if (replyContent.length == 0) {
		alert("댓글은 내용을 입력해주세요")
	}
	else {
		document.getElementById('replyForm').submit();
	}
}

//답글 달기 누르면 아래 생김
function choose(index) {
	  
	  const reply = document.getElementsByClassName("reply");
	  reply[index].style.display ="block";
	  reply[index].style.padding ="10px";
	  reply[index].style.lineHeight = "10px";

}
// 댓글 수정
function chooseEdit(index) {
	  
	  const replyEdit =  document.getElementsByTagName("replyEdit"); // 버튼 배열로 받아온다.
	  const replyContent =  document.getElementsByTagName("replyContent"); //수정할 댓글의 인덱스필요
	  if ( replyContent[index].readOnly) {
		  replyContent[index].readOnly = false;//리드 온리 풀어서 값 바꿀수 있게
		  replyEdit[i].value = '완료';
		  replyEdit[index].onclick = function() {
			  document.location.href = "replyEdit.do?replyContent ="+replyContent[index].value;
		  } 
	}
}
//댓글 삭제 일단 보류 지금은 펑션 안쓰고 바로 전환되게 해놓음
//function chooseDelete(index) {
//	  
//	  const chooseDelete = document.getElementsByClassName("reply");
//	  reply[index].style.display ="block"
//
//}

//이건 지금 작동안해서 따로 빼놓음 대댓글 체크 메소드
function rereplyInsert(i) {
	const rereplyContent = document.getElementsByClassName("rereplyContent");				
	const form = document.getElementsByTagName('rereplyForm');
	if(rereplyContent[i].length > 1000){
		alert("댓글은 1000자 안으로 입력해주세요")
	
	}else if (rereplyContent[i].length == 0) {
		alert("댓글은 내용을 입력해주세요")
	}
	else {
		form(i).submit();
	}
}