/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
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
