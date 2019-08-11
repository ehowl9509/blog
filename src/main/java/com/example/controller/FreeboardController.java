package com.example.controller;

import com.example.repository.FreeboardRepository;
import com.example.service.freeboard.FreeboardInfoService;
import com.example.service.freeboard.FreeboardListService;
import com.example.service.freeboard.FreeboardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class FreeboardController {

    private int returnIntValue(String stringToInt){
        return Integer.parseInt(stringToInt);
    }

    @Autowired
    private FreeboardWriteService freeboardWriteService;

    @Autowired
    private FreeboardListService freeboardListService;

    @Autowired
    private FreeboardInfoService freeboardInfoService;
    @Autowired
    private FreeboardRepository freeboardRepository;

    @RequestMapping("/freeboard")
    public String freeboard(@RequestParam(value ="pageNum",defaultValue = "1")String pageNum) {

        String page = freeboardListService.freeboardList(returnIntValue(pageNum));
        return page;
    }

    @PostMapping("/freeboardWriteRequest")
    public String freeboardWriteRequest(@RequestParam Map<String, String> paramMap){
       String title =  paramMap.get("title");
       String content = paramMap.get("content");
       String writer =  paramMap.get("writer");
       freeboardWriteService.write(title, content, writer);

        return "redirect:/freeboard";
    }

    @RequestMapping("/freeBoardInfo")
    public String getPost(@RequestParam(value = "freeId") String freeId){
        String page =  freeboardInfoService.getBoard(freeId);
        return page;
    }
}
