# Nutrition-App-using-Spring-framework
Usage of Spring IOC and Constructor Injection, Setter Injection and Literal value injection. The app gives daily diet plan using Spring IOC feature and the app also gives daily workout using constructor and setter dependency Injection. Further, it gives contact details of the Nutritionist using literal values Injection

//File name : Diet.java

package com.NutritionApp;

public interface Diet {
	
	public String getDiet();
	
	public String getDailyWorkouts();

}

//File name : MondayDiet.java

package com.NutritionApp;

public class MondayDiet implements Diet {

	@Override
	public String getDiet() {
		return "Monday: Eat boiled veggies";
	}

	@Override
	public String getDailyWorkouts() {
		// TODO Auto-generated method stub
		return null;
	}

}

//File name : TuesdayDiet.java

package com.NutritionApp;

public class TuesdayDiet implements Diet {

	@Override
	public String getDiet() {
		return "Tuesday: Eat boiled chicken breast";
	}

	@Override
	public String getDailyWorkouts() {
		// TODO Auto-generated method stub
		return null;
	}

}

//File name : WednesdayDiet.java

package com.NutritionApp;

public class WednesdayDiet implements Diet {

	@Override
	public String getDiet() {
		return "Wednesday: Eat boiled fish";
	}

	@Override
	public String getDailyWorkouts() {
		// TODO Auto-generated method stub
		return null;
	}

}

//File name : ThursdayDiet.java

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

//File name : FridayDiet.java

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

//File name : NutritionApp.java

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

//File name : setter_demo.java

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

//File name : Workouts.java

package com.NutritionApp;

public interface Workouts {
	
	public String getWorkouts();
}

//File name : MyWorkoutPlan.java

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

//File name : applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- load the properties file -->
    <context:property-placeholder location="classpath:nutritionistInfo.properties"/>

	<!-- add entry to enable component scanning -->

	<context:component-scan
		base-package="com.NutritionApp" />
		
		<!-- Extra service bean -->
		<bean 
		id = "my_workouts"
		class = "com.NutritionApp.MyWorkoutPlan"></bean>
		
		<bean
		id = "diet_Plan"
		class = "com.NutritionApp.ThursdayDiet">
		
		<!-- constructor injection -->
		
		<constructor-arg ref="my_workouts"/>
		
		</bean>
		
		<bean
		id = "my_Friday"
		class = "com.NutritionApp.FridayDiet">
		
		<!-- setter injection -->
		
		<property name="workouts" ref="my_workouts"/>
		
		<!-- injecting literal values -->
		
		<property name="name" value = "${foo.name}"></property>
		<property name="email_address" value = "${foo.email}"></property>
		
		</bean>

</beans>

//File name : nutritionistInfo.properties

foo.name = "Alex"
foo.email = "Alex07@gmail.com"






