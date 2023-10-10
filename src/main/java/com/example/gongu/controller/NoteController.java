package com.example.gongu.controller;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NotePageVo;
import com.example.gongu.domain.vo.NoteVo;
import com.example.gongu.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note/*")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/writeNote")
    public String writeNotePage() {
        return "note/noteWrite";
    }

    @PostMapping("/writeNoteOk")
    public RedirectView sendNote(NoteVo noteVo, HttpServletRequest req) {
        Long senderNumber = (Long)req.getSession().getAttribute("userNumber");
        noteVo.setSenderNumber(senderNumber);
        noteService.registNote(noteVo);
        return new RedirectView("/note/sendList");
    }

    @GetMapping("/sendList")
    public String showSendListPage(NoteCriteria noteCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Long senderNumber = (Long)session.getAttribute("userNumber");
        noteCriteria.setSenderNumber(senderNumber);
        model.addAttribute("sendNote", noteService.findSendAll(noteCriteria));
        model.addAttribute("pageInfo", new NotePageVo(noteService.getSendTotal(senderNumber), noteCriteria));
        return "note/sendNote";
    }

    @PostMapping("/sendRemove")
    public RedirectView removeSendNote(NoteVo noteVo, HttpServletRequest req) {
        Long senderNumber = (Long)req.getSession().getAttribute("userNumber");
        noteVo.setSenderNumber(senderNumber);
        noteService.modifySendLevel(noteVo);
        return new RedirectView("/note/sendList");
    }

    @GetMapping("/sendNote")
    public String showSendNote(Long noteNumber, Model model) {
        model.addAttribute("sendNoteDetail", noteService.findSendNote(noteNumber));
        return "note/sendNoteDetail";
    }

    @GetMapping("/receiveList")
    public String showReceiveListPage(NoteCriteria noteCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Long recieverNumber = (Long)session.getAttribute("userNumber");
        noteCriteria.setRecieverNumber(recieverNumber);
        model.addAttribute("receiveNote", noteService.findReceiveAll(noteCriteria));
        model.addAttribute("pageInfo", new NotePageVo(noteService.getReceiveTotal(recieverNumber), noteCriteria));
        return "note/receiveNote";
    }

    @PostMapping("/receiveRemove")
    public RedirectView removeReceiveNote(NoteVo noteVo, HttpServletRequest req) {
        Long recieverNumber = (Long)req.getSession().getAttribute("userNumber");
        noteVo.setRecieverNumber(recieverNumber);
        noteService.modifyReceiveLevel(noteVo);
        return new RedirectView("/note/receiveList");
    }

    @GetMapping("/receiveNote")
    public String showReceiveNote(Long noteNumber, Model model) {
        model.addAttribute("receiveNoteDetail", noteService.findReceiveNote(noteNumber));
        return "note/receiveNoteDetail";
    }
}
