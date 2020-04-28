package by.ivpo.homework_ak.homework_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import by.ivpo.homework_ak.R;

public class MainHw3Activity extends AppCompatActivity implements CountryFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw3);
    }

    @Override
    public void update(String capital) {
        String s = "s";
        int x = R.id.textCapital;
        CapitalFragment capitalFragment = (CapitalFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        capitalFragment.setCapital(capital);
    }

    @Override
    public void goBack(String capital) {
        Intent intent = new Intent(this, BackHw3Activity.class);
        intent.putExtra("capital", capital);
        startActivity(intent);
    }
}
