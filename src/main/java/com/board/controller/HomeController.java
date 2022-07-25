package com.board.controller;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
@Controller
public class HomeController {


    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String Home(@ModelAttribute("params") BoardDTO params, Model model) {
        System.out.println("sdsds");
        List<BoardDTO> noticeList = boardService.getNoticeList(params);
        model.addAttribute("noticeList" , noticeList);

        return "index";
    }
}
