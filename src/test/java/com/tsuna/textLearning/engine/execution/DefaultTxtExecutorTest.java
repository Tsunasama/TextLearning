/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultTxtExecutorTest.java
 *  Date : 18-5-17 上午10:26
 */

package com.tsuna.textLearning.engine.execution;

import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import org.junit.Test;

import java.io.IOException;

public class DefaultTxtExecutorTest {

    @Test
    public void execute() {
        DefaultTxtExecutor executor = new DefaultTxtExecutor();
        try {
            DefaultChineseExecutionResult result = executor.execute("data/test", 3, 0.01, 0.01);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}