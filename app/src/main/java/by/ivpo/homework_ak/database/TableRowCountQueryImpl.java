package by.ivpo.homework_ak.database;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import by.ivpo.homework_ak.model.TableRowCount;

import static by.ivpo.homework_ak.util.Constants.TABLE_USER;

public class TableRowCountQueryImpl implements QueryMyDB.TableRowCountQuery {
    @Override
    public void getTableRowCount(QueryResponse<TableRowCount> response) {
        DBHelper databaseHelper = DBHelper.getInstance();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        try {
            long userCount = DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_USER);

            TableRowCount tableRowCount = new TableRowCount(userCount);
            response.onSuccess(tableRowCount);

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }
}
