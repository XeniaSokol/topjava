package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaloriesUtil {
    public static Map<LocalDate, Integer> getDaysAndCalories(List<UserMeal> meals) {
        Map<LocalDate, Integer> caloriesPerDays = new HashMap<>();
        for (UserMeal meal : meals) {
            LocalDate date = meal.getLocalDate();
            if (caloriesPerDays.containsKey(date)) {
                caloriesPerDays.put(date, caloriesPerDays.get(date) + meal.getCalories());
            } else {
                caloriesPerDays.put(date, meal.getCalories());
            }
        }
        return caloriesPerDays;
    }
}
