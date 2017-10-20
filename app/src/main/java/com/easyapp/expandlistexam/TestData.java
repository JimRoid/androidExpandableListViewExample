package com.easyapp.expandlistexam;

import android.util.Log;

import com.easyapp.expandlistexam.model.ChildData;
import com.easyapp.expandlistexam.model.GroupData;

import java.util.ArrayList;

/**
 * Created by easyapp_jim on 2017/10/20.
 */

public class TestData {

    public static ArrayList<GroupData> groupDataArrayList() {
        ArrayList<GroupData> groupDataArrayList = new ArrayList<>();
        ChildData childData;
        GroupData groupData;

        ArrayList<ChildData> dataArrayList = new ArrayList<>();
        childData = new ChildData("始皇帝 嬴政");
        dataArrayList.add(childData);
        childData = new ChildData("秦二世 胡亥");
        dataArrayList.add(childData);
        childData = new ChildData("秦三世 子嬰");
        dataArrayList.add(childData);
        Log.d("tag", "groupData.getChildDataArrayList().size():" + dataArrayList.size());
        groupData = new GroupData("秦朝", dataArrayList);
        dataArrayList.clear();
        Log.d("tag", "groupData.getChildDataArrayList().size():" + groupData.getChildDataArrayList().size());
        groupDataArrayList.add(groupData);

        childData = new ChildData("高皇帝 劉邦");
        dataArrayList.add(childData);
        childData = new ChildData("孝惠皇帝 劉盈");
        dataArrayList.add(childData);
        childData = new ChildData("孝文皇帝 劉恆");
        dataArrayList.add(childData);

        groupData = new GroupData("西漢", dataArrayList);
        dataArrayList.clear();
        groupDataArrayList.add(groupData);

        groupData = new GroupData("東漢");
        groupDataArrayList.add(groupData);

        return groupDataArrayList;
    }

}
