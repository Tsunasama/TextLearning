/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : IReusable.java
 *  Date : 18-5-16 下午2:01
 */

package com.tsuna.textLearning.engine.execution;

/**
 * Represents resusable executor which could serialize their model persistantly
 *
 * @param <T> model type
 */
public interface IReusable<T> {
    /**
     * Save(Serialize) the model at the indicated path
     *
     * @param path the directory to save the model
     */
    void saveModel(String path, String fileName) throws Exception;

    /**
     * Read(Deserialize) the model at the indicated path
     *
     * @param path the directory to read model
     * @return deserialized object to read
     */
    T readModel(String path) throws Exception;
}
