package by.ivpo.homework_ak.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class Hw1Task1Vers3Activity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1_task1_vers3);
        setNumber(300);

        Button subButton = findViewById(R.id.subButton);
        Button addButton = findViewById(R.id.addButton);

        subButton.setOnClickListener(this);
        addButton.setOnClickListener(this);


    }

    private void setNumber (int number){
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(number));
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == findViewById(R.id.subButton).getId()){
            TextView textView = findViewById(R.id.textView);
            String textNumber = textView.getText().toString();
            int number = Integer.parseInt(textNumber);
            textView.setText(Integer.toString(number - 1));
        } else if (v.getId() == findViewById(R.id.addButton).getId()){
            TextView textView = findViewById(R.id.textView);
            String textNumber = textView.getText().toString();
            int number = Integer.parseInt(textNumber);
            textView.setText(Integer.toString(number + 1));
        }
    }
}
