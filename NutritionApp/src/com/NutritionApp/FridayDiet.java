package com.NutritionApp;

public class FridayDiet implements Diet {
	
	private Workouts workouts;
	
	//Literal values
	private String name;
	private String email_address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}


	public FridayDiet() {}
	
	
	public void setWorkouts(Workouts workouts) {
		this.workouts = workouts;
	}

	@Override
	public String getDiet() {
		return "Eat boiled eggs";
	}

	@Override
	public String getDailyWorkouts() {
		return "Today is: "+ workouts.getWorkouts();
	}

}
