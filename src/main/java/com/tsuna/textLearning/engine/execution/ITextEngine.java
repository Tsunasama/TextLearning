/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : ITextEngine.java
 *  Date : 18-5-16 下午2:03
 */

package com.tsuna.textLearning.engine.execution;

import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.iterator.FileIterator;

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
     * @param filePath the root to search for files to be executed
     * @param numTopics indicate the count of topics
     * @param alpha the argument to build a model,see{@link cc.mallet.topics.ParallelTopicModel}
     * @param beta the argument to build a model,see {@link cc.mallet.topics.ParallelTopicModel}
     * @param iterator to iterate all accordant file in the {@code filePath}
     * @param pipes pipeline to do pretreatment on files
     * @return execution result,see {@link com.tsuna.textLearning.engine.result.ExecutionResultBase}
     * @throws IOException file is not found
     */
    T execute(int numTopics, double alpha, double beta, String filePath, FileIterator iterator, SerialPipes pipes) throws IOException;
}
