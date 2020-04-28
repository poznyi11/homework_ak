package by.ivpo.homework_ak.homework_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import by.ivpo.homework_ak.R;

public class CapitalFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capital, container, false);
    }

    public void setCapital (String text){
        String s = "1";
        TextView textView = getView().findViewById(R.id.textCapital);
        textView.setText(text);
    }


}
