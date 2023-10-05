const idInput = document.getElementById("userId");
const phoneInput = document.getElementById("userPhone");
const cerNumberInput = document.getElementById("cerNumber");

const idBtn = document.querySelector(".id-btn");
const intArea = document.querySelector(".int-area.none");
const verifyBtn = document.getElementById("verifyBtn");
const modal = document.getElementById("modal");

// 인증번호 발송 버튼 클릭 이벤트 처리
idBtn.addEventListener("click", function () {

    var userId = idInput.value.trim();
    var userPhone = phoneInput.value.trim();

    if(userId ===""){
        alert("아이디를 입력해주세요");
        return;
    }
    if(userPhone === ""){
        alert("번호를 입력해주세요");
        return;
    }

    fetch("/sms/v1/send",{
        method : "POST",
        headers : {
            "Content-Type": "application/json",
        },
        body : JSON.stringify({userPhone:userPhone}),
    }).then(function (response){
        if(response.ok){
            alert("인증번호 발송되었습니다.");
            return response.text();
        }else{
            alert("일치하는 번호 없음");
            return new Error("번호 불일치");
        }
    })
        .catch(function (error){
            console.log("오류", error);
        });
        intArea.style.display = "block";

    // // 인증번호 입력란을 보이도록 설정하고 none 클래스 제거
    // cerNumberInput.style.display = "block";
    // intArea.classList.remove("none");
});
//인증번호 확인 버튼 클립 이벤트 처리
$(verifyBtn).on('click',function (){
    const code = cerNumberInput.value.trim();
    const userId = idInput.value.trim();
    const userPhone = phoneInput.value.trim();

    if(code ===""){
        alert("인증번호를 입력해 주세요");
        return;
    }
    $.ajax({
        url: '/sms/v1/check-id-phone',
        type: 'post',
        data: JSON.stringify({userId:userId, userPhone: userPhone,checkNumber: code}),
        success: function (result){
            console.log(reslut);
            if(result == '비밀번호를 찾을 수 없습니다.'){
                alert(result);
                return;
            }else if(result =='인증번호가 일지하지 않습니다.'){
                alert(result);
                return;
            }


        }



    })


})




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