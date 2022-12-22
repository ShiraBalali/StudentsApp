package com.learnoset.studentsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.learnoset.studentsapp.model.Model;
import com.learnoset.studentsapp.model.Students;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    EditText nameIn, idIn, phoneIn, addressIn;
    Button saveBtn, cancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

         nameIn = findViewById(R.id.name_input);
         idIn = findViewById(R.id.id_input);
         phoneIn = findViewById(R.id.phone_input);
         addressIn = findViewById(R.id.address_input);
         saveBtn = findViewById(R.id.save_button);
         cancelBtn = findViewById(R.id.cancel_button);
        CheckBox checked = findViewById(R.id.checkBox);

        saveBtn.setOnClickListener(view -> {
            String name = nameIn.getText().toString();
            String id = idIn.getText().toString();
            String phone = phoneIn.getText().toString();
            String address = addressIn.getText().toString();
            boolean isChecked = checked.isChecked();

            Students s = new Students(name, id, "", isChecked, phone, address);
            Model.instance().getallStudents().add(s);

            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}