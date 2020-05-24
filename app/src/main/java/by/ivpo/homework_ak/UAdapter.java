package by.ivpo.homework_ak;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import by.ivpo.homework_ak.database.DBHelper;
import by.ivpo.homework_ak.model.User;
import by.ivpo.homework_ak.util.MyApp;

import static by.ivpo.homework_ak.util.Constants.TABLE_USER;
import static by.ivpo.homework_ak.util.Constants.USER_ID;
import static by.ivpo.homework_ak.util.Constants.USER_NAME;
import static by.ivpo.homework_ak.util.Constants.USER_PHONE;
import static by.ivpo.homework_ak.util.Constants.USER_SECOND_NAME;

public class UAdapter extends RecyclerView.Adapter<UAdapter.UViewHolder> {
    public ArrayList<User> users;

    public UAdapter(ArrayList<User> users) {
        this.users = users;
    }

    class UViewHolder extends RecyclerView.ViewHolder {
        TextView user_id;
        TextView name;
        TextView secondName;
        TextView phone;

        public UViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.tv_user_id);
            name = itemView.findViewById(R.id.tv_name);
            secondName = itemView.findViewById(R.id.tv_second_name);
            phone = itemView.findViewById(R.id.tv_phone);
        }
    }

    @NonNull
    @Override
    public UAdapter.UViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new UViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UAdapter.UViewHolder holder, final int position) {
        holder.user_id.setText((users.get(position).getId()) + "");
        holder.name.setText(users.get(position).getName());
        holder.secondName.setText(users.get(position).getSecondName());
        holder.phone.setText(users.get(position).getPhone());
        Button btnDel = holder.itemView.findViewById(R.id.btn_del);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (users.size() != 0) {
                    removeUserFromDb(position, v.getContext());
                    users.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, users.size());
                }
            }
        });
    }

    private void removeUserFromDb(int position, Context context) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = DBHelper.getInstance().getWritableDatabase();
        Cursor c = db.query(TABLE_USER, null, null, null, null, null, null);
        int idIndex = c.getColumnIndex(USER_ID);
        System.out.println(idIndex);
        String id = c.getString(0);
        System.out.println(id);
        int clearCount = db.delete(TABLE_USER, USER_ID + " = " + id, null);
        System.out.println(clearCount);
        dbHelper.close();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
