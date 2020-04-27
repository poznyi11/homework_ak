package by.ivpo.homework_ak.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class Hw1Task1Vers1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1_task1_vers1);

        setNumber(100);

    }

    private void setNumber (int number){
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(number));
    }

    public void subNumber (View view){
        TextView textView = findViewById(R.id.textView);
        String textNumber = textView.getText().toString();
        int number = Integer.parseInt(textNumber);
        textView.setText(Integer.toString(number - 1));
    }

    public void addNumber (View view){
        TextView textView = findViewById(R.id.textView);
        String textNumber = textView.getText().toString();
        int number = Integer.parseInt(textNumber);
        textView.setText(Integer.toString(number + 1));
    }
}
