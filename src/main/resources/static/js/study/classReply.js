import * as reply from '../module/classReplyModule.js';
//모듈 경로는 상대경로로 접근해야한다.
// 파일명 뒤에 반드시 확장자를 작성한다!!!!!!!!!
let classNumber = $('.class-num').val();

//리플 작성 완료 처리
$('.btn-reply').on('click', function () {
    let content = $('#reply-content').val();

    // if(!(content && loginNumber)){
    //     alert('로그인을 하세요!');
    //     return;
    // }
    let replyObj = {
        classReplyContent : content,
        classNumber : classNumber,
        userNumber : loginNumber
    };

    reply.add(replyObj, function(){
        reply.getListPage({classNumber:classNumber, page : page}, appendReply);
    });

    $('#reply-content').val('');
});



// reply.getList(boardNumber, showReply);
let page = 1;

reply.getListPage({classNumber:classNumber, page : page}, appendReply);


function appendReply(map){
    console.log(map);

    let text = '';

    map.replyList.forEach( r => {
        text += `
            <div class="reply" data-num="${r.classReplyNumber}">
              <div class="reply-box">
                <div class="reply-box__writer">${r.userNickname}</div>
                <div class="reply-box__content">${r.classReplyContent}</div>
              </div>
              
              <div class="reply-time">
                ${reply.timeForToday(r.classReplyUpdateDate) + (r.classReplyRegisterDate == r.classReplyUpdateDate ? ' 작성' : ' 수정')}
              </div>      
              
              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').append(text);
}


//무한 스크롤 페이징
// $(window).on('scroll', function (){
//
//     // 현재 브라우저의 스크롤 위치를 의미함
//     console.log(`scrollTop : ${ $(window).scrollTop() }`);
//     // 문서 전체의 높이를 구함
//     console.log(`document : ${ $(document).height() }`);
//     //브라우저 화면의 높이를 구함
//     console.log(`window : ${ $(window).height() }`);
//
//     if(Math.round($(window).scrollTop()) == $(document).height() - $(window).height()){
//         console.log(++page);
//         reply.getListPage({studyNumber:studyNumber, page : page}, appendReply);
//     }
//
// });






/**
 * 리플 목록을 만들어주는 콜백 함수
 *
 * @param result 리플 정보를 가진 배열객체
 */
function showReply(result){
    console.log(result);

    let text = '';

    result.forEach( r => {
        text += `
            <div class="reply" data-num="${r.classReplyNumber}">
              <div class="reply-box">
                <div class="reply-box__writer">${r.userId}</div>
                <div class="reply-box__content">${r.classReplyContent}</div>
              </div>
              
              <div class="reply-time">
                ${reply.timeForToday(r.classReplyUpdateDate) + (r.classReplyRegisterDate == r.classReplyUpdateDate ? ' 작성' : ' 수정')}
              </div>      
              
              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').html(text);
}


$('.reply-list-wrap').on('click', '.reply-btns', function () {
    let $replyBtnBox = $(this).closest('.reply-btn-box').find('.reply-btns__box');

    $('.reply-btns__box').addClass('none');

    $replyBtnBox.toggleClass('none');

});

$('body').click(function (e) {
    if ($(e.target).hasClass('reply-btns')) {
        //console.log('aa');
        return;
    }
    if (!$('.reply-btns__box').has(e.target).length) {
        $('.reply-btns__box').addClass('none');
    }
});

// 뒤로가기 버튼
$('.btn-back').on('click', function (){
    window.location.href = '/class/list';
})

//삭제 버튼
$('.btn-remove').on('click', function (){
    let classNumber = $(this).data('number');
    window.location.href = '/class/delete?classNumber=' + classNumber; //remove? delete?

    let f = document.createElement('form');
    f.setAttribute("method", 'post');
    f.setAttribute('action', '/class/delete');

    let input = document.createElement('input');
    input.setAttribute('name', 'classNumber');
    input.setAttribute('value', classNumber);
    input.setAttribute('type', 'hidden');

    f.appendChild(input);

    document.body.appendChild(f);
    f.submit();
});

// 수정 버튼
$('.btn-modify').on('click', function (){
    let classNumber = $(this).data('number');
    window.location.href = '/class/modify?classNumber=' + classNumber;
});

// 리플 작성 완료 처리
$('.btn-reply').on('click', function (){

});

// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    $('.reply-btns__box').addClass('none');

    let classReplyNumber = $(this).closest('.reply').data('num');

    reply.remove(classReplyNumber, function (){
        reply.getListPage({classNumber:classNumber, page : page}, appendReply);
    });
});
/////////여기까지
// 리플 수정 버튼 처리
$('.reply-list-wrap').on('click', '.reply-modify-btn', function () {
    let $content = $(this).closest('.reply').find('.reply-box__content');
    $content.replaceWith(`
  <div class='modify-box'>
    <textarea class='modify-content'>${$content.text()}</textarea>
    <button type='button' class='modify-content-btn'>수정 완료</button>
  </div>
  `);
    $('.reply-btns__box').addClass('none');
});

// 리플 수정 완료 처리
$('.reply-list-wrap').on('click', '.modify-content-btn', function () {
    console.log('modify!!!');
    let classReplyNumber = $(this).closest('.reply').data('num');
    let classReplyContent = $(this).closest('.modify-box').find('.modify-content').val();
    // console.log(replyContent);
    let classReplyObj = {classReplyContent : classReplyContent};
    console.log('modify!!!2');

    reply.modify(classReplyNumber, classReplyObj, function (){
        reply.getListPage({classNumber:classNumber, page : page}, appendReply);
    });
    console.log('modify!!!3');
});


//이미지 띄우기 처리
// displayAjax();
//
// function displayAjax(){
//     let studyNumber = $('.study-num').val();
//
//     $.ajax({
//         url : '/files/imgList',
//         type : 'get',
//         data : {studyNumber : studyNumber},
//         success : function (fileList) {
//             let text = '';
//
//             fileList.forEach(file => {
//                 // console.log(file);
//                 let fileName = file.fileUploadPath + '/' + file.fileUuid + '_' + file.fileName;
//
//                 text += `<img src="/files/display?fileName=${fileName}" data-number=${file.fileNumber} />`;
//
//             });
//
//             $('.post-images').html(text);
//         }
//     });
// }
//











