package com.biefeng.excel.template.impl;

import com.biefeng.excel.template.AbstractValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 21:19
 *@DESC
 */
public class TemplateExpression {
    private static final Pattern LIST = Pattern.compile("(?<listName>[a-zA-Z]+)\\[(?<propName>[a-zA-Z])\\]");
    private static final Pattern STR = Pattern.compile("(?<propName>[a-zA-Z])");

    private String key;

    private ValueType type;


    public TemplateExpression(String key) {
        this.key = key;
    }

    public AbstractValue getValueType() {
        Matcher strMatcher = STR.matcher(key);
        if (strMatcher.find()) {
            String propName = strMatcher.group("propName");
            type = ValueType.STR;
            return new StrValue(propName);
        }

        Matcher listMatcher = LIST.matcher(key);
        if (listMatcher.find()) {
            String listName = listMatcher.group("listName");
            String propName = listMatcher.group("propName");
            type = ValueType.LIST;
            return new ListValue(listName, propName);
        }

        return null;
    }

    public ValueType getType() {
        return type;
    }
}