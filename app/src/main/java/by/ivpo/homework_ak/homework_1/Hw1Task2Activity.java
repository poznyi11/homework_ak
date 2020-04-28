package by.ivpo.homework_ak.homework_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class Hw1Task2Activity extends AppCompatActivity {

    final String textKey = "text";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1_task2);

        textView = findViewById(R.id.newText);;
        if (savedInstanceState != null) {
            this.textView.setText(savedInstanceState.getString(textKey));
        }

    }

    public void goText(View view) {

        EditText editText = findViewById(R.id.mainText);

        textView.setText(editText.getText());

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(textKey, this.textView.getText().toString());
    }

}
