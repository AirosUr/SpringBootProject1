package com.wonderturn.wonderturn.service;

import com.wonderturn.wonderturn.models.Questions2;
import com.wonderturn.wonderturn.models.User;
import com.wonderturn.wonderturn.repositories.QuestionRepository2;
import com.wonderturn.wonderturn.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test_q2_service implements Test_data<Questions2> {

    private QuestionRepository2 questsRep2;
    private UsersRepository UserRep;

    @Autowired
    public Test_q2_service(QuestionRepository2 questRep2, UsersRepository UserRep){
        this.questsRep2 = questRep2;
        this.UserRep = UserRep;
    }

    public Iterable<Questions2> get_quests(){
        return this.questsRep2.findAll();
    }

    public void add(String question, String ans1, String ans2, String ans3, String ans4, Integer right_ans) {
        Questions2 questions_portion = new Questions2(question, ans1, ans2, ans3, ans4, right_ans);
        this.questsRep2.save(questions_portion);
    }

    public void save_result(String name, String surname, Integer score, Integer count) {
        User result = new User(name, surname, score, count);
        this.UserRep.save(result);
    }
}
