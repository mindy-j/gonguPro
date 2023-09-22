package com.example.gongu.controller;

import com.example.gongu.domain.dto.StudyReplyDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.PageVo;
import com.example.gongu.domain.vo.StudyReplyVo;
import com.example.gongu.service.StudyReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/replies")
public class StudyReplyController {
    private final StudyReplyService studyReplyService;

    //    Rest컨트롤러에서 json형식의 데이터 받을 준비를 한다.
//    value : url경로 (다른 옵션을 사용하지 않는다면 value를 생략하고 값만 넣으면 된다.)
//    consumes : 우리가 받는 데이터의 형식
//    produces : 우리가 보내는 데이터의 형식
//    @PostMapping(value = "/write", consumes = "application/json", produces = "text/plain; charset=utf-8")
//    public ResponseEntity<String> replyAdd(@RequestBody ReplyDto replyDto) throws UnsupportedEncodingException {
//        replyService.register(replyDto);
//        return new ResponseEntity<>(new String("작성 성공!".getBytes(), "utf-8"), HttpStatus.OK);
//    }

    @PostMapping("")
    public String replyAdd(@RequestBody StudyReplyDto studyReplyDto){
//        RequestBody는 json형식의 데이터를 자동으로 객체 필드에 매핑시켜준다.

        studyReplyService.register(studyReplyDto);
        return "작성 성공!";
    }

    @GetMapping("/list/{studyNumber}")
    public List<StudyReplyVo> showList(@PathVariable("studyNumber") Long studyNumber){
//        url로 데이터를 넘겨받아 조회한다.
//        url경로상의 데이터를 받기 위해서는 @PathVariable 어노테이션을 사용한다.
        return studyReplyService.findList(studyNumber);
    }

    //    수정 처리를 위한 method
//    1. Patch : 일부 수정
//    2. Put : 전체 수정
//    위와 가타이 나누어 사용하지만 크게 구분하지 않는 경우도 있다.
    @PatchMapping("/{studyReplyNumber}")
    public void modify(@PathVariable("studyReplyNumber")Long studyReplyNumber,
                       @RequestBody StudyReplyDto studyReplyDto){

        studyReplyDto.setStudyReplyNumber(studyReplyNumber);

        studyReplyService.modify(studyReplyDto);
    }

//    @PatchMapping(value = {"/{replyNumber}", "/{replyNumber}/{replyContent}"})
//    public void modify(@PathVariable("replyNumber")Long replyNumber,
//                       @PathVariable(value = "replyContent", required = false) String replyContent){
//
//        ReplyDto replyDto = new ReplyDto();
//        replyDto.setReplyNumber(replyNumber);
//        replyDto.setReplyContent(replyContent);
//
//        replyService.modify(replyDto);
//    }

    @DeleteMapping("/{studyReplyNumber}")
    public void replyRemove(@PathVariable("studyReplyNumber") Long studyReplyNumber){
        studyReplyService.remove(studyReplyNumber);
    }

    @GetMapping("/list/{studyNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("studyNumber")Long studyNumber, @PathVariable("page")Integer page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);

        PageVo pageVo = new PageVo(studyReplyService.getTotal(studyNumber), criteria);
        List<StudyReplyVo> studyReplyVoList = studyReplyService.findListPage(criteria, studyNumber);

        Map<String, Object> replyMap = new HashMap<>();
        replyMap.put("pageVo", pageVo);
        replyMap.put("replyList", studyReplyVoList);

        return replyMap;
    }

}
