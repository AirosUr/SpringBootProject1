package com.wonderturn.wonderturn.testers;

import com.wonderturn.wonderturn.models.Questions1;
import com.wonderturn.wonderturn.models.Questions2;
import com.wonderturn.wonderturn.service.Test_q1_service;
import com.wonderturn.wonderturn.service.Test_q2_service;
import org.springframework.ui.Model;

import java.util.HashMap;

public class tester1 implements test_type<Integer> {

    private test1 test1;
    private String[] quest;
    private int questsCount;
    private String name;
    private String surname;
    private int quest_num = 1;
    private int right_ans_count = 0;
    private String q_choice;

    public tester1(String name, String surname, String q_choice) {
        this.name = name;
        this.surname = surname;
        this.q_choice = q_choice;
    }

    public tester1() {
    }

    public void set_questions1(Model model, test_type test, Test_q1_service test_data) {
        test1 = new test1();
        Iterable<Questions1> quests1 = test_data.get_quests();
        quests1.forEach((element) -> {
                    test1.setQuests(quest_num, element.getQuestion(), element.getAns1(), element.getAns2(), element.getAns3(), element.getAns4(), element.getRight_ans());
                    quest_num+=1;
                }
        );
        test.start(model, quests1);
    }

    public void set_questions2(Model model, test_type test, Test_q2_service test_data) {
        test1 = new test1();
        Iterable<Questions2> quests1 = test_data.get_quests();
        quests1.forEach((element) -> {
                    test1.setQuests(quest_num, element.getQuestion(), element.getAns1(), element.getAns2(), element.getAns3(), element.getAns4(), element.getRight_ans());
                    quest_num+=1;
                }
        );
        test.start(model, quests1);
    }

    public void start(Model model, Iterable quests1) {
        quest_num = 1;
        questsCount = test1.getQuestsCount();
        quest = test1.getQuest(quest_num);
        for (int iline = 0; iline < quest.length; iline++) {
            model.addAttribute("line" + String.valueOf(iline), quest[iline]);
        }
    }

    public String work1(Model model, Integer variant, Test_q1_service test_data) {
        if (test1.getRight_ans(quest_num) == variant) {
            right_ans_count+=1;
        }
        if (quest_num >= questsCount) {
            model.addAttribute("r_qCount", right_ans_count);
            model.addAttribute("qCount", questsCount);
            test_data.save_result(name, surname, right_ans_count, questsCount);

            return "result";
        }
        quest_num+=1;
        quest = test1.getQuest(quest_num);
        for (int iline = 0; iline < quest.length; iline++) {
            model.addAttribute("line" + String.valueOf(iline), quest[iline]);
        }
        return "tester1";
    }

    public String work2(Model model, Integer variant, Test_q2_service test_data) {
        if (test1.getRight_ans(quest_num) == variant) {
            right_ans_count+=1;
        }
        if (quest_num >= questsCount) {
            model.addAttribute("r_qCount", right_ans_count);
            model.addAttribute("qCount", questsCount);
            test_data.save_result(name, surname, right_ans_count, questsCount);

            return "result";
        }
        quest_num+=1;
        quest = test1.getQuest(quest_num);
        for (int iline = 0; iline < quest.length; iline++) {
            model.addAttribute("line" + String.valueOf(iline), quest[iline]);
        }
        return "tester1";
    }

}

class test1 {
    private HashMap<Integer, String[]> quests = new HashMap<Integer, String[]>();
    private HashMap<Integer, Integer> right_ans = new HashMap<Integer, Integer>();

    public void setQuests(Integer quest_num, String question, String ans1, String ans2, String ans3, String ans4, Integer r_ans) {
        quests.put(quest_num, new String[]{question, ans1, ans2, ans3, ans4});
        right_ans.put(quest_num, r_ans);
    }

    public String[] getQuest(int quest_num) {
        String[] quest = quests.get(quest_num);
        return quest;
    }

    public Integer getRight_ans(int quest_num) {
        Integer rgh_ans = right_ans.get(quest_num);
        return rgh_ans;
    }

    public int getQuestsCount() {
        return quests.size();
    }
}