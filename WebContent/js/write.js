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
function choose(i) {
	  
	  const reply = document.getElementsByClassName("reply");
	  reply[i].style.display ="block";
	  reply[i].style.padding ="10px";
	  reply[i].style.lineHeight = "10px";

} 	

//function rereplyInsert(i) {
//	const rereplyContent = document.getElementsByClassName("rereplyContent");				
//	const form =     document.querySelectorAll('.reReplyForm');
//	if(rereplyContent[i].length > 1000){
//		alert("댓글은 1000자 안으로 입력해주세요")
//	
//	}else if (rereplyContent[i].length == 0) {
//		alert("댓글은 내용을 입력해주세요")
//	}
//	else {
//	form[i].submit();
//	}
//}