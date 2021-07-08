package com.wonderturn.wonderturn.testers;

import com.wonderturn.wonderturn.models.Questions1;
import com.wonderturn.wonderturn.models.Questions2;
import com.wonderturn.wonderturn.service.Test_q1_service;
import com.wonderturn.wonderturn.service.Test_q2_service;
import org.springframework.ui.Model;

import java.util.HashMap;

public class tester2 implements test_type<String> {

    private test2 test2;
    private String quest;
    private String name;
    private String surname;
    private int questsCount;
    private int quest_num = 1;
    private int right_ans_count = 0;
    private String q_choice;

    public tester2() {
    }

    public tester2(String name, String surname, String q_choice) {
        this.name = name;
        this.surname = surname;
        this.q_choice = q_choice;
    }

    public void set_questions1(Model model, test_type test, Test_q1_service test_data) {
        test2 = new test2();
        Iterable<Questions1> quests1 = test_data.get_quests();
        quests1.forEach((element) -> {
                    switch (element.getRight_ans()) {
                        case 1:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns1());
                            break;
                        case 2:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns2());
                            break;
                        case 3:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns3());
                            break;
                        case 4:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns4());
                            break;
                    }
                    quest_num+=1;
                }
        );
        test.start(model, quests1);
    }

    public void set_questions2(Model model, test_type test, Test_q2_service test_data) {
        test2 = new test2();
        Iterable<Questions2> quests1 = test_data.get_quests();
        quests1.forEach((element) -> {
                    switch (element.getRight_ans()) {
                        case 1:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns1());
                            break;
                        case 2:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns2());
                            break;
                        case 3:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns3());
                            break;
                        case 4:
                            test2.setQuests(quest_num, element.getQuestion(), element.getAns4());
                            break;
                    }
                    quest_num+=1;
                }
        );
        test.start(model, quests1);
    }

    public void start(Model model, Iterable quests1) {
        quest_num = 1;
        questsCount = test2.getQuestsCount();
        model.addAttribute("qCount", questsCount);
        quest = test2.getQuest(quest_num);
        model.addAttribute("question", quest);
    }

    public String work1(Model model, String variant, Test_q1_service test_data) {
        if (test2.getRight_ans(quest_num) == variant) {
            right_ans_count+=1;
        }
        if (quest_num >= questsCount) {
            model.addAttribute("r_qCount", right_ans_count);
            model.addAttribute("qCount", questsCount);

            test_data.save_result(name, surname, right_ans_count, questsCount);
            return "result";
        }
        quest_num+=1;
        quest = test2.getQuest(quest_num);
        model.addAttribute("question", quest);
        return "tester2";
    }

    public String work2(Model model, String variant, Test_q2_service test_data) {
        if (test2.getRight_ans(quest_num) == variant) {
            right_ans_count+=1;
        }
        if (quest_num >= questsCount) {
            model.addAttribute("r_qCount", right_ans_count);
            model.addAttribute("qCount", questsCount);

            test_data.save_result(name, surname, right_ans_count, questsCount);
            return "result";
        }
        quest_num+=1;
        quest = test2.getQuest(quest_num);
        model.addAttribute("question", quest);
        return "tester2";
    }

}

class test2 {
    private HashMap<Integer, String> quests = new HashMap<Integer, String>();
    private HashMap<Integer, String> right_ans = new HashMap<Integer, String>();

    public void setQuests(Integer quest_num, String question, String r_ans) {
        quests.put(quest_num, question);
        right_ans.put(quest_num, r_ans);
    }

    public String getQuest(int quest_num) {
        String quest = quests.get(quest_num);
        return quest;
    }

    public String getRight_ans(int quest_num) {
        String rgh_ans = right_ans.get(quest_num);
        return rgh_ans;
    }

    public int getQuestsCount() {
        return quests.size();
    }
}



