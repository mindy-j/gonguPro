
// 삭제 refusal-btn : 디테일 페이지에서 삭제 한 경우 classPlan으로 리다이렉트
$('.refusal-btn').on('click',function (){
    let classNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/removeClass?classNumber=' + classNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.replace('/admin/classPlan');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
// 삭제 classPlan에서 삭제한 경우 페이지리로드
$('.remove-btn').on('click',function (){
    let classNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/removeClass?classNumber=' + classNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
$('.back-btn').on('click', function (){
    window.history.back();
});
