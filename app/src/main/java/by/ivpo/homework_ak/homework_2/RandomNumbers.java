package by.ivpo.homework_ak.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class RandomNumbers extends AppCompatActivity {

    private String name1 = "undefined";
    private String name2 = "undefined";
    private String buttonText = "undefined";
    private String healthText = "undefined";
    private long timeLeftInMilliseconds = 15000;
    private int health = 3;
    private int right = 0;


    final static String nameVariableKey1 = "NAME_VARIABLE_NUMBER1";
    final static String nameVariableKey2 = "NAME_VARIABLE_NUMBER2";
    final static String nameVariableKey3 = "NAME_VARIABLE_BUTTON";
    final static String nameVariableKey4 = "NAME_VARIABLE_TIME";
    final static String nameVariableKey5 = "NAME_VARIABLE_HEALTH";
    final static String nameVariableKey6 = "NAME_VARIABLE_RIGHT";


    final static String textViewTexKey1 = "TEXTVIEW_TEXT_NUMBER1";
    final static String textViewTexKey2 = "TEXTVIEW_TEXT_NUMBER2";
    final static String buttonViewTexKey = "BUTTONVIEW_TEXT_BUTTON";
    final static String varTimeTexKey = "TEXT_VAR_TIME";
    final static String varHealthTexKey = "TEXT_VAR_HEALTH";
    final static String varRigthTexKey = "TEXT_VAR_RIGHT";


    private boolean isStartGame = false;
    private boolean isStarted = false;

    TextView tv1;
    TextView tv2;

    private TextView countDownText;
    Button button;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_numbers);
        initHealthAndRight();

        button = findViewById(R.id.button);

    }


    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(nameVariableKey1, name1);
        TextView nameView1 = (TextView) findViewById(R.id.number1);
        outState.putString(textViewTexKey1, nameView1.getText().toString());

        outState.putString(nameVariableKey1, name2);
        TextView nameView2 = (TextView) findViewById(R.id.number2);
        outState.putString(textViewTexKey2, nameView2.getText().toString());

        outState.putString(nameVariableKey3, buttonText);
        Button buttonView = (Button) findViewById(R.id.button);
        outState.putString(buttonViewTexKey, buttonView.getText().toString());

        outState.putLong(nameVariableKey4, timeLeftInMilliseconds);
        outState.putInt(nameVariableKey5, health);
        outState.putInt(nameVariableKey6, right);

        super.onSaveInstanceState(outState);
    }


    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name1 = savedInstanceState.getString(nameVariableKey1);
        String textViewText1 = savedInstanceState.getString(textViewTexKey1);
        TextView nameView1 = (TextView) findViewById(R.id.number1);
        nameView1.setText(textViewText1);

        name2 = savedInstanceState.getString(nameVariableKey2);
        String textViewText2 = savedInstanceState.getString(textViewTexKey2);
        TextView nameView2 = (TextView) findViewById(R.id.number2);
        nameView2.setText(textViewText2);

        buttonText = savedInstanceState.getString(nameVariableKey3);
        String textButton = savedInstanceState.getString(buttonViewTexKey);
        TextView nameView3 = (TextView) findViewById(R.id.button);
        nameView3.setText(textButton);

        timeLeftInMilliseconds = savedInstanceState.getLong(nameVariableKey4);

        health = savedInstanceState.getInt(nameVariableKey5);
        String healthText = savedInstanceState.getString(varHealthTexKey);
        TextView nameView4 = (TextView) findViewById(R.id.heartText);
        nameView4.setText(healthText);



        right = savedInstanceState.getInt(nameVariableKey6);


        testTimer(timeLeftInMilliseconds);

    }

    public void sendValues() {

        Intent intent = new Intent(this, ResultRandomNumbers.class);

        TextView tv1 = findViewById(R.id.number1);
        TextView tv2 = findViewById(R.id.number2);
        EditText editText3 = findViewById(R.id.enterAnswer);

        String textNumber1 = tv1.getText().toString();
        String textNumber2 = tv2.getText().toString();
        String textAnswer = editText3.getText().toString();


        int number1 = Integer.parseInt(textNumber1);
        int number2 = Integer.parseInt(textNumber2);
        if ("".equals(textAnswer)) {
            health--;
            intent.putExtra("expression", "Вы не ввели ответ");
            intent.putExtra("message", "ВЫ НЕ ВВЕЛИ ОТВЕТ");
            intent.putExtra("isAnswer", false);
        } else {
            int answer = Integer.parseInt(textAnswer);
            String expression = number1 + " + " + number2 + " = " + answer;
            if (answer == number1 + number2) {
                right++;
                intent.putExtra("expression", expression);
                intent.putExtra("message", "ПРАВИЛЬНЫЙ ОТВЕТ");
                intent.putExtra("isAnswer", true);
            } else {
                health--;
                intent.putExtra("expression", expression);
                intent.putExtra("message", "НЕПРАВИЛЬНЫЙ ОТВЕТ");
                intent.putExtra("isAnswer", false);
            }
        }

        intent.putExtra("health", Integer.toString(health));
        intent.putExtra("right", Integer.toString(right));
        startActivity(intent);

    }

    private void createRandom() {
        tv1 = findViewById(R.id.number1);
        tv2 = findViewById(R.id.number2);
        if ("".equals(tv1.getText().toString()) && "".equals(tv2.getText().toString())) {
            EditText editText = findViewById(R.id.enterAnswer);
            int number1 = (int) (Math.random() * 9 + 1);
            int number2 = (int) (Math.random() * 9 + 1);
            tv1.setText(Integer.toString(number1));
            tv2.setText(Integer.toString(number2));
            editText.setHint("введите ответ");
        }
    }

    private void initHealthAndRight() {
        TextView healthText = findViewById(R.id.heartText);
        TextView rightText = findViewById(R.id.rightText);

        healthText.setText(Integer.toString(health));
        rightText.setText(Integer.toString(right));
    }

    public void startRandomGame(View view) {

        if (!isStarted) {
            isStarted = true;
            createRandom();
            testTimer(timeLeftInMilliseconds);
        } else {
            sendValues();
            isStartGame = true;
        }
    }

    public void testTimer(long time) {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                int seconds = (int) timeLeftInMilliseconds / 1000;
                if (seconds > 10) {
                    button.setBackgroundColor(Color.GREEN);
                } else if (seconds > 5 && seconds < 10) {
                    button.setBackgroundColor(Color.YELLOW);
                } else if (seconds > 0 && seconds < 5) {
                    button.setBackgroundColor(Color.RED);
                } else if (seconds == 0) {
                    button.setText("Вы проиграли!");
                    isStartGame = false;
                    return;
                }
                String timeText = "Отправить" + "\n" +
                        Integer.toString(seconds);
                button.setText(timeText);
            }


            @Override
            public void onFinish() {

            }
        }.start();
    }
}
