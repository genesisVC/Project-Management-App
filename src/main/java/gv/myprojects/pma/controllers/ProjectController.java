package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gv.myprojects.pma.dao.iProjectRepository;
import gv.myprojects.pma.entities.Employee;
import gv.myprojects.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	iProjectRepository proRepo;
	
	@GetMapping
	public String displayProjectss(Model model) {
		List<Project> projects =proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Project newProject = new Project();
		
		model.addAttribute("project", newProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
	
	

}
