//승인 버튼
$('.approval-btn').on('click',function (){
    let applyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/approvalMento?applyNumber=' + applyNumber,
        success: function () {
            alert('성공적으로 승인했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
// 거부 refusal-btn
$('.refusal-btn').on('click',function (){
    let applyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/refusalMento?applyNumber=' + applyNumber,
        success: function () {
            alert('성공적으로 거부했습니다.');
            location.reload();
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});


//승인 버튼
$('.approval-detail-btn').on('click',function (){
    let applyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/approvalMento?applyNumber=' + applyNumber,
        success: function () {
            alert('성공적으로 승인했습니다.');
            location.replace('/admin/application');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});
// 거부 refusal-btn
$('.refusal-detail-btn').on('click',function (){
    let applyNumber = $(this).data('number');
    // AJAX 요청으로 데이터 수정
    $.ajax({
        type: 'get',
        url: '/admin/refusalMento?applyNumber=' + applyNumber,
        success: function () {
            alert('성공적으로 거부했습니다.');
            location.replace('/admin/application');
        },
        error: function (a,b,c) {
            console.error(c);
        }
    });
});



//이미지 띄우기 처리
displayAjax();

function displayAjax(){
    let applyNumber = $('.apply-num').val();

    $.ajax({
        url : '/files/imgList',
        type : 'get',
        data : {applyNumber : applyNumber},
        success : function (fileList) {

            let text = '';

            fileList.forEach(file => {
                console.log(file);
                let fileName = file.fileUploadPath + '/' + file.fileUuid + '_' + file.fileName;

                text += `<div className="file" style="margin: 0 3px; cursor:pointer;" onclick="detailFile()"><img src="/files/display?fileName=${fileName}" data-number=${file.fileNumber}
                          width="220px" height="200px"/></div>`;

            });

            $('.file-box').html(text);
        }
    });
}

function detailFile(){
    let clickedImage = $(event.target);
    let fileName = clickedImage.attr('src');
    let fileNumber = clickedImage.data('number');

    $('.modal').html(`
        <span class="close">&times;</span>
        <img src="${fileName}" data-number="${fileNumber}" width="80%" height="850px" style="margin-left: 180px"/>`);
    $('.modal').css('display', 'block');
};

// 모달 닫기
$('.right-container').on('click', '.close', function() {
    $('.modal').css('display', 'none');
});

$('.back-btn').on('click', function (){
    window.history.back();
});