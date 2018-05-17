/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : ITextEngine.java
 *  Date : 18-5-16 下午2:03
 */

package com.tsuna.textLearning.engine.execution;

import java.io.IOException;

/**
 * Represents all text engines which use pipes to deal with texts and get execute result
 *
 * @param <T> represents the execute result type
 */
public interface ITextEngine<T> {
    /**
     * execute the the processor and get the handle result
     *
     * @return execution result,see {@link com.tsuna.textLearning.engine.result.ExecutionResultBase}
     */
    T execute(String filePath, int numTopics, double alpha, double beta) throws IOException;
}
