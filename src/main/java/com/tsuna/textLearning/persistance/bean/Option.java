/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : Option.java
 *  Date : 18-5-21 下午10:35
 */

package com.tsuna.textLearning.persistance.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Option {
    A("A"), B("B"), C("C"), D("D");

    private String db;

    Option(String db) {
        this.db = db;
    }

    public String getDb() {
        return db;
    }

    public static Option getOption(String str) {
        if (str.equalsIgnoreCase("a"))
            return Option.A;
        if (str.equalsIgnoreCase("b"))
            return Option.B;
        if (str.equalsIgnoreCase("c"))
            return Option.C;
        return Option.D;
    }
}
