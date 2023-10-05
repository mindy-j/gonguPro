package com.example.gongu.controller;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NotePageVo;
import com.example.gongu.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note/*")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/sendList")
    public String showSendListPage(NoteCriteria noteCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Long senderNumber = (Long)session.getAttribute("userNumber");
        noteCriteria.setSenderNumber(senderNumber);
        model.addAttribute("sendNote", noteService.findSendAll(noteCriteria));
        model.addAttribute("pageInfo", new NotePageVo(noteService.getSendTotal(senderNumber), noteCriteria));
        return "note/sendNote";
    }

    @GetMapping("/sendRemove")
    public void removeSendNote(NoteCriteria noteCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Long senderNumber = (Long)session.getAttribute("userNumber");
        noteService.modifySendLevel(senderNumber);
        showSendListPage(noteCriteria, model, req);
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

    @GetMapping("/receiveRemove")
    public void removeReceiveNote(NoteCriteria noteCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Long recieverNumber = (Long)session.getAttribute("userNumber");
        noteService.modifyReceiveLevel(recieverNumber);
        showReceiveListPage(noteCriteria, model, req);
    }
}
