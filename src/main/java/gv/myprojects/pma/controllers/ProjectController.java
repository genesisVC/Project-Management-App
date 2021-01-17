package gv.myprojects.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gv.myprojects.pma.dto.TimeChartData;
import gv.myprojects.pma.entities.Employee;
import gv.myprojects.pma.entities.Project;
import gv.myprojects.pma.services.EmployeeService;
import gv.myprojects.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjectss(Model model) {
		List<Project> projects =proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Project newProject = new Project();
		
		//get list of employees to pass to dropdown
		Iterable<Employee>employees = empService.getAll();
		
		model.addAttribute("project", newProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Model model, @Valid Project project, Errors errors) {
		
		if(errors.hasErrors()) {
			Iterable<Employee>employees = empService.getAll();
			model.addAttribute("allEmployees", employees);
			return "projects/new-project";
		}
		
		
		
		proService.save(project);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	@GetMapping("/timelines")
	public String displayProjectTimelines(Model model) throws JsonProcessingException {
		
		List<TimeChartData> timelineData=  proService.getTimeData();
		//Convert projectData object into a json structure for use in Javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonTimelineString = objectMapper.writeValueAsString(timelineData);
		
		model.addAttribute("projectTimeList",jsonTimelineString);
		return "projects/project-timelines";
	}
	
	@GetMapping ("/update")
	public String displayProjectUpdateForm(@RequestParam("id") long Id, Model model) {
		Project theProj = proService.findByProjectId(Id);
		model.addAttribute("project", theProj);
		//get list of employees to pass to dropdown
		Iterable<Employee>employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@GetMapping ("/delete")
	public String deleteProjectUpdateForm(@RequestParam("id") long Id, Model model) {
		Project theProj = proService.findByProjectId(Id);
		proService.delete(theProj);
		
		return "redirect:/projects";
	}
	

}
