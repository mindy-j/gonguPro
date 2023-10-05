// let show = $('.show-btn');
// let close = $('.close-x');
// let note = $('.form-note');
// let nomarl=$('.member-container');
// let right = $('.right-container');
//
// // ===================
//
// show.on('click', function () {
//     note.css('display', 'block');
//     nomarl.css('opacity', '0.3');
//     right.css('background-color', '#f0f0f0');
//     note.css('top', '-50%'); // 초기 위치를 -50%로 설정
//     note.animate({
//         top: '50%',
//         opacity: 1
//     }, 300, 'linear', function () {
//         note.addClass('active');
//     });
// });
//
// close.on('click', function () {
//     note.animate({
//         top: '-50%',
//         opacity: 0
//     }, 300, 'linear', function () {
//         note.css('display', 'none');
//         nomarl.css('opacity', '1');
//         right.css('background-color', 'white');
//         note.removeClass('active');
//     });
// });

// 거부 refusal-btn
$('.remove-btn').on('click',function (){
    let noteNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/receiveNoteModify?noteNumber=' + noteNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

$('.refusal-btn').on('click',function (){
    let noteNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/receiveNoteModify?noteNumber=' + noteNumber,
        success: function () {
            alert('성공적으로 삭제했습니다.');
            location.replace('/admin/receivedNote');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});

$('.back-btn').on('click', function (){
    window.history.back();
});