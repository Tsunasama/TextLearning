/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : XmlChineseExecutorTest.java
 *  Date : 18-5-22 上午10:28
 */

package com.tsuna.textLearning.engine.execution;

import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import org.junit.Test;

import java.io.IOException;

public class XmlChineseExecutorTest {

    @Test
    public void execute() {
        XmlChineseExecutor executor = new XmlChineseExecutor();
        try {
            DefaultChineseExecutionResult result = executor.execute(5, 0.01, 0.01, "data/test/question");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}