package com.majjel.majjel.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.majjel.majjel.user.User;

public interface QuestionRepository extends JpaRepository<Question, Long>  {

	public User getQuestionById(@Param("id") long id);

}
