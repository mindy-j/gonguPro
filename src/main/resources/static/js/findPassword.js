const idInput = document.getElementById("userId");
const phoneInput = document.getElementById("userPhone");
const cerNumberInput = document.getElementById("cerNumber");

const idBtn = document.querySelector(".id-btn");
const btn = document.getElementById("btn");
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
    })
        .then(function (response){
        if(response.ok){
            alert("인증번호 발송되었습니다.");
            return response.text();
        }else{
            alert("일치하는 정보 없음");
            return new Error("번호 불일치");
        }
    })
        .catch(function (error){
            console.log("오류", error);
        });
        intArea.style.display = "block";

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
        contentType : 'application/json; charset=utf-8',
        success: function (result){
            //여기 result에서 오류
            console.log(result);

            if(result == '비밀번호를 찾을 수 없습니다.'){
                alert(result);
                return;
            }else if(result =='인증번호가 일지하지 않습니다.'){
                alert(result);
                return;
            }
            $(modal).css("display",'flex');
            $('#foundPassword').text(result);

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
    }
    countTime--;
};

$('.certificationIssue').on("click",function(){
    $.time(179);
});

// //배경화면을 누르면 화면 이동인데 다른것도 누르면 이동이 됨 - 수정해야해
// document.body.addEventListener("click", function (event){
//
//     if(event.target.tagName==="input"){
//         return;
//     }
//     window.location.href="/user/index";
// });


//비밀번호 확인후 로그인 하러 가기버튼
btn.addEventListener("click",function (){
    window.location.href="/user/login";
});


