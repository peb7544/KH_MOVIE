
/*회원가입*/
// 유효성 검사 객체
const checkObj = {
    "inputId" : false, // 아이디
    "inputPw" : false, // 비밀번호
    "inputPw2" : false, // 비번확인
    "inputNm" : false // 닉네임
};

function validate() {

    for(let key in checkObj) {
        if(!checkObj[key]) {
            alert("유효성검사가 완료되지않았습니다.");
            return false;
        }
    }

    return true;
}

// 아이디 유효성 검사
const inputId = document.getElementById("inputId");
const idMsg = document.getElementById("idMsg");

inputId.addEventListener("change", function() {
    
    const regExp = /^[a-z][\w!@#$%^&*_-]{5,13}$/;
    // 소문자 시작(1) + 나머지(5~13) = 6~14글자

    if(regExp.test(this.value)) {
        idMsg.classList.remove("colRed");
        checkObj.inputId = true;
    } else {
		idMsg.classList.add("colRed");
        checkObj.inputId = false;
    }
});

// 비밀번호 검사
const inputPw = document.getElementById("inputPw");
const inputPw2 = document.getElementById("inputPw2")

inputPw2.addEventListener("keyup", function() {
    if(inputPw.value.length == 0) {
        this.value = "";
        alert("비밀번호를 먼저 입력해주세요.");
        inputPw.focus();
        checkObj.inputPw = false;
    }
});

const pwMsg = document.getElementById("pwMsg");

inputPw.addEventListener("keyup", function() {
    if( (inputPw.value == inputPw2.value) && inputPw.value.length != 0 ) {
        pwMsg.innerText = "비밀번호 일치";
        pwMsg.classList.add("confirm");
        pwMsg.classList.remove("colRed");
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMsg.innerText = "비밀번호 불일치";
        pwMsg.classList.add("colRed");
        pwMsg.classList.remove("confirm");
        checkObj.inputPw = false;
        checkObj.inputPw2 = false;
    }
});

inputPw2.addEventListener("keyup", function() {
    if( (inputPw.value == inputPw2.value) && inputPw.value.length != 0 ) {
        pwMsg.innerText = "비밀번호 일치";
        pwMsg.classList.add("confirm");
        pwMsg.classList.remove("colRed");
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMsg.innerText = "비밀번호 불일치";
        pwMsg.classList.add("colRed");
        pwMsg.classList.remove("confirm");
        checkObj.inputPw = false;
        checkObj.inputPw2 = false;
    }
});

// 이름 유효성 검사
const inputNm = document.getElementById("inputNm");

inputNm.addEventListener("change", function() {
    const regExp = /^[가-힣a-zA-Z]/;

    const nmMsg = document.getElementById("nmMsg");

    if(regExp.test(this.value)) {
        nmMsg.innerText = "정상입력";
        nmMsg.classList.add("confirm");
        nmMsg.classList.remove("colRed");
        checkObj.inputNm = true;
    } else {
        nmMsg.innerText = "한글, 영문만 입력 가능합니다.";
        nmMsg.classList.add("colRed");
        nmMsg.classList.remove("confirm");
        checkObj.inputNm = false;
    }
});