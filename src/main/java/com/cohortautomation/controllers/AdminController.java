package com.cohortautomation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.CohortDAO;
import com.cohortautomation.dao.UserDAO;
import com.cohortautomation.utilities.PasswordGenerator;

@Controller
public class AdminController {

	@RequestMapping("/all-cohort")
	public ModelAndView showAllCohort(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-all-cohort");
		model.addObject("allCohorts", CohortDAO.getAllCohorts());
		return model;
	}

	@RequestMapping("/delete-cohort")
	public ModelAndView deleteACohort(@RequestParam Map<String, String> request, HttpSession session) {
		String cohortId = request.get("cohortId");
		CohortDAO.deleteCohort(cohortId);
		ModelAndView model = new ModelAndView("admin-all-cohort");
		model.addObject("allCohorts", CohortDAO.getAllCohorts());
		return model;
	}

	@RequestMapping("/create-cohort")
	public ModelAndView showCreateCohortPage(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-create-Cohort");
		model.addObject("allSME", UserDAO.getAllSME());
		model.addObject("allMentor", UserDAO.getAllMentor());
		model.addObject("allCoach", UserDAO.getAllCoach());
		model.addObject("allTrainer", UserDAO.getAllTrainer());
		return model;
	}

	@RequestMapping(value = "/create-cohort", method = RequestMethod.POST)
	public String createCohort(@RequestParam Map<String, String> request, HttpSession session) {

		String cohortCode = request.get("cohortCode");
		Date startDate = null;
		String cohortDesc = request.get("cohortDesc");
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			startDate = sdf.parse(request.get("startDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int totalWeeks = Integer.parseInt(request.get("totalWeeks"));
		int trainerID = Integer.parseInt(request.get("trainerID"));
		int coachID = Integer.parseInt(request.get("coachID"));
		int mentorID = Integer.parseInt(request.get("mentorID"));
		int smeID = Integer.parseInt(request.get("smeID"));

		Cohort cohort = new Cohort(cohortCode, cohortDesc, startDate, totalWeeks);

		User SME = UserDAO.getUser(String.valueOf(smeID));
		User mentor = UserDAO.getUser(String.valueOf(mentorID));
		User coach = UserDAO.getUser(String.valueOf(coachID));
		User trainer = UserDAO.getUser(String.valueOf(trainerID));

		cohort.setTrainer(trainer);
		cohort.setCoach(coach);
		cohort.setMentor(mentor);
		cohort.setSME(SME);

		CohortDAO.createCohort(cohort);

		return "redirect:/all-cohort";
	}

	@RequestMapping(value = "/all-sme", method = RequestMethod.GET)
	public ModelAndView showAllSME(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-all-SME");
		model.addObject("allSME", UserDAO.getAllSME());
		return model;
	}

	@RequestMapping(value = "/all-mentor", method = RequestMethod.GET)
	public ModelAndView showAllMentor(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-all-Mentors");
		model.addObject("allMentor", UserDAO.getAllMentor());
		return model;
	}

	@RequestMapping(value = "/all-trainer", method = RequestMethod.GET)
	public ModelAndView showAllTrainer(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-all-Trainer");
		model.addObject("allTrainer", UserDAO.getAllTrainer());
		return model;
	}

	@RequestMapping(value = "/all-coach", method = RequestMethod.GET)
	public ModelAndView showAllCoach(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-all-Coach");
		model.addObject("allCoach", UserDAO.getAllCoach());
		return model;
	}

	@RequestMapping(value = "/create-trainer", method = RequestMethod.GET)
	public String showCreateTrainerPage() {
		return "admin-create-Trainer";
	}

	@RequestMapping(value = "/create-trainer", method = RequestMethod.POST)
	public String createTraine(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordGenerator.getRandomPassword(8), firstName,
				lastName, email);

		user.setSME(false);
		user.setAdmin(false);
		user.setMember(false);
		user.setMentor(false);
		user.setCoach(false);
		user.setTrainer(true);

		UserDAO.createUser(user);

		return "admin-create-Trainer";
	}

	@RequestMapping(value = "/create-coach", method = RequestMethod.GET)
	public String showCreateCoachPage() {
		return "admin-create-Coach";
	}

	@RequestMapping(value = "/create-coach", method = RequestMethod.POST)
	public String createCoach(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordGenerator.getRandomPassword(8), firstName,
				lastName, email);

		user.setSME(false);
		user.setAdmin(false);
		user.setMember(false);
		user.setMentor(false);
		user.setCoach(true);
		user.setTrainer(false);

		UserDAO.createUser(user);

		return "admin-create-Coach";
	}

	@RequestMapping(value = "/create-mentor", method = RequestMethod.GET)
	public String showCreateMentorPage() {
		return "admin-create-Mentor";
	}

