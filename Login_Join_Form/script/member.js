function loginCheck() {
	if (document.frm.userid.value.length == 0) {
		alert("아이디 입력 바람");
		frm.userid.focus();
		return false;
	}

	if (document.frm.pwd.value == "") {
		alert("암호는 공백일 수 없습니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}


function idCheck() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력해 주세요');
		document.frm.userid.focus();
		return;
	}

	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=650, height=400");
}


function idok() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}



// 회원 가입 스크립트
function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert('이름은 공백일 수 없습니다.');
		frm.name.focus();
		return false;
	}

	if (document.frm.userid.value.length == 0) {
		alert('아이디는 공백일 수 없습니다.');
		frm.userid.focus();
		return false;
	}

	if (document.frm.userid.value.length < 4) {
		alert('아이디는 4자 이상이어야 합니다');
		frm.userid.focus;
		return false;
	}

	if (document.frm.pwd.value == "") {
		alert('암호는 공백일 수 없습니다.');
		frm.pwd.focus();
		return false;
	}

	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert('암호가 일치하지 않습니다.');
		frm.pwd.focus();
		return false;
	}

	if (document.frm.reid.value.length == 0) {
		alert('중복 체크를 하지 않았습니다.');
		frm.userid.focus();
		return false;
	}

	return true;

}
