let show = $('.show-btn');
let close = $('.close-x');
let note = $('.form-note');
let nomarl=$('.member-container');
let right = $('.right-container');

// ===================

show.on('click', function () {
    note.css('display', 'block');
    nomarl.css('opacity', '0.3');
    right.css('background-color', '#f0f0f0');
    note.css('top', '-50%'); // 초기 위치를 -50%로 설정
    note.animate({
        top: '50%',
        opacity: 1
    }, 300, 'linear', function () {
        note.addClass('active');
    });
});

close.on('click', function () {
    note.animate({
        top: '-50%',
        opacity: 0
    }, 300, 'linear', function () {
        note.css('display', 'none');
        nomarl.css('opacity', '1');
        right.css('background-color', 'white');
        note.removeClass('active');
    });
});