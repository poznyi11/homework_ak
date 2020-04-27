package by.ivpo.homework_ak.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import by.ivpo.homework_ak.R;

public class MainHw1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw1);
    }

    public void goVers1(View view) {
        Intent intent = new Intent(this, Hw1Task1Vers1Activity.class);
        startActivity(intent);
    }

    public void goVers2(View view) {
        Intent intent = new Intent(this, Hw1Task1Vers2Activity.class);
        startActivity(intent);
    }

    public void goVers3(View view) {
        Intent intent = new Intent(this, Hw1Task1Vers3Activity.class);
        startActivity(intent);
    }

    public void goVers4(View view) {
        Intent intent = new Intent(this, Hw1Task2Activity.class);
        startActivity(intent);
    }
}
