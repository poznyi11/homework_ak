package by.ivpo.homework_ak.homework_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class Hw1Task2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1_task2);
    }

    public void goText (View view){

        EditText editText = findViewById(R.id.mainText);

        TextView textView = findViewById(R.id.newText);

        textView.setText(editText.getText());

    }
}
