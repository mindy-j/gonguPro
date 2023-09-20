const phoneInput = document.getElementById("phone");
const cerNumberInput = document.getElementById("cerNumber");
const idBtn = document.querySelector(".id-btn");
const intArea = document.querySelector(".int-area.none");

// 인증번호 발송 버튼 클릭 이벤트 처리
idBtn.addEventListener("click", function () {
    // 인증번호 발송 로직을 여기에 추가하면 됩니다.

    // 인증번호 입력란을 보이도록 설정하고 none 클래스 제거
    cerNumberInput.style.display = "block";
    intArea.classList.remove("none");
});

let countTime = 0;
let intervalCall;

$.time = function(time){
    countTime = time;
    intervalCall = setInterval(alertFunc, 1000);
}

$.closeTime = function(){
    clearInterval(intervalCall);
}

function alertFunc() {
    let min = Math.floor(countTime/60);
    let sec = countTime - (60 * min);
    if(sec > 9){
        $('.certificationTime').text(min + ':' + sec + '');
    }else {
        $('.certificationTime').text(min + ':0' + sec + '');
    }
    if(countTime <= 0){
        clearInterval(intervalCall);
    }
    countTime--;
};

$('.certificationIssue').on("click",function(){
    $.time(179);
});

//모달창 스크립트
const modal = document.getElementById("modal");
const btnModal = document.getElementById("btn-modal")
const cerNumber = document.getElementById("cerNumber");
btnModal.addEventListener("click", e => {
    if(cerNumber.value=='1234'){
        modal.style.display = "flex";
    }

});

const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modal.style.display = "none";
});

modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none";
    }
});