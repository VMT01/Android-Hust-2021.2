package com.example.student_management;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    Cursor cs;

    public ItemAdapter(Cursor cs) {
        this.cs = cs;
    }

    @Override
    public int getCount() {
        return cs.getCount();
    }

    @Override
    public Object getItem(int i) {
        return cs.moveToPosition(i);
    }

    @Override
    public long getItemId(int i) {
        cs.moveToPosition(i);
        return cs.getInt(0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout, viewGroup, false);

        TextView textName = view.findViewById(R.id.text_name);
        TextView textStudentID = view.findViewById(R.id.text_student_id);

        cs.moveToPosition(i);

        String name = cs.getString(1);
        String studentID = cs.getString(2);

        textName.setText(name);
        textStudentID.setText(studentID);


        return view;
    }
}
