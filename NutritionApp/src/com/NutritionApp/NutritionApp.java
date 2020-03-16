package com.NutritionApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NutritionApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Diet newDiet = context.getBean("diet_Plan", Diet.class);
		
		// call methods on the bean
		System.out.println(newDiet.getDiet());
		
		//call the method for extra service
		System.out.println(newDiet.getDailyWorkouts());//constructor injection
		
		// close the context
		context.close();

	}

}
