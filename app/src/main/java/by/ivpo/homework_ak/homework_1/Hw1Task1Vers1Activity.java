package by.ivpo.homework_ak.homework_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class Hw1Task1Vers1Activity extends AppCompatActivity {

    final String numberKey = "number";
    int number = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1_task1_vers1);

        if (savedInstanceState != null) {
            this.number = savedInstanceState.getInt(numberKey);
        }

        setNumber(number);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(numberKey, this.number);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        this.number = savedInstanceState.getInt("number");
//    }


    private void setNumber(int number) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(number));
    }

    public void subNumber(View view) {
        TextView textView = findViewById(R.id.textView);
        String textNumber = textView.getText().toString();
        this.number = Integer.parseInt(textNumber);
        this.number = number - 1;
        textView.setText(Integer.toString(number));
    }

    public void addNumber(View view) {
        TextView textView = findViewById(R.id.textView);
        String textNumber = textView.getText().toString();
        this.number = Integer.parseInt(textNumber);
        this.number = number + 1;
        textView.setText(Integer.toString(number));
    }
}
