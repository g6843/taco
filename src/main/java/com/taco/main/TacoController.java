package com.taco.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taco.servicesImpl.MongoService;
import com.taco.servicesImpl.ServiceImpl;
import com.taco.tacoEntity.TA;
import com.taco.tacoEntity.TacoAddTa;
import com.taco.tacoEntity.TacoAllTAs;
import com.taco.tacoEntity.TacoCourseTAAvailability;
import com.taco.tacoEntity.TacoCourseTAInformation;
import com.taco.tacoEntity.TacoCourseTask;
import com.taco.tacoEntity.TacoCourseTaskWithCourse;
import com.taco.tacoEntity.TacoDashboard;
import com.taco.tacoEntity.TacoProfCoursesAndRapidTeams;
import com.taco.tacoEntity.TacoUser;
import com.taco.tacoEntity.Url;
import com.taco.wfcEntities.person.Kronos_WFC;

@RestController
public class TacoController {

	@MessageMapping("/taco")
	@SendTo("/topic/tasks")
	public Response notifications(NotificationMessage message) throws Exception {
		Response response = new Response(message.getMessage(), message.getTime());
		return response;
	}

	@Autowired
	ServiceImpl serviceImpl;

	@Autowired
	TacoRepository tacoRepository;

	@Autowired
	MongoService mongoService;

	@RequestMapping(value = "/data/loginUser.json", method = RequestMethod.GET)
	@ResponseBody
	public Url login(@RequestParam String userId) {
		String role = serviceImpl.getUserIdAndRole(userId);
		if (role.equals("Professor"))
			role = "prof";
		else
			role = "ta";
		return new Url("index.html#!/role/" + role + "/id/" + userId);
	}

	@RequestMapping(value = "/data/user.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoUser userInformation(@RequestParam String userId) {
		System.out.println("User id =====" + userId);
		TacoUser user = serviceImpl.getUserInformation(userId);
		return user;
	}

	@RequestMapping(value = "/data/professor.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoProfCoursesAndRapidTeams getCoursesAndRapidTeams(@RequestParam String userId) {
		TacoProfCoursesAndRapidTeams user = serviceImpl.getCoursesAndRapidTeams(userId);
		return user;
	}

	@RequestMapping(value = "/data/courseTAs.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoCourseTAInformation[] getTAsInformationForCourse(@RequestParam String courseName) {
		TacoCourseTAInformation[] temp = null;
		if ((temp = mongoService.getTAsInformationForCourse(courseName)) != null) {
			return temp;
		} else {
			return serviceImpl.getTAsInformationForCourse(courseName);
		}
	}

	@RequestMapping(value = "/data/courseTANames.json", method = RequestMethod.GET)
	@ResponseBody
	public TA[] getAllTaNames(@RequestParam String courseName) {
		return serviceImpl.getAllTaNames(courseName);
	}

	@RequestMapping(value = "/data/dashboardData.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoDashboard getProfessorDashboardData(@RequestParam String userId) {
		TacoDashboard temp = null;
		if ((temp = mongoService.getProfessorDashboardData(userId)) != null) {
			return temp;
		} else {
			return serviceImpl.getProfessorDashboardData(userId);
		}
	}

	@RequestMapping(value = "/data/dashboardDataTa.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoDashboard getTADashboardData(@RequestParam String userId) {
		TacoDashboard temp = null;
		if ((temp = mongoService.getTADashboardData(userId)) != null) {
			return temp;
		} else {
			return serviceImpl.getTADashboardData(userId);
		}
	}

	@RequestMapping(value = "/data/courseTasks.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoCourseTask[] getAllTaTasksForCourse(@RequestParam String courseName, @RequestParam String userId) {
		TacoCourseTask[] temp = null;
		if ((temp = mongoService.getAllTaTasksForCourse(courseName)) != null) {
			return temp;
		} else {
			return serviceImpl.getAllTaTasksForCourse(courseName);
		}
	}

	@RequestMapping(value = "/data/allTAs.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoAllTAs[] getAllTAs(@RequestParam String courseName) {
		TacoAllTAs[] temp = null;
		if ((temp = mongoService.getAllTAs()) != null) {
			return temp;
		} else {
			return serviceImpl.getAllTAs();
		}
	}

