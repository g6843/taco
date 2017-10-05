package com.taco.main.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.taco.main.MongoRepository;
import com.taco.servicesImpl.ServiceImpl;
import com.taco.tacoEntity.Entity;
import com.taco.tacoEntity.TacoAllTAs;
import com.taco.tacoEntity.TacoCourseTAInformation;
import com.taco.tacoEntity.TacoCourseTask;
import com.taco.tacoEntity.TacoDashboard;

@Service
public class MongoEventHandler {

	@Autowired
	private MongoRepository repository;

	@Autowired
	private EventBus eventBus;

	@Autowired
	private ServiceImpl serviceImpl;

	Map<String, List<String>> userCache = Maps.newHashMap();

	@Subscribe
	public void loadPeople(LoadPeopleEventOnAddTA event) {
		String key5 = "/data/courseTAs.json";
		List<String> courses = new ArrayList<String>();
		courses.add("COM S 104");
		courses.add("COM S 105");
		courses.add("COM S 107");
		courses.add("COM S 109");
		courses.stream().forEach(c -> {
			TacoCourseTAInformation[] allTAs = serviceImpl.getTAsInformationForCourse(c);
			String k = key5 + ":" + c;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(allTAs);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	@Subscribe
	public void loadDashboard(LoadDashboardEvent event) {

		List<String> profs = userCache.get("PROF");
		List<String> tas = userCache.get("TA");

		String key2 = "/data/dashboardData.json";
		profs.stream().forEach(p -> {
			TacoDashboard dashboard = serviceImpl.getProfessorDashboardData(p);
			String k = key2 + ":" + p;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(dashboard);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	@Subscribe
	public void loadTasksForProfView(LoadTasksEvent event) {

		List<String> courses = new ArrayList<String>();
		courses.add("COM S 104");
		courses.add("COM S 105");

		String key4 = "/data/courseTasks.json";
		courses.stream().forEach(c -> {
			TacoCourseTask[] dashboard = serviceImpl.getAllTaTasksForCourse(c);
			String k = key4 + ":" + c;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(dashboard);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	@Subscribe
	public void loadAll(LoadAllEvent event) {

		// course ta availability
		Lists.newArrayList("COM S 104", "COM S 107").stream().forEach(s -> {
			Entity e = new Entity(get(s), s);
			repository.save(e);
		});

		List<String> profs = serviceImpl.getAllProfessorsUsingHyperfind();
		List<String> tas = serviceImpl.getAllTAsUsingHyperfind();

		userCache.put("PROF", profs);
		userCache.put("TA", tas);

		List<String> courses = new ArrayList<String>();
		courses.add("COM S 104");
		courses.add("COM S 105");
		courses.add("COM S 107");
		courses.add("COM S 109");
		System.out.println("===========In LoadAll");
		//
		String key = "/data/courseTaTasks.json";
		tas.stream().forEach(t -> {
			courses.stream().forEach(c -> {
				TacoCourseTask[] tasks = serviceImpl.getTasksForTA(c, t);
				String k = key + ":" + c + ":" + t;

				ObjectMapper om = new ObjectMapper();
				String s;
				try {
					s = om.writeValueAsString(tasks);
					Entity e = new Entity(s, k);
					repository.save(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			});
		});

		String key2 = "/data/dashboardData.json";
		profs.stream().forEach(p -> {
			TacoDashboard dashboard = serviceImpl.getProfessorDashboardData(p);
			String k = key2 + ":" + p;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(dashboard);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		String key3 = "/data/dashboardDataTa.json";
		tas.stream().forEach(t -> {
			TacoDashboard dashboard = serviceImpl.getTADashboardData(t);
			String k = key3 + ":" + t;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(dashboard);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		String key4 = "/data/courseTasks.json";
		courses.stream().forEach(c -> {
			TacoCourseTask[] dashboard = serviceImpl.getAllTaTasksForCourse(c);
			String k = key4 + ":" + c;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(dashboard);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		String key5 = "/data/courseTAs.json";
		courses.stream().forEach(c -> {
			TacoCourseTAInformation[] allTAs = serviceImpl.getTAsInformationForCourse(c);
			String k = key5 + ":" + c;

			ObjectMapper om = new ObjectMapper();
			String s;
			try {
				s = om.writeValueAsString(allTAs);
				Entity e = new Entity(s, k);
				repository.save(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		String key6 = "/data/allTAs.json";
		TacoAllTAs[] allTAs = serviceImpl.getAllTAs();
		String k = key6;

		ObjectMapper om = new ObjectMapper();
		String s;
		try {
			s = om.writeValueAsString(allTAs);
			Entity e = new Entity(s, k);
			repository.save(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private String get(String courseName) {
		if (courseName.equals("COM S 104")) {
			return "[{\"id\": 1,\"name\": \"abbc\",\"courseHours\": 10,\"availableHours\": 2}, {\"id\": 2,\"name\": \"abbcdd\",\"courseHours\": 20,\"availableHours\": 2},{\"id\": 1,\"name\": \"bcde\",\"courseHours\": 12,\"availableHours\": 4}, {\"id\": 2,\"name\": \"cdbe\",\"courseHours\": 15,\"availableHours\": 2} ]";
		}
		return "[{\"id\": 1,\"name\": \"bcde\",\"courseHours\": 12,\"availableHours\": 4}, {\"id\": 2,\"name\": \"cdbe\",\"courseHours\": 15,\"availableHours\": 2} ]";

	}

	@PostConstruct
	public void initIt() throws Exception {
		eventBus.register(this);
	}
}
