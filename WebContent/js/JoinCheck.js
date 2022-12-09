function pw_Check(){

  if(document.joinForm.pw.value != document.joinForm.pwCheck.value){
    alert("비밀번호가 일치하지 않습니다.");
    document.joinForm.pw.focus();
    return false;
  }

  }