	@RequestMapping(value = "/data/courseTAAvailability.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoCourseTAAvailability[] getAvailabilityForCourseTAs(@RequestParam String courseName) {
		return serviceImpl.getAvailabilityForCourseTAs(courseName);
	}

	@RequestMapping(value = "/data/courseTaTasks.json", method = RequestMethod.GET)
	@ResponseBody
	public TacoCourseTask[] getTasksForTA(@RequestParam String courseName, @RequestParam String userId) {
		TacoCourseTask[] temp = null;
		if ((temp = mongoService.getTasksForTA(courseName, userId)) != null) {
			return temp;
		} else {
			return serviceImpl.getTasksForTA(courseName, userId);
		}
	}

	@RequestMapping(value = "/data/saveTask.json", method = RequestMethod.POST)
	public Kronos_WFC saveTaskForTA(@RequestBody TacoCourseTaskWithCourse courseTask) {
		return serviceImpl.createTaskForTA(courseTask.getCourseName(),
				new TacoCourseTask(courseTask.getId(), courseTask.getDoneHours(), courseTask.getStatus(),
						courseTask.getPriority(), courseTask.getHours(), courseTask.getTa(), courseTask.getName(),
						courseTask.getTaId()));
	}

	@RequestMapping(value = "/data/deleteTask.json", method = RequestMethod.POST)
	public Kronos_WFC deleteTasksForTA(@RequestBody TacoCourseTaskWithCourse courseTask) {
		System.out.println("In Method");
		return serviceImpl.deleteTaskForTA(courseTask.getCourseName(),
				new TacoCourseTask(courseTask.getId(), courseTask.getDoneHours(), courseTask.getStatus(),
						courseTask.getPriority(), courseTask.getHours(), courseTask.getTa(), courseTask.getName(),
						courseTask.getTaId()));
	}

	@RequestMapping(value = "/data/addTa.json", method = RequestMethod.POST)
	public Kronos_WFC addTa(@RequestBody TacoAddTa tacoAddTa) {
		return serviceImpl.addTa(tacoAddTa.getCourseName(), tacoAddTa.getTaId());
	}

	@RequestMapping(value = "/data/saveTaTask.json", method = RequestMethod.POST)
	public TacoCourseTask saveTaTaskForCourse(@RequestBody TacoCourseTaskWithCourse courseTask) {
		return serviceImpl.saveTaTaskForCourse(courseTask.getCourseName(),
				new TacoCourseTask(courseTask.getId(), courseTask.getDoneHours(), courseTask.getStatus(),
						courseTask.getPriority(), courseTask.getHours(), courseTask.getTa(), courseTask.getName(),
						courseTask.getTaId()));
	}

	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	@ResponseBody
	public TacoDashboard getProfessorDashboardData() {
		String userId = "1234567";
		return serviceImpl.getProfessorDashboardData(userId);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Kronos_WFC test() {
		System.out.println("In Method");
		TacoAddTa tacoAddTa = new TacoAddTa("11001", "COM S 104");
		return serviceImpl.addTa(tacoAddTa.getCourseName(), tacoAddTa.getTaId());
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	@ResponseBody
	public Kronos_WFC test2() {
		System.out.println("In Method");
		TacoCourseTaskWithCourse courseTask = new TacoCourseTaskWithCourse("COM S 104", "111", "0", "Not Started",
				"low", "2", "Diana Graham", "Assignment Grading", "11001");
		return serviceImpl.createTaskForTA(courseTask.getCourseName(),
				new TacoCourseTask(courseTask.getId(), courseTask.getDoneHours(), courseTask.getStatus(),
						courseTask.getPriority(), courseTask.getHours(), courseTask.getTa(), courseTask.getName(),
						courseTask.getTaId()));
	}

	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	@ResponseBody
	public Kronos_WFC test3() {
		System.out.println("In Method");
		TacoCourseTaskWithCourse courseTask = new TacoCourseTaskWithCourse("COM S 104", "111", "0", "Not Started",
				"low", "4", "Jake Clark", "Problem Solving", "11003");
		return serviceImpl.deleteTaskForTA(courseTask.getCourseName(),
				new TacoCourseTask(courseTask.getId(), courseTask.getDoneHours(), courseTask.getStatus(),
						courseTask.getPriority(), courseTask.getHours(), courseTask.getTa(), courseTask.getName(),
						courseTask.getTaId()));
	}
}
