package by.ivpo.homework_ak.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import by.ivpo.homework_ak.model.User;

import static by.ivpo.homework_ak.util.Constants.USER_PHONE;
import static by.ivpo.homework_ak.util.Constants.TABLE_USER;
import static by.ivpo.homework_ak.util.Constants.USER_ID;
import static by.ivpo.homework_ak.util.Constants.USER_NAME;
import static by.ivpo.homework_ak.util.Constants.USER_SECOND_NAME;

public class UserQueryImpl implements QueryMyDB.UsersQuery {

    private DBHelper dbHelper = DBHelper.getInstance();

    @Override
    public void createUser(User user, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = getContentValuesForUser(user);
        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_USER, null, contentValues);
            if (id > 0) {
                response.onSuccess(true);
                user.setId((int) id);
            } else
                response.onFailure("Failed to create student. Unknown Reason!");
        } catch (SQLiteException e) {
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }

    }

    private ContentValues getContentValuesForUser(User user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_NAME, user.getName());
        contentValues.put(USER_SECOND_NAME, user.getSecondName());
        contentValues.put(USER_PHONE, user.getPhone());

        return contentValues;
    }

    private User getStudentFromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(USER_ID));
        String name = cursor.getString(cursor.getColumnIndex(USER_NAME));
        String secondName = cursor.getString(cursor.getColumnIndex(USER_SECOND_NAME));
        String phone = cursor.getString(cursor.getColumnIndex(USER_PHONE));

        return new User(id, name, secondName, phone);
    }

}
