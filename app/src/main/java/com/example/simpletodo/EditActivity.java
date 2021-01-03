package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etExistingItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etExistingItem = findViewById(R.id.etExistingItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        etExistingItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent which will contain results
                Intent intent = new Intent();
                // Pass results of edit
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etExistingItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // Set result of intent
                setResult(RESULT_OK, intent);
                // Finish activity, close screen and go back
                finish();
            }
        });
    }
}