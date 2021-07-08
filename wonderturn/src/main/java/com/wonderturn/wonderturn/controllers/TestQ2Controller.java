package com.wonderturn.wonderturn.controllers;

import com.wonderturn.wonderturn.service.Test_q2_service;
import com.wonderturn.wonderturn.testers.test_type;
import com.wonderturn.wonderturn.testers.tester1;
import com.wonderturn.wonderturn.testers.tester2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions2")
public class TestQ2Controller {
    private test_type test;
    private Test_q2_service test_data;

    @Autowired
    public TestQ2Controller(Test_q2_service test_data) {
        this.test_data = test_data;
    }

    @GetMapping("/test1")
    public String tester(@ModelAttribute("name") String name, @ModelAttribute("surname") String surname, @ModelAttribute("q_choice") String q_choice, Model model) {
        test = new tester1(name, surname, q_choice);
        test.set_questions2(model, test, test_data);
        return "tester1";
    }

    @PostMapping("/test1")
    public String ToNextQuest(@RequestParam("AnsChoice") Integer variant, Model model) {
        return (test.work2(model, variant, test_data));
    }

    @GetMapping("/test2")
    public String tester2(@ModelAttribute("name") String name, @ModelAttribute("surname") String surname, @ModelAttribute("q_choice") String q_choice, Model model) {
        test = new tester2(name, surname, q_choice);
        test.set_questions2(model, test, test_data);
        return "tester2";
    }

    @PostMapping("/test2")
    public String ToNextQuest2(@RequestParam("answer") String answer, Model model) {
        return (test.work2(model, answer, test_data));
    }

    @GetMapping("/change")
    public String changer(Model model) {
        return "test_change";
    }

    @PostMapping("/change")
    public String change(@RequestParam("question") String question,
                         @RequestParam("ans1") String ans1,
                         @RequestParam("ans2") String ans2,
                         @RequestParam("ans3") String ans3,
                         @RequestParam("ans4") String ans4,
                         @RequestParam("right_ans") Integer right_ans, Model model) {

        test_data.add(question, ans1, ans2, ans3, ans4, right_ans);
        return "test_change";
    }

    public TestQ2Controller() {
    }
}
