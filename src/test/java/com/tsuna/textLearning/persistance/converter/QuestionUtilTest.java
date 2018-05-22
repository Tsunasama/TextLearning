/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionUtilTest.java
 *  Date : 18-5-22 上午8:16
 */

package com.tsuna.textLearning.persistance.converter;

import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.persistance.bean.Question;
import org.junit.Assert;
import org.junit.Test;

public class QuestionUtilTest {

    @Test
    public void convertFrom() {
        Instance instance = new Instance("data/test/question/question1.xml", 1);
        Question question = QuestionUtil.convertFrom(instance);
        String expected = "Question id:0\n" +
                "A:a option\n" +
                "B:b option\n" +
                "C:c option\n" +
                "D:d option\n" +
                "Correct:a option\n" +
                "Description:explanations here\n";
        Assert.assertEquals(expected, question.toString());
    }
}