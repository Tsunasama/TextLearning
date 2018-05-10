package com.tsuna.textLearning.engine.pipe;

import cc.mallet.extract.StringSpan;
import cc.mallet.extract.StringTokenization;
import cc.mallet.pipe.Pipe;
import cc.mallet.types.Instance;
import cc.mallet.types.TokenSequence;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A pipe that tokenize Chinese character sequence.
 * Expects a Chinese CharSequence and converts it into
 * a tocken sequence using JieBa the word segmentation.
 */

public class ChineseCharSequence2TokenSequence extends Pipe implements Serializable {
    private List<MySegToken> myTokens;

    @Override
    public Instance pipe(Instance inst) {
        CharSequence sequence = (CharSequence) inst.getData();
        //pretreatment, clear the spaces
        String text = sequence.toString().replaceAll("\\s+", "");
        //using Jieba to segmenting
        List<SegToken> tokens = new JiebaSegmenter().process(text, JiebaSegmenter.SegMode.INDEX);
        myTokens = convertFromSegTokenListToMySegTokenList(tokens);
        TokenSequence tokenSequence = new StringTokenization(text);
        for (SegToken token : tokens) {
            tokenSequence.add(new StringSpan(text, token.startOffset, token.endOffset));
        }
        inst.setData(tokenSequence);
        return inst;
    }

    // Serialization
    private static final long serialVersionUID = 1;


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(myTokens);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        myTokens = (List<MySegToken>) in.readObject();
    }

    private List<MySegToken> convertFromSegTokenListToMySegTokenList(List<SegToken> origin) {
        List<MySegToken> rtn = new ArrayList<>();
        for (SegToken segToken : origin) {
            rtn.add(new MySegToken(segToken));
        }
        return rtn;
    }
}
