package com.learnoset.studentsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.learnoset.studentsapp.model.Model;
import com.learnoset.studentsapp.model.Students;

import java.util.List;

public class StudentsRecyclerList extends AppCompatActivity {
    List<Students> data;
    StudentsRecyclerAdapter adapter;
    TextView nameTv;
    TextView idTv;
    CheckBox cb;
    FloatingActionButton add_button;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
        {
            data = Model.instance().getallStudents();
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_recycler_list);

        RecyclerView list = findViewById(R.id.studentsrecycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentsRecyclerAdapter();
        list.setAdapter(adapter);

        data = Model.instance().getallStudents();

        adapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(int pos){
                Log.d("TAG", "Row was clicked" + pos);
            }
        });

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentsRecyclerList.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }

    class StudentsViewHolder extends RecyclerView.ViewHolder{

        public StudentsViewHolder(@NonNull View itemView,  OnItemClickListener listener){
            super(itemView);
             nameTv = itemView.findViewById(R.id.list_name);
             idTv = itemView.findViewById(R.id.list_id);
             cb = itemView.findViewById(R.id.cb2);
            CheckBox cb = itemView.findViewById(R.id.cb2);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos =(int) cb.getTag();
                    Students st = data.get(pos);
                    st.cb = cb.isChecked();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(StudentsRecyclerList.this, InfoActivity.class);
                    intent.putExtra("pos", pos);
                    startActivity(intent);
                }
            });
        }

        public void bind(Students st, int pos) {
            nameTv.setText(st.name);
            idTv.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(pos);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }
    class StudentsRecyclerAdapter extends RecyclerView.Adapter<StudentsViewHolder>{
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.students_list_row,parent,false);
            return new StudentsViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
            Students st = data.get(position);
            holder.bind(st,position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}