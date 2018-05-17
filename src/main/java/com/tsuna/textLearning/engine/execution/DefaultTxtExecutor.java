/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Executor.java
 *  Date : 18-5-16 下午1:57
 */

package com.tsuna.textLearning.engine.execution;

import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.iterator.FileIterator;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.InstanceList;
import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResultBuilder;
import com.tsuna.textLearning.engine.util.FolderIteratorUtil;
import com.tsuna.textLearning.engine.util.PipeListUtil;

import java.io.*;

public class DefaultTxtExecutor implements IReusable<ParallelTopicModel>, ITextEngine<DefaultChineseExecutionResult> {

    private static String DEFAULT_MODEL_SAVE_PATH = "models/";
    private ParallelTopicModel model;
    private InstanceList instances;
    private SerialPipes pipes;

    /**
     * @param filePath if it is null or empty use the default filePath {@code data/train}.otherwise
     *                 use it as the root folder and traverse all sub folders to find text
     * @return execution result object
     */
    @Override
    public DefaultChineseExecutionResult execute(String filePath, int numTopics, double alpha, double beta) throws IOException {
        //Build process pipe
        pipes = PipeListUtil.getStandardChineseHandlePipe();

        //Build file iterator(files to be processed)
        FileIterator folderIterator;
        if (filePath == null || filePath.equals("")) {
            folderIterator = FolderIteratorUtil.getDefaultDevelopingTextFileIterator();
        } else {
            folderIterator = FolderIteratorUtil.getTextFileIterator(filePath);
        }

        //Build instanceList which contains all process instances(each instance presents an file to be processed)
        InstanceList instances = new InstanceList(pipes);
        instances.addThruPipe(folderIterator);

        //Build process model
        model = new ParallelTopicModel(numTopics, alpha, beta);
        model.addInstances(instances);
        model.setNumThreads(4);
        model.setNumIterations(50);
        model.estimate();

        //Build execution result
        DefaultChineseExecutionResultBuilder builder = new DefaultChineseExecutionResultBuilder(model);

        return builder.build();
    }

    @Override
    public void saveModel(String path, String fileName) throws IOException, IllegalAccessException {
        if (model == null || pipes == null) {
            throw new IllegalAccessException("Model is not initialized");
        }
        if (path == null || fileName == null) {
            throw new IllegalAccessException();
        }
        if (fileName.equals("")) {
            throw new IllegalArgumentException();
        }
        if (!path.endsWith("/"))
            path = path + "/";
        String completeModelPath = path + fileName + ".model";
        String completePipelinePath = path + fileName + ".pipeline";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(completeModelPath)))) {
            oos.writeObject(model);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(completePipelinePath)))) {
            oos.writeObject(pipes);
        }
    }

    public void saveModel(String fileName) throws IOException, IllegalAccessException {
        saveModel(DEFAULT_MODEL_SAVE_PATH, fileName);
    }

    @Override
    public ParallelTopicModel readModel(String path) throws IOException, IllegalAccessException, ClassNotFoundException {
        if (path == null)
            throw new IllegalAccessException();
        if (path.equals("")) {
            throw new IllegalArgumentException();
        }
        if (!path.endsWith(".model"))
            path = path + ".model";
        Object result;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))) {
            result = ois.readObject();
        }
        return (ParallelTopicModel) result;
    }
}
