/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : QuestionUtil.java
 *  Date : 18-5-22 上午7:47
 */

package com.tsuna.textLearning.persistance.converter;

import com.tsuna.textLearning.engine.result.element.Instance;
import com.tsuna.textLearning.persistance.bean.Option;
import com.tsuna.textLearning.persistance.bean.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class QuestionUtil {
    public static Question convertFrom(Instance instance) {
        return convertFromXML(instance.getPath());
    }

    private static Question convertFromXML(String path) {
        Question rtn = new Question();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = builderFactory.newDocumentBuilder();
            Document document = db.parse(path);
            Node root = document.getDocumentElement();
            for (Node node = root.getFirstChild(); node != null; node = node.getNextSibling()) {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.getNodeName().equalsIgnoreCase("content"))
                        rtn.setContent(node.getTextContent());
                    else if (node.getNodeName().equalsIgnoreCase("options"))
                        setOption(rtn, node);
                    else if (node.getNodeName().equalsIgnoreCase("answer"))
                        rtn.setCorrect(Option.getOption(node.getTextContent()));
                    else if (node.getNodeName().equalsIgnoreCase("explanation"))
                        rtn.setDescription(node.getTextContent());
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    private static void setOption(Question question, Node option) {
        for (Node node = option.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equalsIgnoreCase("a"))
                    question.setA(node.getTextContent());
                else if (node.getNodeName().equalsIgnoreCase("b"))
                    question.setB(node.getTextContent());
                else if (node.getNodeName().equalsIgnoreCase("c"))
                    question.setC(node.getTextContent());
                else if (node.getNodeName().equalsIgnoreCase("d"))
                    question.setD(node.getTextContent());
            }
        }
    }
}
