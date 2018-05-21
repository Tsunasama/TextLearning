/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : DefaultChineseExeutor.java
 *  Date : 18-5-17 下午4:08
 */

package com.tsuna.textLearning.engine.execution;

import cc.mallet.pipe.iterator.FileIterator;
import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import com.tsuna.textLearning.engine.util.FolderIteratorUtil;
import com.tsuna.textLearning.engine.util.PipeListUtil;

import java.io.IOException;

public class DefaultChineseExeutor extends DefaultChineseExecutorBase {
    /**
     * Use the default Chinese handling pipeline to do pre-execution on files.
     *
     * @param filePath if it is null or empty use the default filePath {@code data/train}. Otherwise
     *                 use it as the root folder and traverse all sub folders to find text
     * @return execution result object
     */
    public DefaultChineseExecutionResult execute(int numTopics, double alpha, double beta, String filePath) throws IOException {
        //Build process pipe
        pipes = PipeListUtil.getStandardChineseHandlePipe();

        //Build file iterator(files to be processed)
        FileIterator folderIterator;
        if (filePath == null || filePath.equals("")) {
            folderIterator = FolderIteratorUtil.getDefaultDevelopingTextFileIterator();
        } else {
            folderIterator = FolderIteratorUtil.getTextFileIterator(filePath);
        }

        return super.execute(numTopics, alpha, beta, filePath, folderIterator, pipes);
    }
}
