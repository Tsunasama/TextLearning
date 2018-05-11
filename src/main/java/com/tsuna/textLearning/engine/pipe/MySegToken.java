/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : MySegToken.java
 *  Date : 18-5-11 下午2:16
 */

package com.tsuna.textLearning.engine.pipe;

import com.huaban.analysis.jieba.SegToken;

import java.io.Serializable;

/**
 * Encapsulate a {@link SegToken} to build a serializable token
 */
public class MySegToken implements Serializable {

    private static final long serialVersionUID = -6562794434554667710L;

    private String word;
    private int startOffset;
    private int endOffset;

    public MySegToken(SegToken segToken) {
        this.word = segToken.word;
        this.endOffset = segToken.endOffset;
        this.startOffset = segToken.startOffset;
    }

    public String toString() {
        return "[" + this.word + ", " + this.startOffset + ", " + this.endOffset + "]";
    }

    public SegToken convertToSegToken() {
        return new SegToken(word, startOffset, endOffset);
    }
}
