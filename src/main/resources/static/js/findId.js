const phoneInput = document.getElementById("userPhone");
const cerNumberInput = document.getElementById("cerNumber");
const idBtn = document.querySelector(".id-btn");
const intArea = document.querySelector(".int-area.none");

// 인증번호 발송 버튼 클릭 이벤트 처리
idBtn.addEventListener("click", function () {
    // 인증번호 발송 로직을 여기에 추가하면 됩니다.
    var userPhone = phoneInput.value; //phoneInput의 value 속성을 가져옴

    //input칸의 번호가 들어있는지 - 빈칸이면 알림창: 번호를 입력해주세요
    //input 그 번호가 데이터베이스에 있는지 : 있으면 sms컨트롤러에 있는 send 보내어 인증번호 발송
    //없으면 알람창: 정보가 없습니다.
    //인증번호를 입력하는input에 값이랑 전송한 문자가 같으면 아이디를 알려준다
    // 인증번호 입력란을 보이도록 설정하고 none 클래스 제거

    if(userPhone.trim() === ""){
        alert("번호를 입력해주세요");
        return
    }

    fetch("/user/verify-phone",{
        method :"POST",
        headers:{
            "Content-Type": "application/json",
        },
        body: JSON.stringify({userPhone: userPhone}),
    })
        .then(function (response){
            if(response.ok){
                //휴대폰 번호가 데이터베이스에 있는 경우
                //console.log("아이디 있음")
                return response.text();
            } else{
                //없는경우
                alert("일치하는 번호 없음");
                throw  new Error("번호 불일치");
            }
        })
        .then(function (data){
            //서버로부터의 응답처리. 인증번호 발송 등 추가 작업 수행
        })
        .catch(function (error){
            console.log("오류", error);
        });


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
const btnModal = document.getElementById("btn-modal");
const cerNumber = document.getElementById("cerNumber");
btnModal.addEventListener("click", e => {
    if(cerNumber.value=='1234'){
        modal.style.display = "flex";
    }

});

const closeBtn = modal.querySelector(".close-area");
closeBtn.addEventListener("click", e => {
    modal.style.display = "none";
});

modal.addEventListener("click", e => {
    const evTarget = e.target;
    if(evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none";
    }
});