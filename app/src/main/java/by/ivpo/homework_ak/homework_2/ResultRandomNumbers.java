package by.ivpo.homework_ak.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class ResultRandomNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_random_numbers);
        Intent intent = getIntent();

        String expression = intent.getStringExtra("expression");
        String message = intent.getStringExtra("message");
        String health = intent.getStringExtra("health");
        String right = intent.getStringExtra("right");
        boolean isAnswer = intent.getBooleanExtra("isAnswer", false);


        TextView textView1 = findViewById(R.id.answerText);
        TextView textView2 = findViewById(R.id.message);
        TextView textView3 = findViewById(R.id.heartText);
        TextView textView4 = findViewById(R.id.rightText);

        textView1.setText(expression);
        textView2.setText(message);
        textView3.setText(health);
        textView4.setText(right);

        if (isAnswer) {
            FrameLayout frameLayout = findViewById(R.id.layoutColor);
            frameLayout.setBackgroundColor(Color.GREEN);
        } else {
            FrameLayout frameLayout = findViewById(R.id.layoutColor);
            frameLayout.setBackgroundColor(Color.RED);
        }
    }

    public void backToStart(View view) {
        Intent intent = new Intent(this, MainHw2Activity.class);
        startActivity(intent);
    }

    public void backToContinueGame(View view) {
        Intent intent = new Intent(this, RandomNumbers.class);
        startActivity(intent);
    }
}
