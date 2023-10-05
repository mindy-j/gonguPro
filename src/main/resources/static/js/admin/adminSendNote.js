// 거부 refusal-btn
$('.remove-btn').on('click',function (){
    let noteNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/sendNoteModify?noteNumber=' + noteNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
// 거부 refusal-btn
$('.refusal-btn').on('click',function (){
    let noteNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/sendNoteModify?noteNumber=' + noteNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.replace('/admin/sendNote');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

$('.back-btn').on('click', function (){
    window.history.back();
});