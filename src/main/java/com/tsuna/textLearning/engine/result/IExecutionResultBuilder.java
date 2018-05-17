/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : IExecutionResultBuilder.java
 *  Date : 18-5-16 下午4:28
 */

package com.tsuna.textLearning.engine.result;

/**
 * a tool which can build the text execution result to return
 *
 * @param <T> the type of execution result
 */
public interface IExecutionResultBuilder<T> {
    T build();
}
