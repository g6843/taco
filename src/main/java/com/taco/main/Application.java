package com.taco.main;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.eventbus.EventBus;
import com.taco.main.event.LoadAllEvent;
import com.taco.servicesImpl.ServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.taco" })
public class Application implements CommandLineRunner {

	@Autowired
	ServiceImpl serviceImpl;

	@Autowired
	TacoRepository tacoRepository;
	
	@Autowired
	EventBus bus;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//tacoRepository.save(new DatabasePojo("Tasks", serviceImpl.getAllTaTasksCourseWise()));

		Map<String, Object> result = load();
		// tacoRepository.save(new DatabasePojo("People",
		// serviceImpl.getAllPeopleForCourse()));
	}

	public Map<String, Object> load() {
		// get all tas
		// get all profs
		// get all courses

		// for each prof, load all courses taught by him, with TA information
		// and ta tasks
		// for each TA, load all courses he/she a TA for, with people, tasks
		// information.

		
		
		bus.post(new LoadAllEvent());
		return null;
	}
	
	@Bean
	public EventBus eventBus(){
		return new EventBus("Default");
	}

}
