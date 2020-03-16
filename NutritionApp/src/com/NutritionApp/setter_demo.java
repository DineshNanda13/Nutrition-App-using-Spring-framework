package com.NutritionApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class setter_demo {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		FridayDiet newDiet = context.getBean("my_Friday", FridayDiet.class);

		// call methods on the bean
		System.out.println(newDiet.getDiet());

		//call the method for extra service
		System.out.println(newDiet.getDailyWorkouts()); //setter injection
		
		//call new methods to get literal values
		System.out.println(newDiet.getName());
		System.out.println(newDiet.getEmail_address());

		// close the context
		context.close();


	}

}
