/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Topic.java
 *  Date : 18-5-16 下午4:35
 */

package com.tsuna.textLearning.engine.result.element;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class Topic {
    private int tempId;
    private List<String> description;

    public List<String> getDescription() {
        return description;
    }

    public String getDescriptionString() {
        StringBuilder builder = new StringBuilder();
        for (String str : description) {
            builder.append(str).append(" ");
        }
        return builder.toString();
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public int getTempId() {

        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    @Override
    public String toString() {
        Formatter out = new Formatter(new StringBuilder(), Locale.CHINESE);
        out.format("%d\t", tempId);
        for (String str : description) {
            out.format("%s ", str);
        }
        out.format("%s", "\n");
        return out.toString();
    }
}
