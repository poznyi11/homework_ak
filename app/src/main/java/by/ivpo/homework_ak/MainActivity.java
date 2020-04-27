package by.ivpo.homework_ak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import by.ivpo.homework_ak.homework_1.MainHw1Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goMainHw1(View view) {
        Intent intent = new Intent(this, MainHw1Activity.class);
        startActivity(intent);
    }
}
