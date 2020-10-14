package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gv.myprojects.pma.dao.iEmployeeRepository;
import gv.myprojects.pma.dao.iProjectRepository;
import gv.myprojects.pma.dto.EmployeeProject;
import gv.myprojects.pma.entities.Employee;
import gv.myprojects.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	iProjectRepository proRepo;
	
	@Autowired
	iEmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
	//query the database for projects
	List<Project> projects = proRepo.findAll();
	model.addAttribute("projects",projects);
	
	//query the database for employees
	List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
	model.addAttribute("employeesListProjectCount", employeesProjectCount);
	
	return "main/home";
	}
}
