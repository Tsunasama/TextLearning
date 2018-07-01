/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Questions.java
 *  Date : 18-6-12 下午9:02
 */

package com.tsuna.textLearning.persistance.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "questions")
public class Questions implements Serializable {
    private static final long serialVersionUID = -5542387415226308843L;
    private List<Question> questionList;

    public Questions() {
        super();
    }

    public Questions(List<Question> questionList) {
        this.questionList = questionList;
    }

    @XmlElement(name = "question")
    @XmlElementWrapper
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(final List<Question> questionList) {
        this.questionList = questionList;
    }
}
