package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etAmeri;
    EditText etLatte;
    EditText etMocca;
    TextView etCount;
    TextView etAmount;
    TextView etTotalAmount;
    CheckBox checkBox;

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmeri = findViewById(R.id.etAmeri);
        etLatte = findViewById(R.id.etLatte);
        etMocca = findViewById(R.id.etMocca);
        etCount = findViewById(R.id.etCount);
        etAmount = findViewById(R.id.etAmount);
        etTotalAmount = findViewById(R.id.etTotalAmount);
        checkBox = findViewById(R.id.checkBox);
    }
    public void onCalculate(View view) {
        //edit text
        String americano = etAmeri.getText().toString();
        int ameri = Integer.parseInt(americano);
        int ameriCost = ameri * 1000;

        String latte = etLatte.getText().toString();
        int cafelatte = Integer.parseInt(latte);
        int cafelatteCost = cafelatte * 1500;

        String mocca = etMocca.getText().toString();
        int cafemocca = Integer.parseInt(mocca);
        int cafemoccaCost = cafemocca * 1700;

        int count = ameri + cafelatte + cafemocca;
        sum = ameriCost + cafelatteCost + cafemoccaCost;

        etCount.setText("주문갯수: " + count);

        onCheckbox(view);

        etTotalAmount.setText("결제금액: " + sum);
    }


    public void onCheckbox(View view) {

        if (checkBox.isChecked()) {
            int discount = (int) (sum * 0.1);
            etAmount.setText("할인금액: " + discount + "원");
            sum -= discount;
        } else {
            etAmount.setText("할인금액: 0원");
        }
    }
    }
