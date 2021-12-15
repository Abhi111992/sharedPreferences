package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, addressEditText;
    Button saveData, retrievData, clearData, removeData;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEdittext);
        addressEditText = findViewById(R.id.addressEdittext);
        saveData = findViewById(R.id.saveData);
        retrievData = findViewById(R.id.retrievData);
        clearData = findViewById(R.id.clearData);
        removeData = findViewById(R.id.removeData);
        textView = findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences("Name", MODE_PRIVATE);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putString("Address", address);
                editor.apply();
            }
        });

        retrievData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("Name", "");
                String address = sharedPreferences.getString("Address", "");
                textView.setText("Name :" + name + "\nAddress :" + address);
                textView.setTextSize(40);
            }
        });

        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText.setText("");
                addressEditText.setText("");
            }
        });
        removeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.setVisibility(View.GONE);
            }
        });
    }
}
