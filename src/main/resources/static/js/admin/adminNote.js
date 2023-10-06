// $('.recipient').on('change', function() {
//     let userId = $(this).val();
//
//     console.log(userId);
//     if(userId == ""){
//         $('.idYes').css('display','none');
//         $('.idNo').css('display','none');
//     }else {
//         $.ajax({
//             url: "/files/checkId",
//             type: "get",
//             data: { "userId": userId },
//             success: function (result) {
//                 console.log(result);
//                 if(result == 0){
//                     $('.idNo').css('display','block');
//                     $('.idYes').css('display','none');
//                 }else {
//                     $('.idYes').css('display','block');
//                     $('.idNo').css('display','none');
//                 }
//             },
//             error: function (a,b,c) {
//                 console.error(c);
//             }
//         });
//     }
// });

$('.inputId').on('change', function() {
    let userId = $(this).val();

    console.log(userId);
    if(userId == ""){
        $('.idYes').css('display','none');
        $('.idNo').css('display','none');
    } else {
        fetch("/files/checkId?userId=" + userId, {
            method: "GET",
        })
            .then(response => response.json())
            .then(result => {
                console.log(result);
                if(result == 0) {
                    $('.idNo').css('display','block');
                    $('.idYes').css('display','none');
                    $(".send-btn").prop("type", "button");
                } else {
                    $('.idYes').css('display','block');
                    $('.idNo').css('display','none');
                    $(".send-btn").prop("type", "submit");
                }
            })
            .catch(error => {
                console.error(error);
            });
    }
});
$('#summernote').summernote({
    placeholder: '쪽지 내용을 입력해주세요',
    tabsize: 2,
    height: 400,
    toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['view', ['help']]
    ]
});

$(".send-btn").on("click", function (){
    if($('.idNo').css("display")==="block"){
        alert("존재하지 않는 아이디입니다.\n다시 입력해주세요");
    }
});