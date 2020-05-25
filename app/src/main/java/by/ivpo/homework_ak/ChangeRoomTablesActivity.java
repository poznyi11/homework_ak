package by.ivpo.homework_ak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeRoomTablesActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_room_tables);
        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(this);
    }

    public void click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_LONG).show();
//    }

}
