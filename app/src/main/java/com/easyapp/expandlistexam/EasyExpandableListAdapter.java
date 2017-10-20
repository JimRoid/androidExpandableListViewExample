package com.easyapp.expandlistexam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyapp.expandlistexam.model.ChildData;
import com.easyapp.expandlistexam.model.GroupData;

import java.util.ArrayList;

/**
 * Created by easyapp_jim on 2017/10/20.
 */

public class EasyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<GroupData> group;

    public EasyExpandableListAdapter(Context context) {
        super();
        this.context = context;
        group = new ArrayList<>();
    }

    public Context getContext() {
        return context;
    }

    public void setGroup(ArrayList<GroupData> group) {
        this.group = group;
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return group.get(0).getChildDataArrayList().size();
    }

    @Override
    public GroupData getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public ChildData getChild(int groupPosition, int childPosition) {
        if (group.get(groupPosition).getChildDataArrayList().size() > 0) {
            ChildData childData = group.get(groupPosition).getChildDataArrayList().get(childPosition);
            return childData;
        }
        return null;
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //是否可以選取子項目
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    //這裡是說明每個item 是否有唯一的id 方便局部更新
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        GroupViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(getContext(), R.layout.expand_group, null);
            viewHolder = new GroupViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            viewHolder.ivGroupIndicator = (ImageView) view.findViewById(R.id.ivGroupIndicator);
            view.setTag(viewHolder);
        } else {
            viewHolder = (GroupViewHolder) view.getTag();
        }

        //隱藏 group indicator
        if (getGroup(groupPosition).getChildDataArrayList().size() == 0) {
            viewHolder.ivGroupIndicator.setVisibility(View.GONE);
        } else {
            viewHolder.ivGroupIndicator.setVisibility(View.VISIBLE);
        }

        viewHolder.ivGroupIndicator.setSelected(isExpanded);
        viewHolder.tvName.setText(getGroup(groupPosition).getName());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        ChildViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(getContext(), R.layout.expand_child, null);
            viewHolder = new ChildViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ChildViewHolder) view.getTag();
        }
        if (getChild(groupPosition, childPosition) != null) {
            viewHolder.tvName.setText(getChild(groupPosition, childPosition).getName());
        }
        return view;
    }

    private static class GroupViewHolder {
        private TextView tvName;
        private ImageView ivGroupIndicator;
    }

    private static class ChildViewHolder {
        private TextView tvName;
    }
}
