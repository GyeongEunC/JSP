function movieCheck() {
	if(document.frm.title.value.length == 0) {
		alert("영화 제목 입력");
		frm.title.focus();
		return false;
	} 
	if(document.frm.price.value.length == 0) {
		alert("가격 입력");
		frm.price.focus();
		return false;
	}
	if(isNaN(document.frm.price.value)) {
		alert("숫자 이외의 문자는 입력 불가");
		frm.price.focus();
		return false;
	}
	
}
