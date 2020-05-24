package by.ivpo.homework_ak.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import by.ivpo.homework_ak.util.MyApp;

import static by.ivpo.homework_ak.util.Constants.USER_PHONE;
import static by.ivpo.homework_ak.util.Constants.TABLE_USER;
import static by.ivpo.homework_ak.util.Constants.USER_ID;
import static by.ivpo.homework_ak.util.Constants.USER_NAME;
import static by.ivpo.homework_ak.util.Constants.USER_SECOND_NAME;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "new_db";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper dbHelper;

    public DBHelper() {
        super(MyApp.context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    public DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }



    public static DBHelper getInstance() {
        if (dbHelper == null) {
            synchronized (DBHelper.class) {
                if (dbHelper == null)
                    System.out.println();
                dbHelper = new DBHelper();
            }
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME + " TEXT NOT NULL, "
                + USER_SECOND_NAME + " TEXT NOT NULL, "
                + USER_PHONE + " TEXT" // nullable
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        //Create table again
        onCreate(db);
    }
}
