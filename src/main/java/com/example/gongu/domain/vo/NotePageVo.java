package com.example.gongu.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NotePageVo {
    //    페이지 세트당 표시될 수
    private int pageCount;
    //    페이지 세트의 시작 숫자
    private int startPage;
    //    페이지 세트의 마지막 숫자
    private int endPage;
    //    실제 가장 마지막 페이지
    private int realEnd;
    //    이전 버튼 표시 여부
    private boolean prev;
    //    다음 버튼 표시 여부
    private boolean next;
    //    전체 게시글 수
    private int total;
    //    화면에서 전달받은 page, amount를 저장하는 객체
    private NoteCriteria noteCriteria;

    public NotePageVo() {}

    public NotePageVo(int total, NoteCriteria noteCriteria) {
        this(5, total, noteCriteria);
    }

    public NotePageVo(int pageCount, int total, NoteCriteria noteCriteria) {
        this.pageCount = pageCount;
        this.total = total;
        this.noteCriteria = noteCriteria;

//        현재 페이지를 기준으로 세트의 마지막 번호를 구한다.
//        ceil() : 올림 처리
        this.endPage = (int)(Math.ceil(noteCriteria.getPage() / (double)pageCount) * pageCount);
        this.startPage = endPage - pageCount + 1;


//        게시글 전체 수로 실제 마지막 페이지를 구한다.
        this.realEnd = (int)Math.ceil((double)total/noteCriteria.getAmount());

//        세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage){
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
