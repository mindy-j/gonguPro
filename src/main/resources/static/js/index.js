let slideIndex = 0;

function moveSlides() {
    const slides = document.querySelector('.slides');
    slideIndex++;

    if (slideIndex >= 3) slideIndex = 0; // 3개의 이미지만 있으므로

    const transformValue = -slideIndex * 1900; // 이미지 width
    slides.style.transform = `translateX(${transformValue}px)`;
}

// 5초마다 이미지를 왼쪽으로 슬라이드
setInterval(moveSlides, 5000);

// 로그인 정보에 따라 header 변경
