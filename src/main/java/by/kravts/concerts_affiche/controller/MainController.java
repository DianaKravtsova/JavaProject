package by.kravts.concerts_affiche.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }

//    private String message = "from Dianka";
//
//
//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
//    public ModelAndView index(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        model.addAttribute("message", message);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = {"/concertPage"}, method = RequestMethod.GET)
//    public ModelAndView concertPage(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("concert_page");
//        model.addAttribute("message", message);
//        return modelAndView;
//    }

}


