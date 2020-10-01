package gv.myprojects.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gv.myprojects.pma.dao.iProjectRepository;
import gv.myprojects.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	iProjectRepository proRepo;
	
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
		return "redirect:/new";
	}
	
	
	

}
