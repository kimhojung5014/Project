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

function commentInsert() {
	const commentContent = document.getElementById('commentContent');					
	
	if(commentContent.value.length > 1000){
		alert("댓글은 1000자 안으로 입력해주세요")
	
	}else {
		document.getElementById('conmentForm').submit();
	}
}