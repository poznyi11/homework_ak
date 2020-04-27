package by.ivpo.homework_ak.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class UserNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_numbers);
        setReturnMessage();
        setRandomNumbers();
        setBackNumbers();

    }

    public void sendValues(View view) {
        Intent intent = new Intent(this, ResultUserNumbers.class);

        EditText enterNum1ET = findViewById(R.id.enterNumber1);
        EditText enterNum2ET = findViewById(R.id.enterNumber2);
        EditText answerET = findViewById(R.id.enterAnswer);

        String textNumber1 = enterNum1ET.getText().toString();
        String textNumber2 = enterNum2ET.getText().toString();
        String textAnswer = answerET.getText().toString();

        intent.putExtra("number1", textNumber1);
        intent.putExtra("number2", textNumber2);
        intent.putExtra("answer", textAnswer);

        startActivity(intent);
    }

    private void setReturnMessage() {
        Intent intent = getIntent();
        String returnMessage = intent.getStringExtra("returnMessage");
        TextView textView = findViewById(R.id.textView4);
        textView.setText(returnMessage);
    }

    private void setRandomNumbers() {
        Intent intent = getIntent();
        boolean isAnswer = intent.getBooleanExtra("isAnswer", false);
        if (isAnswer) {
            EditText et1 = findViewById(R.id.enterNumber1);
            EditText et2 = findViewById(R.id.enterNumber2);
            et1.setText(Integer.toString(getRandomNumber(100)));
            et2.setText(Integer.toString(getRandomNumber(100)));
            et1.setEnabled(false);
            et2.setEnabled(false);
        }
    }

    private void setBackNumbers() {
        Intent intent = getIntent();
        boolean isAnswer = intent.getBooleanExtra("isBack", false);
        if (isAnswer) {
            String textNumber1 = intent.getStringExtra("number1");
            String textNumber2 = intent.getStringExtra("number2");
            EditText et1 = findViewById(R.id.enterNumber1);
            EditText et2 = findViewById(R.id.enterNumber2);
            et1.setText(textNumber1);
            et2.setText(textNumber2);
            et1.setEnabled(false);
            et2.setEnabled(false);
        }
    }

    private int getRandomNumber(int n) {
        int randomNumber = (int) (Math.random() * n);
        return randomNumber;
    }
}