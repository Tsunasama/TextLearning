/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tsuna.textLearning.engine.pipe;

import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.types.Instance;
import cc.mallet.types.SingleInstanceIterator;
import cc.mallet.types.TokenSequence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class ChineseCharSequence2TokenSequenceTest {

    private Instance instance;
    private SerialPipes pipes;

    @Before
    public void instantiate() {
        instance = new Instance(new File("data/train/C3-Art0002.txt"), null, null, null);
        pipes = new SerialPipes(new Pipe[]{
                new Input2CharSequence("GBK"),
                new ChineseCharSequence2TokenSequence()
        });
    }

    @Test
    public void UsingPipe() {
        Instance carrier = pipes.newIteratorFrom(new SingleInstanceIterator(instance)).next();
        TokenSequence ts = (TokenSequence) carrier.getData();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(ts.toString());
    }

    @Test
    public void testSerializable() {
        String modelPath = "models/test.model";
        String expected;
        String result = null;
        //get origin result
        TokenSequence originSequence = (TokenSequence) pipes.newIteratorFrom(new SingleInstanceIterator(instance)).next().getData();
        expected = originSequence.toString();
        //Write object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(modelPath))) {
            oos.writeObject(pipes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Read object
        try (ObjectInputStream isr = new ObjectInputStream(new FileInputStream(modelPath))) {
            SerialPipes readPipe = (SerialPipes) isr.readObject();
            TokenSequence readSequence = (TokenSequence) readPipe.newIteratorFrom(
                    new SingleInstanceIterator(new Instance(new File("data/train/C3-Art0002.txt"), null, null, null)))
                    .next().getData();
            result = readSequence.toString();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, result);

    }


}