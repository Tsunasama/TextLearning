/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : PipeListUtil.java
 *  Date : 18-5-11 下午4:16
 *
 */

package com.tsuna.textLearning.engine.util;

import cc.mallet.pipe.*;
import com.tsuna.textLearning.engine.pipe.ChineseCharSequence2TokenSequence;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Build different kinds of {@link SerialPipes} in common
 */
public class PipeListUtil {

    private static final String CHINESE_STOP_WORD_LIST_FILE_PATH = "data/stoplists/chinese_stopword.txt";
    private static final String ENGLISH_STOP_WORD_LIST_FILE_PATH = "data/stoplists/english_stopword.txt";

    public static SerialPipes getStandardChineseHandlePipe() {
        ArrayList<Pipe> pipeList = new ArrayList<>();
        pipeList.add(new Input2CharSequence("GBK"));
        pipeList.add(new ChineseCharSequence2TokenSequence());
        pipeList.add(new TokenSequenceLowercase());
        pipeList.add(new TokenSequenceRemoveStopwords(new File(CHINESE_STOP_WORD_LIST_FILE_PATH),
                "utf-8", false, false, false));
        pipeList.add(new TokenSequence2FeatureSequence());
        pipeList.add(new Target2Label());
        return new SerialPipes(pipeList);
    }

    public static SerialPipes getTestChineseHandlePipe() {
        ArrayList<Pipe> pipeList = new ArrayList<>();
        pipeList.add(new Input2CharSequence("GBK"));
        pipeList.add(new ChineseCharSequence2TokenSequence());
        pipeList.add(new TokenSequenceLowercase());
        pipeList.add(new TokenSequenceRemoveStopwords(new File(CHINESE_STOP_WORD_LIST_FILE_PATH),
                "utf-8", false, false, false));
        pipeList.add(new TokenSequence2FeatureSequence());
        pipeList.add(new Target2Label());
        pipeList.add(new PrintInputAndTarget());
        return new SerialPipes(pipeList);
    }

    public static SerialPipes getStandardEnglishHandlePipe() {
        ArrayList<Pipe> pipeList = new ArrayList<>();
        pipeList.add(new Input2CharSequence("UTF-8"));
        Pattern tokenPattern = Pattern.compile("[\\p{L}\\p{N}_]+");
        pipeList.add(new CharSequence2TokenSequence(tokenPattern));
        pipeList.add(new TokenSequenceLowercase());
        pipeList.add(new TokenSequenceRemoveStopwords(new File(ENGLISH_STOP_WORD_LIST_FILE_PATH),
                "utf-8", false, false, false));
        pipeList.add(new TokenSequence2FeatureSequence());
        pipeList.add(new Target2Label());
        return new SerialPipes(pipeList);
    }

    public static SerialPipes getXmlUtf8ChineseHandlePipe() {
        ArrayList<Pipe> pipeList = new ArrayList<>();
        pipeList.add(new Input2CharSequence("utf-8"));
        pipeList.add(new CharSequenceRemoveHTML());
        pipeList.add(new ChineseCharSequence2TokenSequence());
        pipeList.add(new TokenSequenceLowercase());
        pipeList.add(new TokenSequenceRemoveStopwords(new File(CHINESE_STOP_WORD_LIST_FILE_PATH),
                "utf-8", false, false, false));
        pipeList.add(new TokenSequence2FeatureSequence());
        pipeList.add(new Target2Label());
        return new SerialPipes(pipeList);
    }
}
