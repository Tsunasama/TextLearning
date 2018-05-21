/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultEnglishExecutorTest.java
 *  Date : 18-5-21 下午10:07
 */

package com.tsuna.textLearning.engine.execution;

import com.tsuna.textLearning.engine.result.DefaultEnglishExecutionResult;
import org.junit.Test;

import java.io.IOException;

public class DefaultEnglishExecutorTest {

    @Test
    public void execute() {
        DefaultEnglishExecutor executor = new DefaultEnglishExecutor();
        try {
            DefaultEnglishExecutionResult result = executor.execute(5, 0.01, 0.01, "data/bbc");
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}