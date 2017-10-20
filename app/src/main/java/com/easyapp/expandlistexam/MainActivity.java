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
