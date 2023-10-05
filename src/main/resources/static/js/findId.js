const phoneInput = document.getElementById("userPhone");
const cerNumberInput = document.getElementById("cerNumber");
const idBtn = document.querySelector(".id-btn");
const intArea = document.querySelector(".int-area.none");
const verifyBtn = document.getElementById("verifyBtn");
const modal = document.getElementById("modal");

// 인증번호 발송 버튼 클릭 이벤트 처리
idBtn.addEventListener("click", function () {
    // 인증번호 발송 로직을 여기에 추가하면 됩니다.
    var userPhone = phoneInput.value.trim(); //phoneInput의 value 속성을 가져옴

    if(userPhone === ""){
        alert("번호를 입력해주세요");
        return
    }

    fetch("/sms/v1/send",{
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
                alert("인증번호가 발송되었습니다.");

                return response.text();
            } else{
                //없는경우
                alert("일치하는 번호 없음");
                throw  new Error("번호 불일치");
            }
        })
        .catch(function (error){
            console.log("오류", error);
        });

    intArea.style.display = "block";

});

//인증번호 확인 버튼 클릭 이벤트처리
$(verifyBtn).on('click', function (){
    const code = cerNumberInput.value.trim();
    const  userPhone = phoneInput.value.trim();

    if(code ===""){
        alert("인증번호를 입력해 주세요");
        return;
    }

    $.ajax({
        url : '/sms/v1/check',
        type : 'post',
        data : JSON.stringify({userPhone: userPhone,checkNumber: code}),
        contentType : 'application/json; charset=utf-8',
        success : function (result){
            console.log(result);

            if(result == '아이디를 찾을 수 없습니다.'){
                alert(result);
                return;
            }else if(result == '인증번호가 일치하지 않습니다.'){
                alert(result);
                return;
            }

            $(modal).css("display",'flex');
            $('#userIdSpan').text(result);

        },
        error: function (a,b,c){
            console.error(c);
        }
    });
});

//모달
const closeModal = document.querySelector(".close-area");
closeModal.addEventListener("click", function (){
    modal.style.display="none";
});

modal.addEventListener("click",function (e){
    if(e.target.classList.contains("modal-overlay")){
        modal.style.display="none";
    }
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
        return;
    }
    countTime--;
};

$('.certificationIssue').on("click",function(){
    $.time(179);
});

//모달창 스크립트
const btnModal = document.getElementById("btn-modal");
const cerNumber = document.getElementById("cerNumber");
btnModal.addEventListener("click", function (e) {
    if (cerNumber.value == "1234") {
        modal.style.display = "flex";
    }
});

const closeBtn = modal.querySelector(".close-area");
closeBtn.addEventListener("click", function (e) {
    modal.style.display = "none";
});

modal.addEventListener("click", function (e) {
    const evTarget = e.target;
    if (evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none";
    }
});