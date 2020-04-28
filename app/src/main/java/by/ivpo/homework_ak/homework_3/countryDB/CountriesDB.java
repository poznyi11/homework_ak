package by.ivpo.homework_ak.homework_3.countryDB;

import java.util.ArrayList;
import java.util.HashMap;

public class CountriesDB {
    public static ArrayList<Country> countries = new ArrayList<>();
    public static HashMap<String, String> countiesMap = new HashMap<>();

    static {
        countries.add(new Country("США", "Вашингтон"));
        countries.add(new Country("Россия", "Москва"));
        countries.add(new Country("Германия", "Берлин"));
        countries.add(new Country("Великобритания", "Лондон"));
        countries.add(new Country("Франция", "Париж"));
        countries.add(new Country("Испания", "Мадрид"));
        countries.add(new Country("Беларусь", "Минск"));
        countries.add(new Country("Польша", "Варшава"));
        countries.add(new Country("Украина", "Киев"));
        countries.add(new Country("Италия", "Рим"));
        countries.add(new Country("Латвия", "Рига"));
        countries.add(new Country("Литва", "Вильнюс"));
        countries.add(new Country("Китай", "Пекин"));
        countries.add(new Country("Япония", "Токио"));
        countries.add(new Country("Индия", "Дели"));
        countries.add(new Country("Египет", "Каир"));
        countries.add(new Country("Греция", "Афины"));
        countries.add(new Country("Болгария", "София"));
        countries.add(new Country("Австрия", "Вена"));
        countries.add(new Country("Чехия", "Прага"));

        for (int i = 0; i < countries.size(); i++) {
            countiesMap.put(countries.get(i).countryName, countries.get(i).capital);
        }
    }
}

