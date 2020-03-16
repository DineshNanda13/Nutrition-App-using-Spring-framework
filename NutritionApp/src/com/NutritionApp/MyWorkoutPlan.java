package com.NutritionApp;

import java.util.Random;

public class MyWorkoutPlan implements Workouts {

	@Override
	public String getWorkouts() {
		
		String arr[] = {"Leg day", "Shoulder day", "Chest day", "Boxing day", "Running Day", "Yoga day", "Rest day"};
		
		Random random = new Random();
		int position = random.nextInt(arr.length);
		return arr[position];
	}

}
