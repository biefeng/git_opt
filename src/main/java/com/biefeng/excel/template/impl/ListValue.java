package com.biefeng.excel.template.impl;

import com.biefeng.excel.template.AbstractValue;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 22:13
 *@DESC
 */
public class ListValue implements AbstractValue {

    private String listName;

    private String listPropName;

    public ListValue(String listName, String listPropName) {
        this.listName = listName;
        this.listPropName = listPropName;
    }

    public String getListName() {
        return listName;
    }


    public String getListPropName() {
        return listPropName;
    }


}
