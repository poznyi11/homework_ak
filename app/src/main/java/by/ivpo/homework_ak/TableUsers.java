package by.ivpo.homework_ak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TableUsers extends AppCompatActivity {

    private final List<User> users = new ArrayList<>();
    private final RecyclerView.Adapter adapter = new UserAdapter(this.users);

    Button btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_users);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);


    }

    public void add(View view) {
        EditText et_name = this.findViewById(R.id.et_name);
        EditText et_second_name = this.findViewById(R.id.et_second_name);
        EditText et_phone = this.findViewById(R.id.et_phone);

        String name = et_name.getText().toString();
        String secondName = et_second_name.getText().toString();
        String phone = et_phone.getText().toString();

        this.users.add(new User(name, secondName, phone));

        et_name.setText("");
        et_second_name.setText("");
        et_phone.setText("");

        adapter.notifyItemInserted(this.users.size() - 1);
    }


    private static final class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<User> users;

        public UserAdapter(List<User> users) {
            this.users = users;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false)) {
            };
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            final int pos = position;

            TextView tv_name = holder.itemView.findViewById(R.id.tv_name);
            TextView tv_secondName = holder.itemView.findViewById(R.id.tv_second_name);
            TextView tv_phone = holder.itemView.findViewById(R.id.tv_phone);
            Button btnDel = holder.itemView.findViewById(R.id.btn_del);

            tv_name.setText(position + " " + this.users.get(position).getName());
            tv_secondName.setText(this.users.get(position).getSecondName());
            tv_phone.setText(this.users.get(position).getPhone());

            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (users.size() != 0) {
                        users.remove(pos);
                        notifyItemRemoved(pos);
                        notifyItemRangeChanged(pos, users.size());
                    }
                }
            });


        }

        @Override
        public int getItemCount() {
            return this.users.size();
        }
    }
}
