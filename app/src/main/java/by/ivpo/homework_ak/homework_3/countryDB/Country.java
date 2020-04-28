package by.ivpo.homework_ak.homework_3.countryDB;

import androidx.annotation.NonNull;

public class Country {
    public String countryName;
    public String capital;

    Country(String countryName, String capital) {
        this.countryName = countryName;
        this.capital = capital;
    }

    @NonNull
    @Override
    public String toString() {
        return "The capital of " + countryName + " is " + capital;
    }
}
