package by.ivpo.homework_ak.homework_3;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import by.ivpo.homework_ak.R;
import by.ivpo.homework_ak.homework_3.countryDB.CountriesDB;

public class CountryFragment extends Fragment implements View.OnClickListener {

    View view;
    ArrayList<TextView> listView = new ArrayList<>();
    String capitalText;

    private FragmentListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_country, container, false);


        listView.add((TextView) view.findViewById(R.id.country_1));
        listView.add((TextView) view.findViewById(R.id.country_2));
        listView.add((TextView) view.findViewById(R.id.country_3));
        listView.add((TextView) view.findViewById(R.id.country_4));
        listView.add((TextView) view.findViewById(R.id.country_5));
        listView.add((TextView) view.findViewById(R.id.country_6));
        listView.add((TextView) view.findViewById(R.id.country_7));
        listView.add((TextView) view.findViewById(R.id.country_8));
        listView.add((TextView) view.findViewById(R.id.country_9));
        listView.add((TextView) view.findViewById(R.id.country_10));
        listView.add((TextView) view.findViewById(R.id.country_11));
        listView.add((TextView) view.findViewById(R.id.country_12));
        listView.add((TextView) view.findViewById(R.id.country_13));
        listView.add((TextView) view.findViewById(R.id.country_14));
        listView.add((TextView) view.findViewById(R.id.country_15));
        listView.add((TextView) view.findViewById(R.id.country_16));
        listView.add((TextView) view.findViewById(R.id.country_17));
        listView.add((TextView) view.findViewById(R.id.country_18));
        listView.add((TextView) view.findViewById(R.id.country_19));
        listView.add((TextView) view.findViewById(R.id.country_20));

        intiTextView();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (FragmentListener) context;

    }

    @Override
    public void onClick(View v) {


        if (v instanceof TextView) {
            for (int i = 0; i < listView.size(); i++) {
                listView.get(i).setBackgroundResource(R.drawable.back);
            }
            TextView textView = (TextView) v;
            String country = textView.getText().toString();
            capitalText = "The capital of " + country + " is \n\n" + CountriesDB.countiesMap.get(country).toUpperCase();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                textView.setBackgroundResource(R.drawable.back_gray);
                listener.update(capitalText);
            }
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                listener.goBack(capitalText);
            }
        }
    }

    public void intiTextView() {
        TextView textView;
        for (int i = 0; i < listView.size(); i++) {
            textView = listView.get(i);
            textView.setOnClickListener(this);
            textView.setText(CountriesDB.countries.get(i).countryName);
        }
    }

    public interface FragmentListener {
        void update(String capital);
        void goBack(String capital);
    }
}
