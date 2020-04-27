package by.ivpo.homework_ak.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import by.ivpo.homework_ak.R;

public class MainHw2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw2);
    }

    public void startRandomNumbers(View view) {
        Intent intent = new Intent(this, RandomNumbers.class);
        startActivity(intent);
    }

    public void startUserNumbers(View view) {
        Intent intent = new Intent(this, UserNumbers.class);
        startActivity(intent);
    }

}
