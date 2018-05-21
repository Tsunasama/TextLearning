/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultEnglishExecutor.java
 *  Date : 18-5-21 下午10:00
 */

package com.tsuna.textLearning.engine.execution;

import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.iterator.FileIterator;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.InstanceList;
import com.tsuna.textLearning.engine.result.DefaultEnglishExecutionResult;
import com.tsuna.textLearning.engine.result.DefaultEnglishExecutionResultBuilder;
import com.tsuna.textLearning.engine.util.FolderIteratorUtil;
import com.tsuna.textLearning.engine.util.PipeListUtil;

import java.io.IOException;

public class DefaultEnglishExecutor implements ITextEngine<DefaultEnglishExecutionResult> {
    private SerialPipes pipes;
    private ParallelTopicModel model;
    private InstanceList instances;

    public DefaultEnglishExecutionResult execute(int numTopics, double alpha, double beta, String filePath) throws IOException {
        //Build process pipe
        pipes = PipeListUtil.getStandardEnglishHandlePipe();

        //Build file iterator(files to be processed)
        FileIterator folderIterator;
        if (filePath == null || filePath.equals("")) {
            folderIterator = FolderIteratorUtil.getDefaultDevelopingTextFileIterator();
        } else {
            folderIterator = FolderIteratorUtil.getTextFileIterator(filePath);
        }

        return execute(numTopics, alpha, beta, filePath, folderIterator, pipes);
    }

    @Override
    public DefaultEnglishExecutionResult execute(int numTopics, double alpha, double beta, String filePath, FileIterator iterator, SerialPipes pipes) throws IOException {
        this.pipes = pipes;

        //Build instanceList which contains all process instances(each instance presents an file to be processed)
        instances = new InstanceList(pipes);
        instances.addThruPipe(iterator);

        //Build process model
        model = new ParallelTopicModel(numTopics, alpha, beta);
        model.addInstances(instances);
        model.setNumThreads(4);
        model.setNumIterations(50);
        model.estimate();

        //Build execution result
        DefaultEnglishExecutionResultBuilder builder = new DefaultEnglishExecutionResultBuilder(model);

        return builder.build();
    }
}
