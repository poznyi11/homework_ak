package by.ivpo.homework_ak.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import by.ivpo.homework_ak.R;

public class MainHw4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw4);
    }

    public void goActivityOnlyCl (View view){
        Intent intent = new Intent(this, OnlyCL.class);
        startActivity(intent);
    }

    public void goActivityWithoutCl (View view){
        Intent intent = new Intent(this, WithoutCL.class);
        startActivity(intent);
    }

}
