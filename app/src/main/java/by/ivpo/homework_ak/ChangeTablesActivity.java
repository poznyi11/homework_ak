package by.ivpo.homework_ak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import by.ivpo.homework_ak.old.TableUsers;

public class ChangeTablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
    }

    public void goTableUsers(View view) {
        Intent intent = new Intent(this, TableUsers.class);
        startActivity(intent);
    }
}
