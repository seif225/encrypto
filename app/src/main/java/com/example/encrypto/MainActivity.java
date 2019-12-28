package com.example.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView sc;
    EditText input;
    Button en;
    Button de;
    EditText keyEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiailzeFields();

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cipher = input.getText().toString().toLowerCase();
                final String key = String.valueOf(keyEt.getText());
                if(cipher.isEmpty()) input.setError("you have to writesomethign");
               else  if(key.isEmpty())  keyEt.setError("you must pick a key");
                else {
                    sc.setText(encrypt(cipher,Integer.parseInt(key)));
                }
            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cipher = input.getText().toString().toLowerCase();
                final String key = String.valueOf(keyEt.getText());
                if(cipher.isEmpty()) input.setError("you have to writesomethign");
                else  if(key.isEmpty())  keyEt.setError("you must pick a key");
                else {
                    sc.setText(decrypt(cipher,Integer.parseInt(key)));
                }
            }
        });


    }

    private void initiailzeFields() {
         sc = findViewById(R.id.textView);
         input = findViewById(R.id.editText);
         en = findViewById(R.id.en);
         de = findViewById(R.id.de);
         keyEt = findViewById(R.id.key);



    }

    private String decrypt(String s, int key) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            char current = s.charAt(i);
            for (int j = 0; j <key ; j++) {
                if(current<='a') current='z';
                else current= (char) (current-1);
            }
            sb.append(current);
        }
        return sb.toString();



    }

    static String encrypt(String s, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            key = key%25;
            if (current+key > 'z') current = (char) ((((current+key)-'z')+'a')-1);
            else current = (char) (current+key);

            sb.append(current);
        }
        return sb.toString();

    }


}
