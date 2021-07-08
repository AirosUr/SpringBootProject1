package com.wonderturn.wonderturn.controllers;

import com.wonderturn.wonderturn.service.Test_q1_service;
import com.wonderturn.wonderturn.testers.test_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PreTestController {

    private test_type test;
    private Test_q1_service test_data;

    @Autowired
    public PreTestController(Test_q1_service test_data) {
        this.test_data = test_data;
    }

    @GetMapping("/")
    public String login_form(Model model) {
        test = null;
        return "login";
    }

    @PostMapping("/")
    public RedirectView login(RedirectAttributes redirectAttributes,
                              @RequestParam("test_choice") String test_choice,
                              @RequestParam("q_choice") String q_choice,
                              @RequestParam("name") String name,
                              @RequestParam("surname") String surname,
                              Model model) {
        RedirectView redirectView = new RedirectView();
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("surname", surname);
        redirectAttributes.addFlashAttribute("test_choice", test_choice);
        redirectView.setUrl("/" + q_choice + "/" + test_choice);
        return redirectView;
    }


    public PreTestController() {

    }

}