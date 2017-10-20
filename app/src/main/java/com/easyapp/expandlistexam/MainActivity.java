package com.easyapp.expandlistexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EasyExpandableListAdapter easyExpandableListAdapter = new EasyExpandableListAdapter(this);
        easyExpandableListAdapter.setGroup(TestData.groupDataArrayList());

        ExpandableListView expandListView = (ExpandableListView) findViewById(R.id.expandListView);
        expandListView.setAdapter(easyExpandableListAdapter);

        //設定能不能收合
        expandListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (easyExpandableListAdapter.getGroup(groupPosition).getChildDataArrayList().size() > 0) {
                    //child 大於 0 可以收合
                    return false;
                } else {
                    //沒有child不能收合
                    show("沒有子項目");
                    return true;
                }
            }
        });

        // child listener
        expandListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String name = easyExpandableListAdapter.getChild(groupPosition, childPosition).getName();
                show(name);
                return true;
            }
        });
    }

    private void show(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }
}
