package com.wonderturn.wonderturn.service;

import com.wonderturn.wonderturn.models.Questions1;
import com.wonderturn.wonderturn.models.User;
import com.wonderturn.wonderturn.repositories.QuestionRepository1;
import com.wonderturn.wonderturn.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test_q1_service implements Test_data<Questions1>{

    private QuestionRepository1 questsRep1;
    private UsersRepository UserRep;

    @Autowired
    public Test_q1_service(QuestionRepository1 questRep1, UsersRepository UserRep){
        this.questsRep1 = questRep1;
        this.UserRep = UserRep;
    }

    public Iterable<Questions1> get_quests(){
        return this.questsRep1.findAll();
    }

    public void add(String question, String ans1, String ans2, String ans3, String ans4, Integer right_ans) {
        Questions1 questions_portion = new Questions1(question, ans1, ans2, ans3, ans4, right_ans);
        this.questsRep1.save(questions_portion);
    }

    public void save_result(String name, String surname, Integer score, Integer count) {
        User result = new User(name, surname, score, count);
        this.UserRep.save(result);
    }
}

