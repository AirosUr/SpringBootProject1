package com.wonderturn.wonderturn.repositories;

import com.wonderturn.wonderturn.models.Questions2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository2 extends CrudRepository<Questions2, Long> {
}
