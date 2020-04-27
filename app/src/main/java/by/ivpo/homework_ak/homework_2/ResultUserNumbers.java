package by.ivpo.homework_ak.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class ResultUserNumbers extends AppCompatActivity {

    boolean isAnswer = false;
    String textNumber1 = "";
    String textNumber2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_user_numbers);
        Intent intent = getIntent();

        textNumber1 = intent.getStringExtra("number1");
        textNumber2 = intent.getStringExtra("number2");
        String textAnswer = intent.getStringExtra("answer");

        String expression;
        String message;

        if ("".equals(textAnswer)) {
            expression = "Вы не ввели ответ";
            message = "ВЫ НЕ ВВЕЛИ ОТВЕТ";
            isAnswer = false;
        } else if ("".equals(textNumber1) || "".equals(textNumber2)) {
            expression = "Вы не ввели значения";
            message = "НЕПРАВИЛЬНЫЙ ОТВЕТ";
            isAnswer = false;
        } else {
            int number1 = Integer.parseInt(textNumber1);
            int number2 = Integer.parseInt(textNumber2);
            int answer = Integer.parseInt(textAnswer);
            String expressionNumber = number1 + " + " + number2 + " = " + answer;
            expression = expressionNumber;
            if (answer == number1 + number2) {
                message = "ПРАВИЛЬНЫЙ ОТВЕТ";
                isAnswer = true;
            } else {
                message = "НЕПРАВИЛЬНЫЙ ОТВЕТ";
                isAnswer = false;
            }
        }

        TextView textView1 = findViewById(R.id.answerText);
        TextView textView2 = findViewById(R.id.message);

        textView1.setText(expression);
        textView2.setText(message);


        if (isAnswer) {
            FrameLayout frameLayout = findViewById(R.id.layoutColor);
            frameLayout.setBackgroundColor(Color.GREEN);
            Button button = findViewById(R.id.buttonContinue);
            button.setText("Новое задание");
        } else {
            FrameLayout frameLayout = findViewById(R.id.layoutColor);
            frameLayout.setBackgroundColor(Color.RED);
            Button button = findViewById(R.id.buttonContinue);
            button.setText("Попробовать еще раз");
        }
    }

    public void backToContinueGame(View view) {
        EditText editText = findViewById(R.id.editText);
        String returnMessage = editText.getText().toString();
        Intent intent = new Intent(this, UserNumbers.class);
        intent.putExtra("returnMessage", returnMessage);
        intent.putExtra("isAnswer", isAnswer);
        startActivity(intent);
    }

    public void backToStart(View view) {
        Intent intent = new Intent(this, MainHw2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        boolean isBack = true;
        EditText editText = findViewById(R.id.editText);
        String returnMessage = "ОТМЕНА ДЕЙСТВИЯ";
        Intent intent = new Intent(this, UserNumbers.class);
        intent.putExtra("returnMessage", returnMessage);
        intent.putExtra("number1", textNumber1);
        intent.putExtra("number2", textNumber2);
        intent.putExtra("isBack", isBack);
        startActivity(intent);
    }
}

