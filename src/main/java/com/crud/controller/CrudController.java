package com.crud.controller;


import com.crud.model.Board;
import com.crud.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CrudController {

    private BoardServiceImpl service;

    @Autowired
    public CrudController(BoardServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value="/listAll",method= RequestMethod.GET)
    public void listAll(Model model)throws Exception{
        model.addAttribute("list",service.listAll());
    }

    @RequestMapping(value="/regist",method=RequestMethod.GET)
    public void registerGET(Board board,Model model)throws Exception{

    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST) // POST방식으로 내용 전송
    public String registPOST(Board board, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용
        service.regist(board); // 글작성 서비스 호출
        return "redirect:/listAll"; // 작성이 완료된 후, 목록페이지로 리턴
    }
    
    @RequestMapping(value="/read",method=RequestMethod.GET)
    public void read(@RequestParam("bno")int bno, Model model) throws Exception{
        service.updateView(bno);
        model.addAttribute(service.read(bno)); //read service 호출
    }

    @RequestMapping(value="/modify", method=RequestMethod.GET)
    public void modifyGET(int bno,Model model)throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value="/modify",method=RequestMethod.POST)
    public String modifyPOST(Board board,RedirectAttributes rttr) throws Exception{
        service.modify(board);

        return "redirect:/listAll"; //수정완료된 후 목록페이지로 리턴
    }
    
    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public String removePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
        service.remove(bno); //글삭제 서비스 호출
        
        return "redirect:/listAll"; //삭제가 된 후, 목록페이지로 리턴
    }
}
