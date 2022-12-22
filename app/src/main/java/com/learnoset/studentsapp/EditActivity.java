package com.learnoset.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.learnoset.studentsapp.model.Model;
import com.learnoset.studentsapp.model.Students;

public class EditActivity extends AppCompatActivity {
    EditText nameIn, idIn, phoneIn, addressIn;
    Button saveBtn, cancelBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent me = getIntent();
        int pos = me.getIntExtra("pos", 0);
        Students s = Model.instance().getallStudents().get(pos);

        nameIn = findViewById(R.id.name_input);
        idIn = findViewById(R.id.id_input);
        phoneIn = findViewById(R.id.phone_input);
        addressIn = findViewById(R.id.address_input);
        saveBtn = findViewById(R.id.save_button);
        cancelBtn = findViewById(R.id.cancel_button);
        deleteBtn = findViewById(R.id.delete_button);
        CheckBox checked = findViewById(R.id.checkBox);

        nameIn.setText(s.name);
        idIn.setText(s.id);
        phoneIn.setText(s.phone);
        addressIn.setText(s.address);
        checked.setChecked(s.cb);

        saveBtn.setOnClickListener(view -> {
            String name = nameIn.getText().toString();
            String id = idIn.getText().toString();
            String phone = phoneIn.getText().toString();
            String address = addressIn.getText().toString();
            boolean isChecked = checked.isChecked();

            Students new_s = new Students(name, id, "", isChecked, phone, address);
            Model.instance().getallStudents().set(pos, new_s);

            finish();
        });

        deleteBtn.setOnClickListener(view -> {

            Model.instance().getallStudents().remove(pos);

            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}