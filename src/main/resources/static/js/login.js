// let id = $('#id');
// let pw = $('#pw');
// let btn = $('#btn');
//
// $(btn).on('click',function() {
//
//     if($(id).val() ==""){
//         $(id).next('label').addClass('warning');
//         setTimeout(function(){
//             $('label').removeClass('warning');
//         },150);
//     }
//     else if($(pw).val() ==""){
//         $(pw).next('label').addClass('warning');
//         setTimeout(function(){
//             $('label').removeClass('warning');
//         },150);
//     }
// });
//
$(document).ready(function () {
    var btn = document.getElementById("btn");
    var id = document.getElementById("id");
    var pw = document.getElementById("pw");
  //  var errorDiv = document.getElementById("error-message");

    $(btn).on('click', function () {
        // 추가부분 : userId와 userPassword가 일치하지 않을 때 메세지 표시

            var userId = id.value;
            var userPassword = pw.value;

            if (userId === "" || userPassword === "") {
                alert("아이디와 비밀번호를 모두 입력하세요");
                return false;
            }

            $.ajax({
                url: '/user/login',
                type: 'post',
                data: JSON.stringify({userId: userId, userPassword: userPassword}),
                contentType: 'application/json; charset=utf-8',
                success: function (reslut) {
                    console.log(reslut)

                    if (reslut === '아이디를 찾을 수 없습니다') {
                        $("#error-message").text("아이디를 찾을 수 없습니다").css("color", "red");
                        return;
                    }
                    window.location.href = '/index.html';
                },
                error: function (a, b, c) {
                    console.error(c)
                }
            });


});
});


