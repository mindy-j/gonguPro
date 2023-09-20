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
password = document.getElementsByClassName('pw');

function checkPasswordMatch() {
    const passwordInput = document.getElementById("pw");
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