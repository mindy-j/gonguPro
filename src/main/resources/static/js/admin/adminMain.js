//삭제 버튼
$('.remove-btn').on('click',function (){
    let userNumber = $(this).data('number');
    // AJAX 요청으로 데이터 삭제
    $.ajax({
        type: 'get',
        url: '/admin/removeUser?userNumber=' + userNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

