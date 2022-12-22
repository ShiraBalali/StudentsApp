package com.learnoset.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.learnoset.studentsapp.model.Model;
import com.learnoset.studentsapp.model.Students;

public class InfoActivity extends AppCompatActivity {
    TextView nameIn, idIn, phoneIn, addressIn;
    Button editBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent me = getIntent();
        int pos = me.getIntExtra("pos", 0);
        Students s = Model.instance().getallStudents().get(pos);

        nameIn = findViewById(R.id.name_input);
        idIn = findViewById(R.id.id_input);
        phoneIn = findViewById(R.id.phone_input);
        addressIn = findViewById(R.id.address_input);
        editBtn = findViewById(R.id.edit_button);
        CheckBox checked = findViewById(R.id.checkBox);

        nameIn.setText(s.name);
        idIn.setText(s.id);
        phoneIn.setText(s.phone);
        addressIn.setText(s.address);
        checked.setChecked(s.cb);

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, EditActivity.class);
            intent.putExtra("pos", pos);
            startActivity(intent);

            finish();
        });
    }
}