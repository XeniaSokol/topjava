package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaloriesUtil {
    private final List<UserMeal> userMealList;
    private Map<LocalDate, Integer> daysAndCalories;

    public CaloriesUtil(List<UserMeal> userMealList) {
        this.userMealList = userMealList;
        this.daysAndCalories = getDaysAndCalories();
    }

    private Map<LocalDate, Integer> getDaysAndCalories() {
        daysAndCalories = new HashMap<>();
        for (UserMeal meal : userMealList) {
            LocalDate date = meal.getLocalDate();
            if (daysAndCalories.containsKey(date)) {
                daysAndCalories.put(date, daysAndCalories.get(date) + meal.getCalories());
            } else {
                daysAndCalories.put(date, meal.getCalories());
            }
        }
        return daysAndCalories;
    }

    public int getCaloriesPerDay(LocalDate day) {
        return daysAndCalories.get(day);
    }
}
