package com.suai.sergey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.suai.sergey.fix_package.FixDeliveryActivity;
import com.suai.sergey.free_package.FreeDeliveryActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixDeliveryButton();
        freeDeliveryButton();
    }

    //кнопки
    //TODO должен быть запрос, который посылает данные, выбранные в спиннерах
    private void fixDeliveryButton() {
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }

    private void freeDeliveryButton() {
        final Intent freeDeliveryIntent = new Intent(MainActivity.this, FreeDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.free_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(freeDeliveryIntent));
    }

//    private void makeToast(String text) {
//        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//    }
}