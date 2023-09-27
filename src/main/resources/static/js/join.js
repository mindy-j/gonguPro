// '출생 연도' 셀렉트 박스 option 목록 동적 생성
const birthYearEl = document.querySelector('#birth-year')
// option 목록 생성 여부 확인
isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function () {
    // year 목록 생성되지 않았을 때 (최초 클릭 시)
    if(!isYearOptionExisted) {
        isYearOptionExisted = true
        for(var i = 1940; i <= 2022; i++) {
            // option element 생성
            const YearOption = document.createElement('option')
            YearOption.setAttribute('value', i)
            YearOption.innerText = i
            // birthYearEl의 자식 요소로 추가
            this.appendChild(YearOption);
        }
    }
});


// '출생 연도' 셀렉트 박스 option 목록 동적 생성
const birthMonthEl = document.querySelector('#birth-month')
// option 목록 생성 여부 확인
isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function () {
    // year 목록 생성되지 않았을 때 (최초 클릭 시)
    if(!isMonthOptionExisted) {
        isMonthOptionExisted = true
        for(var i = 12; i >= 1; i--) {
            // option element 생성
            const MonthOption = document.createElement('option')
            MonthOption.setAttribute('value', i)
            MonthOption.innerText = i
            // birthYearEl의 자식 요소로 추가
            this.appendChild(MonthOption);
        }
    }
});

// '출생 연도' 셀렉트 박스 option 목록 동적 생성
const birthDayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인
isDayOptionExisted = false;
birthDayEl.addEventListener('focus', function () {
    // year 목록 생성되지 않았을 때 (최초 클릭 시)
    if(!isDayOptionExisted) {
        isDayOptionExisted = true
        for(var i = 31; i >= 1; i--) {
            // option element 생성
            const DayOption = document.createElement('option')
            DayOption.setAttribute('value', i)
            DayOption.innerText = i
            // birthYearEl의 자식 요소로 추가
            this.appendChild(DayOption);
        }
    }
});


confirmPasswordOk = document.getElementsByClassName('confirm-password-ok');
confirmPasswordNo = document.getElementsByClassName('confirm-password-no');
confirmPassword = document.getElementsByClassName('confirm-password')
password = document.getElementsByClassName('userPassword');

function checkPasswordMatch() {
    const passwordInput = document.getElementById("userPassword");
    const confirmPasswordInput = document.getElementById("confirm-password");
    const confirmPasswordOk = document.querySelector(".confirm-password-ok");
    const confirmPasswordNo = document.querySelector(".confirm-password-no");

    if (passwordInput.value === confirmPasswordInput.value) {
        confirmPasswordOk.style.display = "inline-block";
        confirmPasswordNo.style.display = "none";
    } else {
        confirmPasswordOk.style.display = "none";
        confirmPasswordNo.style.display = "inline-block";
    }
}

// 비밀번호 확인 필드 값이 변경될 때마다 확인 함수 호출
const confirmPasswordInput = document.getElementById("confirm-password");
confirmPasswordInput.addEventListener("input", checkPasswordMatch);


//생년원일 처리
const birthYearSelect = document.getElementById('birth-year');
const birthMonthSelect = document.getElementById('birth-month');
const birthDaySelect = document.getElementById('birth-day');
const userBirthDayInput = document.getElementById('userBirth');

//선택한 값을 가져와서 userBirth input필드에 설정
function insertUserBirthday(){
    const selectedYear = birthYearSelect.value;
    let selectedMonth = birthMonthSelect.value;
    let selectedDay = birthDaySelect.value;

//월과 일이 한자릿수일 결루 앞에 0을 추가
    if(selectedMonth.length ===1){
        selectedMonth = '0' + selectedMonth;
    }
    if(selectedDay.length ===1){
        selectedDay ='0' + selectedDay;
    }

    userBirthDayInput.value = selectedYear + '-' + selectedMonth +'-'+selectedDay;

}

//값이 변경될때마다 insertUserBirthday()함수 호출
birthYearSelect.addEventListener('change', insertUserBirthday);
birthMonthSelect.addEventListener('change',insertUserBirthday);
birthDaySelect.addEventListener('change', insertUserBirthday);

//초기화시에도 실행
insertUserBirthday();


//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function (){
    //console.log("*****테스트*****");
    var userId = $('.id_input').val();
    var data = {userId : userId}

    $.ajax({
        type : "post",
        url :"/user/userIdChk",
        data : data,
        success : function (result){
            // console.log("성공여부 : " + result);
            if(result != 'fail'){
                $('.id_input_re_1').css("display","inline-block");
                $('.id_input_re_2').css("display","none");
            } else {
                $('.id_input_re_2').css("display","inline-block");
                $('.id_input_re_1').css("display","none");
            }
        }
    });
});


