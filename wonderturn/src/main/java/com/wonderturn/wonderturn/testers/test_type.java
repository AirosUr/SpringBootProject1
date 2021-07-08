package com.wonderturn.wonderturn.testers;

import com.wonderturn.wonderturn.service.Test_q1_service;
import com.wonderturn.wonderturn.service.Test_q2_service;
import org.springframework.ui.Model;

public interface test_type<T> {
    void set_questions1(Model model, test_type test, Test_q1_service test_q1_service);
    void set_questions2(Model model, test_type test, Test_q2_service test_q1_service);
    void start(Model model, Iterable quests1);
    String work1(Model model, T variant, Test_q1_service test_q1_service);
    String work2(Model model, T variant, Test_q2_service test_q1_service);

}
