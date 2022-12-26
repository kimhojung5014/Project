function writeCheck() {
						 
	let title = document.getElementById('title');	
	let content = document.getElementById('content');				

	if(title.value.length  >50 || title.value ==""){
		alert("제목은 50자 안으로 입력해주세요");
		return
	
	}else if (content.value.length >= 1000 || content.value == "") {
		alert("본문은 1000자 이내로 입력해주세요")
		return
	}else {
		document.getElementById('writeForm').submit();
	}
}

function replyInsert() {
	const replyContent = document.getElementById("replyContent").value;						

	if(replyContent.length > 1000){
		alert("댓글은 1000자 안으로 입력해주세요")
	
	}else if (replyContent.length == 0) {
		alert("댓글 내용을 입력해주세요")
	}
	else {
		document.getElementById('replyForm').submit();
	}
}

function rereplyInsert(i) {
	let recontent =	document.getElementsByClassName("recontent");				
	let replyform = document.getElementsByName("rereplyForm");
	
		if(recontent[i].value.length > 1000){
			alert("댓글은 1000자 안으로 입력해주세요")
			return
		
		}else if (recontent[i].value.length == 0) {
			alert("댓글은 내용을 입력해주세요")
			return
		}else  {
			replyform[i].submit();
			
	}
}
//답글 달기 누르면 아래 생김
function choose(i) {
	  
	  let reply = document.getElementsByClassName("reply");
	  reply[i].style.display ="block";
	  reply[i].style.padding ="10px";
	  reply[i].style.lineHeight = "10px";

}
// 댓글 수정
function replyEdit(i,commentNum) {
	  
	  let replyEdit =  document.getElementsByName("replyEdit"); // 버튼 배열로 받아온다.
	  let replyContent =  document.getElementsByName("replyContent"); //수정할 댓글의 인덱스필요
	  if ( replyContent[i].readOnly) {
		  replyContent[i].readOnly = false;//리드 온리 풀어서 값 바꿀수 있게
		  replyContent[i].focus();
		  replyEdit[i].style.backgroundColor = "blue";
		  replyEdit[i].value = '완료';
		  replyEdit[i].onclick = function() {
			  // 댓글 길이 체크
			  if (replyContent[i].value.length == 0) {
					alert("댓글 내용을 입력해주세요")
					 replyContent[i].focus();
			  }else if (replyContent[i].value.length > 1000) {
					alert("댓글은 1000자 안으로 입력해주세요")
					 replyContent[i].focus();
			  }else {
				  document.location.href = "replyEdit.do?replyContent="+replyContent[i].value+"&commentNum="+commentNum;
			}
	  	} 
	}
}
//대댓글 수정 
function rereplyEdit(i,commentNum) {
	  
	  let rereplyEdit =  document.getElementsByName("rereplyEdit"); // 버튼 배열로 받아온다.
	  let rereplyContent =  document.getElementsByName("rereplyContent"); //수정할 댓글의 인덱스필요
	  if ( rereplyContent[i].readOnly) {
		  rereplyContent[i].readOnly = false;//리드 온리 풀어서 값 바꿀수 있게
		  rereplyContent[i].focus();
		  rereplyEdit[i].style.backgroundColor = "blue";

		  rereplyEdit[i].value = '완료';
		  rereplyEdit[i].onclick = function() {
			  if (rereplyContent[i].value.length == 0) {
					alert("댓글 내용을 입력해주세요")
					rereplyContent[i].focus();
			  }else if (rereplyContent[i].value.length > 1000) {
					alert("댓글은 1000자 안으로 입력해주세요")
					rereplyContent[i].focus();
			  }else {
				  document.location.href = "replyEdit.do?replyContent="+rereplyContent[i].value+"&commentNum="+commentNum;
			}
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



function show() {
	const reply = document.getElementById("#click_reply2")
	reply.readOnly = false;
	
}