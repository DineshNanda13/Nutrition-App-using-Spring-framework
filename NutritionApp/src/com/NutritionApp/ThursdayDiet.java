package com.NutritionApp;

public class ThursdayDiet implements Diet {
	
	private Workouts workouts;
	
	public ThursdayDiet(Workouts theworkouts) {
		
		this.workouts = theworkouts;
	}

	@Override
	public String getDiet() {
		return "Thursday: Eat Avocados with boiled broccolis";
	}

	@Override
	public String getDailyWorkouts() {

		return "Today is: "+workouts.getWorkouts();
	}

}
