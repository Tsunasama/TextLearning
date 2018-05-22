/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : XmlChineseExecutionResult.java
 *  Date : 18-5-22 上午10:15
 */

package com.tsuna.textLearning.engine.execution;

import cc.mallet.pipe.iterator.FileIterator;
import com.tsuna.textLearning.engine.result.DefaultChineseExecutionResult;
import com.tsuna.textLearning.engine.util.FolderIteratorUtil;
import com.tsuna.textLearning.engine.util.PipeListUtil;

import java.io.IOException;

public class XmlChineseExecutor extends DefaultChineseExecutorBase {

    public DefaultChineseExecutionResult execute(int numTopics, double alpha, double beta, String filePath) throws IOException {
        //Build process pipe
        pipes = PipeListUtil.getXmlUtf8ChineseHandlePipe();

        //Build file iterator(files to be processed)
        FileIterator folderIterator;
        if (filePath == null || filePath.equals("")) {
            folderIterator = FolderIteratorUtil.getDefaultXmlFileIterator();
        } else {
            folderIterator = FolderIteratorUtil.getXmlFileIterator(filePath);
        }
        return super.execute(numTopics, alpha, beta, filePath, folderIterator, pipes);
    }
}
