package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String createProject(Project project, Model model) {
		proService.save(project);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/projects";
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
