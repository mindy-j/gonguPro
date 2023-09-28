//삭제 버튼
$('.remove-btn').on('click',function (){
    let studyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 삭제
    $.ajax({
        type: 'get',
        url: '/admin/removeStudy?studyNumber=' + studyNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
//삭제 버튼
$('.rm').on('click',function (){
    let studyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 삭제
    $.ajax({
        type: 'get',
        url: '/admin/removeStudy?studyNumber=' + studyNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.replace('/admin/board');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

