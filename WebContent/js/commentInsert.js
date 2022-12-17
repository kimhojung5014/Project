function replyInsert () {
	const replyContent = document.getElementById("replyContent").value;
	if(replyContent.length < 1){
		alert("내용을 입력해주세요")
	}else if (replyContent.length >1000) {
		alert("댓글은 1000자 까지 입력 가능합니다.")
	}
}