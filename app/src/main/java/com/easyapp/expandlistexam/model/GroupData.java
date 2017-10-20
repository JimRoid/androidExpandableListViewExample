package com.easyapp.expandlistexam.model;

import java.util.ArrayList;

/**
 * Created by easyapp_jim on 2017/10/20.
 */

public class GroupData {
    private String name;
    private ArrayList<ChildData> childDataArrayList;

    public GroupData() {
        super();
    }

    public GroupData(String name, ArrayList<ChildData> dataArrayList) {
        super();
        setName(name);
        setChildDataArrayList(dataArrayList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildData> getChildDataArrayList() {
        return childDataArrayList;
    }

    public void setChildDataArrayList(ArrayList<ChildData> dataArrayList) {
        if (childDataArrayList == null) {
            childDataArrayList = new ArrayList<>();
        }
        childDataArrayList.addAll(dataArrayList);
    }
}