	@RequestMapping(value = "/create-mentor", method = RequestMethod.POST)
	public String createMentor(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordGenerator.getRandomPassword(8), firstName,
				lastName, email);

		user.setSME(false);
		user.setAdmin(false);
		user.setMember(false);
		user.setMentor(true);
		user.setCoach(false);
		user.setTrainer(false);

		UserDAO.createUser(user);

		return "admin-create-Mentor";
	}

	@RequestMapping(value = "/create-sme", method = RequestMethod.GET)
	public String showCreateSMEPage() {
		return "admin-create-SME";
	}

	@RequestMapping(value = "/create-sme", method = RequestMethod.POST)
	public String createSME(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordGenerator.getRandomPassword(8), firstName,
				lastName, email);

		user.setSME(true);
		user.setAdmin(false);
		user.setMember(false);
		user.setMentor(false);
		user.setCoach(false);
		user.setTrainer(false);

		UserDAO.createUser(user);

		return "admin-create-SME";
	}

	@RequestMapping(value = "/admin-change-password", method = RequestMethod.GET)
	public ModelAndView showChangePasswordPage(HttpSession session) {
		ModelAndView model = new ModelAndView("admin-change-password");
		return model;
	}

	@RequestMapping(value = "/view-profile", method = RequestMethod.GET)
	public ModelAndView viewProfile(@RequestParam Map<String, String> request, HttpSession session) {
		String username = request.get("username");
		ModelAndView model = new ModelAndView("admin-view-profile");
		User user = UserDAO.getUser(username);

		if (user.isSME()) {
			model.addObject("cohorts", CohortDAO.getAllCohortsForSME(user));
			model.addObject("role", "SME");
		} else if (user.isMentor()) {
			model.addObject("cohorts", CohortDAO.getAllCohortsForMentor(user));
			model.addObject("role", "Mentor");
		} else if (user.isCoach()) {
			model.addObject("cohorts", CohortDAO.getAllCohortsForCoach(user));
			model.addObject("role", "Coach");
		} else if (user.isTrainer()) {
			model.addObject("cohorts", CohortDAO.getAllCohortsForTrainer(user));
			model.addObject("role", "Trainer");
		}

		model.addObject("profile", user);
		return model;
	}

	@RequestMapping(value = "/edit-cohort", method = RequestMethod.POST)
	public ModelAndView editCohort(@RequestParam Map<String, String> request, HttpSession session) {
		String oldCohortId = request.get("oldCohortId");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String cohortCode = request.get("cohortCode");
		Date startDate = null;
		String cohortDesc = request.get("cohortDesc");
		try {
			startDate = sdf.parse(request.get("startDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int totalWeeks = Integer.parseInt(request.get("totalWeeks"));
		int trainerID = Integer.parseInt(request.get("trainerID"));
		int coachID = Integer.parseInt(request.get("coachID"));
		int mentorID = Integer.parseInt(request.get("mentorID"));
		int smeID = Integer.parseInt(request.get("smeID"));

		Cohort cohort = new Cohort(cohortCode, cohortDesc, startDate, totalWeeks);

		User SME = UserDAO.getUser(String.valueOf(smeID));
		User mentor = UserDAO.getUser(String.valueOf(mentorID));
		User coach = UserDAO.getUser(String.valueOf(coachID));
		User trainer = UserDAO.getUser(String.valueOf(trainerID));

		cohort.setTrainer(trainer);
		cohort.setCoach(coach);
		cohort.setMentor(mentor);
		cohort.setSME(SME);

		boolean updateCohort = CohortDAO.updateCohort(oldCohortId, cohort);

		ModelAndView model = new ModelAndView("redirect:/all-cohort");
		return model;
	}

	@RequestMapping(value = "/delete-cohort", method = RequestMethod.GET)
	public ModelAndView deleteCohort(@RequestParam Map<String, String> request, HttpSession session) {
		String cohortId = request.get("cohortId");
		CohortDAO.deleteCohort(cohortId);

		ModelAndView model = new ModelAndView("redirect:/all-cohort");
		return model;
	}

	@RequestMapping(value = "/edit-profile", method = RequestMethod.POST)
	public ModelAndView editProfile(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		boolean updateProfile = UserDAO.updateProfile(employeeID, firstName, lastName, email);

		ModelAndView model = new ModelAndView("redirect:/view-profile?username=" + employeeID);
		return model;
	}

	@RequestMapping(value = "/delete-profile", method = RequestMethod.GET)
	public ModelAndView deleteProfile(@RequestParam Map<String, String> request, HttpSession session) {
		String employeeId = request.get("username");

		boolean result = UserDAO.deleteProfile(employeeId);

		ModelAndView model = new ModelAndView("redirect:/");

		return model;
	}
}
