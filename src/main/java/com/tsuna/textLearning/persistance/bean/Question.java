/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Question.java
 *  Date : 18-5-21 下午10:40
 */

package com.tsuna.textLearning.persistance.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question {
    private int id;
    private String content;
    private Option correct;
    private String A;
    private String B;
    private String C;
    private String D;
    private String description;
    private Topic topic;

    public Question() {
        super();
    }

    @XmlElement(name = "topic")
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement(name = "correct")
    public Option getCorrect() {
        return correct;
    }

    public void setCorrect(Option correct) {
        this.correct = correct;
    }

    @XmlElement(name = "A")
    public String getA() {
        return A;
    }

    public void setA(String a) {
        this.A = a;
    }

    @XmlElement(name = "B")
    public String getB() {
        return B;
    }

    public void setB(String b) {
        this.B = b;
    }

    @XmlElement(name = "C")
    public String getC() {
        return C;
    }

    public void setC(String c) {
        this.C = c;
    }

    @XmlElement(name = "D")
    public String getD() {
        return D;
    }

    public void setD(String d) {
        this.D = d;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question id:" + id + "\nA:" + A + "\nB:" + B + "\nC:" + C + "\nD:" + D + "\nCorrect:" + A + "\nDescription:" + description + "\n" +
                "Topic:" + topic.toString();
    }
}
