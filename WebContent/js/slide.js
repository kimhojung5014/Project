
let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}

// 잠깐 다른 곳
function infoConfirm() {
	if(document.reg_frm.id.value.length == 0){
		alert("아이디는 필수 사항입니다.");
		reg_frm.id.focus();
		return;
	}
  if(document.reg_frm.id.value.length < 0){
		alert("아이디는 4글자 이상입니다.");
		reg_frm.id.focus();
		return;
	}
  if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호는 필수 사항입니다.");
		reg_frm.pw.focus();
		return;
	}
  if(document.reg_frm.pw.value != document.reg_frm.pw_check.value ){
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
  if(document.reg_frm.name.value.length == 0 ){
		alert("이름은 필수사항입니다.");
		reg_frm.pw.focus();
		return;
	}
  if(document.reg_frm.eMail.value.length == 0 ){
		alert("이메일은 필수사항입니다.");
		reg_frm.pw.focus();
		return;
	}
  document.reg_frm.submit();
}

function updateInfoConfirm(){

  if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
    alert("비밀번호가 일치하지 않습니다.");
    document.reg_frm.pw.focus();
    return;
  }
  if(document.reg_frm.pw.value == ""){
    alert("패스워드를 입력하세요");
    document.reg_frm.pw.focus();
    return;
  }

  if(document.reg_frm.eMail.value.length == 0){
    alert("메일은 필수사항입니다.");
    document.reg_frm.eMail.focus();
    return;
  }
  
  document.reg_frm.submit();
}