package com.biefeng.excel.template.impl;

import com.biefeng.excel.template.AbstractValue;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 21:47
 *@DESC
 */
public class StrValue implements AbstractValue {

    private String propName;

    public StrValue(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return propName;
    }

}
