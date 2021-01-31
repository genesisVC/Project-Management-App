package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gv.myprojects.pma.dto.ChartData;
import gv.myprojects.pma.dto.EmployeeProject;
import gv.myprojects.pma.entities.Project;
import gv.myprojects.pma.services.EmployeeService;
import gv.myprojects.pma.services.ProjectService;

@Controller
public class DashboardController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/dashboard")
	public String displayHome(Model model) throws JsonProcessingException {
		
	//query the database for projects
	List<Project> projects = proService.getAll();
	model.addAttribute("projects",projects);
	
	List<ChartData> projectData = proService.getProjectStatus();
	
	//Convert projectData object into a json structure for use in Javascript
	ObjectMapper objectMapper = new ObjectMapper();
	String jsonString = objectMapper.writeValueAsString(projectData);
	
	model.addAttribute("projectStatusCount", jsonString);
	
	//query the database for employees
	List<EmployeeProject> employeesProjectCount = empService.employeeProjects();
	model.addAttribute("employeesListProjectCount", employeesProjectCount);
	
	return "main/dashboard";
	}
}
