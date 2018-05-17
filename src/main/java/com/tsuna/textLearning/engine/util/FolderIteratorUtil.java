/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : FolderIteratorUtil.java
 *  Date : 18-5-11 下午3:12
 *
 */

package com.tsuna.textLearning.engine.util;

import cc.mallet.pipe.iterator.FileIterator;

import java.io.File;
import java.io.FileFilter;

public class FolderIteratorUtil {
    private static String DEFAULT_DEVELOPING_FILE_PATH = "data/train";

    public static FileIterator getDefaultDevelopingTextFileIterator() {
        return getTextFileIterator(DEFAULT_DEVELOPING_FILE_PATH);
    }

    /**
     * Using the indicated {@code path} to build a {@code FileIterator} , and filter
     * files name ends with ".txt"
     *
     * @param path the root path which includes all files
     * @return customized file iterator
     */
    public static FileIterator getTextFileIterator(String path) {
        return new FileIterator(
                new File[]{new File(path)},
                new FileFilter() {
                    @Override
                    public boolean accept(File path) {
                        return path.toString().endsWith(".txt");
                    }
                },
                FileIterator.LAST_DIRECTORY
        );
    }
}
