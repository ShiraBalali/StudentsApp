package com.learnoset.studentsapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.learnoset.studentsapp.model.Model;
import com.learnoset.studentsapp.model.Students;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity {
    List<Students> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        data = Model.instance().getallStudents();
        ListView list = findViewById(R.id.studentslist_list);
        list.setAdapter(new StudentsListAdapter());

    }

        class StudentsListAdapter extends BaseAdapter {


            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int pos, View view, ViewGroup viewGroup) {


                if (view == null){
                  view = getLayoutInflater().inflate(R.layout.students_list_row, null);
                    CheckBox cb = view.findViewById(R.id.cb2);
                    cb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int pos =(int) cb.getTag();
                            Students st = data.get(pos);
                            st.cb = cb.isChecked();
                        }
                    });
                }

                Students st = data.get(pos);
                TextView nameTv = view.findViewById(R.id.list_name);
                nameTv.setText(st.name);
                TextView idTv = view.findViewById(R.id.list_id);
                idTv.setText(st.id);
                CheckBox cb = view.findViewById(R.id.cb2);
                cb.setChecked(st.cb);
                cb.setTag(pos);
                return view;
            }
        }

}