function commentInsert () {
	const commentContent = document.getElementById("commentContent").value;
	if(commentContent == 0){
		alert("내용을 입력해주세요")
	}else if (commentContent >1000) {
		alert("댓글은 1000자 까지 입력 가능합니다.")
	}
}