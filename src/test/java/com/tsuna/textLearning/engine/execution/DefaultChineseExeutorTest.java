/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultChineseExeutorTest.java
 *  Date : 18-5-17 下午4:10
 */

package com.tsuna.textLearning.engine.execution;

import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import org.junit.Test;

import java.io.IOException;

public class DefaultChineseExeutorTest {

    @Test
    public void execute() {
        DefaultChineseExeutor exeutor = new DefaultChineseExeutor();
        try {
            DefaultChineseExecutionResult result = exeutor.execute(3, 0.01, 0.01, "data/train");
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}