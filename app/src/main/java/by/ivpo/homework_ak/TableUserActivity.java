package by.ivpo.homework_ak;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import by.ivpo.homework_ak.database.DBHelper;
import by.ivpo.homework_ak.model.User;

import static by.ivpo.homework_ak.util.Constants.TABLE_USER;
import static by.ivpo.homework_ak.util.Constants.USER_ID;
import static by.ivpo.homework_ak.util.Constants.USER_NAME;
import static by.ivpo.homework_ak.util.Constants.USER_PHONE;
import static by.ivpo.homework_ak.util.Constants.USER_SECOND_NAME;

public class TableUserActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private final ArrayList<User> users = new ArrayList<>();
    private final UAdapter uAdapter = new UAdapter(this.users);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_users);

        // создаем объект для создания и управления версиями БД
//        dbHelper = new DBHelper(this);
//        DBHelper dbHelper = DBHelper.getInstance();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        //Теперь нашему компоненту RecyclerView необходмо указать, отображать список вертикально или горизонтально
        //Для этого устанавливаем ему LayoutManager с нужным атрибутом
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Автозаполнения стартовыми значениями
//        createStartValues();


        recyclerView.setAdapter(uAdapter);

//        Загрузка даных из DB
        loadDB();

    }

    public void add(View view) {
        EditText et_name = this.findViewById(R.id.et_name);
        EditText et_second_name = this.findViewById(R.id.et_second_name);
        EditText et_phone = this.findViewById(R.id.et_phone);

        String name = et_name.getText().toString();
        String secondName = et_second_name.getText().toString();
        String phone = et_phone.getText().toString();

        long rowId = addToDB(name, secondName, phone);

        this.users.add(new User((int) rowId, name, secondName, phone));


        et_name.setText("");
        et_second_name.setText("");
        et_phone.setText("");

        uAdapter.users = users;
        uAdapter.notifyItemInserted(this.users.size() - 1);

    }

    private long addToDB(String name, String secondName, String phone) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();


        // подключаемся к БД
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // подготовим данные для вставки в виде пар: наименование столбца - значение
        cv.put(USER_NAME, name);
        cv.put(USER_SECOND_NAME, secondName);
        cv.put(USER_PHONE, phone);

        // вставляем запись и получаем ее ID
        long rowID = db.insert("users", null, cv);
        return rowID;
    }

    public void clearDB(View view) {
        SQLiteDatabase db = DBHelper.getInstance().getWritableDatabase();
        int clearCount = db.delete(TABLE_USER, null, null);
        System.out.println(clearCount);
    }

    private void delete() {
    }

    public void loadDB() {
        users.clear();
        String s = dbHelper.getDatabaseName();
        System.out.println(s);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query(TABLE_USER, null, null, null, null, null, null);
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idIndex = c.getColumnIndex(USER_ID);
            int nameIndex = c.getColumnIndex(USER_NAME);
            int secondNameIndex = c.getColumnIndex(USER_SECOND_NAME);
            int phoneIndex = c.getColumnIndex(USER_PHONE);
            do {
                if (idIndex == -1) {
                    idIndex = 0;
                }
                users.add(new User(c.getInt(idIndex), c.getString(nameIndex), c.getString(secondNameIndex), c.getString(phoneIndex)));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            c.close();


        recyclerView.setAdapter(uAdapter);
    }

    @Override
    public void onClick(View v) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        int clearCount = db.delete(TABLE_USER, null, null);
//        System.out.println(clearCount);
    }

    private void createStartValues() {
        String phone = "8029-";
        String num = users.size() + "";
        for (int i = 0; i < 7; i++) {
            phone = phone.concat((users.size() + 1) + "");
        }
        users.add(new User(users.size() + 1, "N" + (users.size() + 1), "SN" + (users.size() + 1), phone));
        phone = "8029-";
        for (int i = 0; i < 7; i++) {
            phone = phone.concat((users.size() + 1) + "");
        }
        users.add(new User(users.size() + 1, "N" + (users.size() + 1), "SN" + (users.size() + 1), phone));
    }

}
