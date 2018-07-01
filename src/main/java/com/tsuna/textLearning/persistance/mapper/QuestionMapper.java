/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionMapper.java
 *  Date : 18-5-21 下午10:48
 */

package com.tsuna.textLearning.persistance.mapper;

import com.tsuna.textLearning.persistance.bean.Question;

import java.util.List;

public interface QuestionMapper {
    Question getQuestion(int id);

    List<Question> getAllQuestions();
    void insertQuestion(Question question);

    void updateQuestion(Question question);

    int deleteQuestion(int id);
}
