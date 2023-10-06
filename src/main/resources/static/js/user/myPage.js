//삭제 버튼
$('.delete-btn').on('click',function (){
    let userNumber = $(this).data('number');
    // AJAX 요청으로 데이터 삭제
    $.ajax({
        type: 'get',
        url: '/user/removeUser?userNumber=' + userNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.replace("/user/index");
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

$('.userPhone').on('change', function() {
    let userPhone = $(this).val();
    console.log(userPhone)
    if(userPhone == ""){
        $('.check-phone').css('display','none');
    }else {
        $.ajax({
            url: "/files/checkPhone",
            type: "get",
            data: { "userPhone": userPhone },
            success: function (result) {
                if(result == 0){
                    $('.check-phone').css('display','none');
                    $(".update-btn").prop("type", "submit");
                }else {
                    $('.check-phone').css('display','inline');
                    $(".update-btn").prop("type", "button");
                }
            },
            error: function (a,b,c) {
                console.error(c);
            }
        });
    }
});

$('.userEmail').on('change', function() {
    let userEmail = $(this).val();
    console.log(userEmail)
    if(userEmail == ""){
        $('.check-email').css('display','none');
    }else {
        $.ajax({
            url: "/files/checkEmail",
            type: "post",
            data: { "userEmail": userEmail },
            success: function (result) {
                if(result == 0){
                    $('.check-email').css('display','none');
                    $(".update-btn").prop("type", "submit");
                }else {
                    $('.check-email').css('display','inline');
                    $(".update-btn").prop("type", "button");
                }
            },
            error: function (a,b,c) {
                console.error(c);
            }
        });
    }
});

$(".update-btn").on("click", function (){

    if($(".check-phone").css("display")==="inline"){
        alert("중복된 핸드폰번호입니다.\n다시 입력해주세요");
    }
    if($(".check-email").css("display")==="inline"){
        alert("중복된 이메일입니다.\n다시 입력해주세요");
    }
});


