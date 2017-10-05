package com.taco.servicesImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taco.main.MongoRepository;
import com.taco.main.TacoService;
import com.taco.tacoEntity.Entity;
import com.taco.tacoEntity.TacoAllTAs;
import com.taco.tacoEntity.TacoCourseTAAvailability;
import com.taco.tacoEntity.TacoCourseTAInformation;
import com.taco.tacoEntity.TacoCourseTask;
import com.taco.tacoEntity.TacoDashboard;

@Service
public class MongoService implements TacoService {

	@Autowired
	private MongoRepository repository;

	@Autowired
	private ServiceImpl service;

	public TacoCourseTask[] getTasksForTA(String courseName, String taId) {
		String key = "/data/courseTaTasks.json";
		String k = key + ":" + courseName + ":" + taId;
		Entity e = repository.findOne(k);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoCourseTask[] avail = mapper.readValue(e.getValue(), TacoCourseTask[].class);
			return avail;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoCourseTask[0];
	}

	public TacoDashboard getProfessorDashboardData(String profId) {
		String key = "/data/dashboardData.json";
		String k = key + ":" + profId;
		Entity e = repository.findOne(k);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoDashboard dashboard = mapper.readValue(e.getValue(), TacoDashboard.class);
			return dashboard;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoDashboard();
	}

	public TacoDashboard getTADashboardData(String taId) {
		String key = "/data/dashboardDataTa.json";
		String k = key + ":" + taId;
		Entity e = repository.findOne(k);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoDashboard dashboard = mapper.readValue(e.getValue(), TacoDashboard.class);
			return dashboard;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoDashboard();
	}

	public TacoCourseTask[] getAllTaTasksForCourse(String courseName) {
		String key = "/data/courseTasks.json";
		String k = key + ":" + courseName;
		Entity e = repository.findOne(k);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoCourseTask[] allTaTasks = mapper.readValue(e.getValue(), TacoCourseTask[].class);
			return allTaTasks;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoCourseTask[0];
	}

	public TacoCourseTAInformation[] getTAsInformationForCourse(String courseName) {
		String key = "/data/courseTAs.json";
		String k = key + ":" + courseName;
		Entity e = repository.findOne(k);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoCourseTAInformation[] allTaTasks = mapper.readValue(e.getValue(), TacoCourseTAInformation[].class);
			return allTaTasks;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoCourseTAInformation[0];
	}

	public TacoAllTAs[] getAllTAs() {
		String key = "/data/allTAs.json";
		Entity e = repository.findOne(key);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoAllTAs[] allTaTasks = mapper.readValue(e.getValue(), TacoAllTAs[].class);
			return allTaTasks;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoAllTAs[0];
	}

	@Override
	public TacoCourseTAAvailability[] getAvailabilityForCourseTAs(String courseName) {

		Entity entity = repository.findOne(courseName);
		ObjectMapper mapper = new ObjectMapper();
		try {
			TacoCourseTAAvailability[] avail = mapper.readValue(entity.getValue(), TacoCourseTAAvailability[].class);
			return avail;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new TacoCourseTAAvailability[0];
	}

}
