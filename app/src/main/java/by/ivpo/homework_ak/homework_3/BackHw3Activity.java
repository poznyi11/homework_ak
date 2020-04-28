package by.ivpo.homework_ak.homework_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import by.ivpo.homework_ak.R;

public class BackHw3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_hw3);
        setCapital();

    }

    private void setCapital() {
        Intent intent = getIntent();
        String capital = intent.getStringExtra("capital");
        CapitalFragment capitalFragment = (CapitalFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        capitalFragment.setCapital(capital);
    }

}
