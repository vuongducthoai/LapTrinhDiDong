package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                String reversed = reverseAndUpperCase(input);

                textView.setText(reversed);
                Toast.makeText(MainActivity.this, reversed, Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfRandomNumbers = 10;

                ArrayList<Integer> randomNumbers = generateRandomNumbers(numberOfRandomNumbers);

                for (int number : randomNumbers) {
                    Log.d("RandomNumber", "Số ngẫu nhiên: " + number);
                }
            }
        });
    }
    private String reverseAndUpperCase(String str) {
        String[] words = str.split(" ");

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        return reversed.toString().trim().toUpperCase();
    }


    private ArrayList<Integer> generateRandomNumbers(int size) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 100) + 1;
            randomNumbers.add(random);
        }
        return randomNumbers;
    }
}
